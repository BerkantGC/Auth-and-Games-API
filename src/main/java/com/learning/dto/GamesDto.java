package com.learning.dto;

import com.learning.model.Sellers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamesDto {
    private String gameName;
    private Integer year;
}
