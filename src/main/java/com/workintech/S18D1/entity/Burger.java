package com.workintech.S18D1.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "burger", schema = "spring")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;
    @Column(name = "price")
    @DecimalMin("20")
    private int price;
    @Column(name = "is_Vegan")
    private boolean isVegan;
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name = "contents")
    private List<String> contents;
}
