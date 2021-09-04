package ru.gb.current.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.prev.Product;
import ru.gb.prev.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(repository.findById(Integer.parseInt(id)).orElseThrow());
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "products-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String add(Product product) {
        repository.add(product);
        return "products";
    }

}
