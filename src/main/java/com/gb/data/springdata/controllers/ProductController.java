package com.gb.data.springdata.controllers;

import com.gb.data.springdata.entities.Product;
import com.gb.data.springdata.repositories.IProductRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductRepository repository;

    public ProductController(IProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    private List<Product> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    private Product findById(@PathVariable String id){
        return repository.findById(Long.parseLong(id)).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    private Product save(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable String id){
        repository.deleteById(Long.parseLong(id));
    }

    @GetMapping("/{cost1}/{cost2}")
    private List<Product> findAllBetween(@PathVariable String cost1, @PathVariable String cost2){
        return repository.getAllByPriceBetween(Integer.parseInt(cost1), Integer.parseInt(cost2));
    }

    @GetMapping("/greater/{min}")
    private List<Product> findAllByPriceGreaterThan(@PathVariable String min){
        return repository.getAllByPriceGreaterThan(Integer.parseInt(min));
    }

    @GetMapping("/less/{max}")
    private List<Product> findAllByPriceLessThan(@PathVariable String max){
        return repository.getAllByPriceLessThan(Integer.parseInt(max));
    }

    @GetMapping("/search/{part}")
    private Product findByPartOfTitle(@PathVariable String part){
        return repository.getByTitleContaining(part).orElseThrow(RuntimeException::new);
    }

}
