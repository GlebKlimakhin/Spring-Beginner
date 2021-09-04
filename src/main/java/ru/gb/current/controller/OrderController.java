package ru.gb.current.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.prev.Order;
import ru.gb.prev.OrderRepository;

public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("orders", repository.findAll());
        return "orders";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        repository.delete(repository.findById(Integer.parseInt(id)).orElseThrow(RuntimeException::new));
        return "redirect:/orders";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("order", new Order());
        return "orders-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String add(Order order) {
        repository.add(order);
        return "orders";
    }
}
