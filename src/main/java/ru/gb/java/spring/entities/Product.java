package ru.gb.java.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Product {

    private long id;
    private String title;
    private int price;


}
