package com.learning.dto;

import com.learning.model.Games;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellersDto {
    private Long id;
    private String sellerName;

    private List<Games> games;
}
