package ru.gb.spring.controllers;

import ru.gb.spring.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.repositories.OrderRepository;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    @ResponseBody
    public List<Order> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order findById(@PathVariable long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping()
    public void save(@RequestBody Order order){
        repository.save(order);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        repository.delete(id);
    }
}
