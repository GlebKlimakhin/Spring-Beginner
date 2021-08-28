package ru.gb.java.spring.utill;

import ru.gb.java.spring.entities.Product;

import java.util.Random;

public class RandomProductsGenerator {

    public static Product generateRandomProduct(){
        Random rand = new Random();
        long id = (long) (Math.random() * (1000));
        int price = rand.nextInt(1000);
        return new Product(id, "testTitle" + id, price);
    }

}
