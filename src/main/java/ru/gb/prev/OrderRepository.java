package ru.gb.prev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>(
                List.of(
                        new Order(1, LocalDateTime.now(), 132, Collections.emptyList())
                )
        );
    }

    public Optional<Order> findById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst();
    }

    public List<Order> findAll() {
        return orders;
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    public void delete(Order order){
        this.orders.remove(order);
    }


    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + orders +
                '}';
    }
}
