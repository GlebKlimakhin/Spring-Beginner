package ru.gb.prev;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ProductRepository repository;
    private List<Product> products;

    public Cart(ProductRepository repository) {
        this.repository = repository;
        this.products = new ArrayList<>();
    }

    public void add(int id) {
        repository.findById(id).ifPresent(p -> products.add(p));
    }

    public void remove(int id) {
        products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(p -> products.remove(p));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "repository=" + repository +
                ", products=" + products +
                '}';
    }
}
