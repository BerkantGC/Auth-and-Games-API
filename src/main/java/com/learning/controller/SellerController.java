package com.learning.controller;

import com.learning.dto.SellersDto;
import com.learning.model.Sellers;
import com.learning.service.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SellerController {
    @Autowired
    private SellersService sellersService;

    @PostMapping("/sellers")
    public ResponseEntity<SellersDto> save(@RequestBody SellersDto sellersDto)
    {
        return ResponseEntity.ok(sellersService.save(sellersDto));
    }

    @PutMapping("/sellers")
    public ResponseEntity<List<Sellers>> update(@RequestBody Sellers sellers)
    {
        System.out.println(sellers);
        return ResponseEntity.ok(sellersService.update(sellers));
    }

    @GetMapping("/sellers")
    public ResponseEntity<List<SellersDto>> showAll(){
        return ResponseEntity.ok(sellersService.getAll());
    }
}
