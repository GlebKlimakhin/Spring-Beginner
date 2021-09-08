package ru.gb.spring.repositories;

import ru.gb.spring.entities.Order;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@ToString
public class OrderRepository {

    List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
        Collections.addAll(orders,
                new Order(1, LocalDateTime.now(), 43.3f, Collections.emptyList()),
                new Order(2, LocalDateTime.now(), 45.3f, Collections.emptyList()),
                new Order(3, LocalDateTime.now(), 436.3f, Collections.emptyList()),
                new Order(4, LocalDateTime.now(), 413.3f, Collections.emptyList())
                );
    }

    public List<Order> findAll(){
        return orders;
    }

    public Optional<Order> findById(long id){
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }

    public void delete(long id){
        orders.remove(findById(id).orElseThrow(RuntimeException::new));
    }

    public void save(Order order){
        orders.add(order);
    }
}
