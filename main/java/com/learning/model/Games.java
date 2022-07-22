package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Games implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_year")
    private Integer gameYear;

    @Column(name = "seller_id")
    private Long seller_id;

   /*@ManyToOne
    @JoinColumn(name = "seller_id", insertable = false, updatable = false)
    private Sellers seller;*/
}
