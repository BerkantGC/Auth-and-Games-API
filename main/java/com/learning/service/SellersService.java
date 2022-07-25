package com.learning.service;

import com.learning.dto.GamesDto;
import com.learning.dto.SellersDto;
import com.learning.model.Games;
import com.learning.model.Sellers;
import com.learning.repository.GamesRepository;
import com.learning.repository.SellersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellersService {
    private final SellersRepository sellersRepository;
    private final GamesRepository gamesRepository;

    public SellersService(SellersRepository sellersRepository, GamesRepository gamesRepository) {
        this.sellersRepository = sellersRepository;
        this.gamesRepository = gamesRepository;
    }

        public SellersDto save(SellersDto sellersDto){
            Sellers sellers = new Sellers();
            sellers.setSellerName(sellersDto.getSellerName());

            final Sellers sellerDb = sellersRepository.save(sellers);
            List<Games> gamesList = new ArrayList<>();

            sellersDto.getGames().forEach(item->{
                Games games = new Games();
                games.setGameName(item.getGameName());
                games.setGameYear(item.getGameYear());
                games.setSeller_id(sellerDb.getId());
                games.setImageUrl(item.getImageUrl());
                gamesList.add(games);
            });
            gamesRepository.saveAll(gamesList);
            sellersDto.setId(sellerDb.getId());
            return sellersDto;
        }

        public List<Sellers> update(Sellers sellers)
        {
            List<Sellers> sellersList = sellersRepository.findAll();
            sellersList.forEach(item->{
                if (item.getSellerName().equals(sellers.getSellerName())) {
                    List<Games> gamesList = new ArrayList<>();

                    sellers.getGames().forEach(it->{
                        Games games = new Games();
                        games.setGameName(it.getGameName());
                        games.setGameYear(it.getGameYear());
                        games.setSeller_id(item.getId());
                        games.setImageUrl(it.getImageUrl());
                        gamesList.add(games);
                    });
                    gamesRepository.saveAll(gamesList);
                }
            });

            return sellersList;
        }

        public List<SellersDto> getAll()
        {
            List<Sellers> sellersList = sellersRepository.findAll();
            List<SellersDto> sellersDtoList = new ArrayList<>();

            sellersList.forEach(item->{
                SellersDto sellersDto = new SellersDto();
                sellersDto.setSellerName(item.getSellerName());
                sellersDto.setId(item.getId());
                sellersDto.setGames(item.getGames().stream().collect(Collectors.toList()));
                sellersDtoList.add(sellersDto);
            });
            return sellersDtoList;
        }

        public Page<Games> getAll(Pageable pageable) {
            return null;
        }

}
