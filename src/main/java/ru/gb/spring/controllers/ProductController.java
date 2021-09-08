package ru.gb.spring.controllers;

import ru.gb.spring.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.repositories.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    @ResponseBody
    public List<Product> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Product findById(@PathVariable long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping()
    public void save(@RequestBody Product product){
        repository.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        repository.delete(id);
    }
}
