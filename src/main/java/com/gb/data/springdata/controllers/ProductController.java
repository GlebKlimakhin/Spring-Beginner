package com.gb.data.springdata.controllers;

import com.gb.data.springdata.dtos.ProductDto;
import com.gb.data.springdata.entities.Product;
import com.gb.data.springdata.exceptions.ResourceNotFoundException;
import com.gb.data.springdata.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @GetMapping()
    private ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    private ProductDto findById(@PathVariable String id) throws ResourceNotFoundException {
        return service.findById(id).orElseThrow(() -> new ResourceNotFoundException("The product with given id not found"));

    }

    @PostMapping
    private ResponseEntity<Product> save(@RequestBody Product product){
        Product created = service.save(product);
        return ResponseEntity.created(URI.create("/products/" + created.getId())).body(created);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Product> deleteById(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cost1}/{cost2}")
    private ResponseEntity<List<Product>> findAllBetween(@PathVariable String cost1, @PathVariable String cost2){
        return ResponseEntity.ok(service.findAllByPriceBetween(Integer.parseInt(cost1), Integer.parseInt(cost2)));
    }

//    @GetMapping("/greater/{min}")
//    private List<Product> findAllByPriceGreaterThan(@PathVariable String min){
//        return service.findAllByPriceGreaterThan(Integer.parseInt(min));
//    }
//
//    @GetMapping("/less/{max}")
//    private List<Product> findAllByPriceLessThan(@PathVariable String max){
//        return service.findAllByPriceLessThan(Integer.parseInt(max));
//    }
//
//    @GetMapping("/search/{part}")
//    private Product findByPartOfTitle(@PathVariable String part){
//        return service.findByTitleContaining(part).orElseThrow(RuntimeException::new);
//    }

}
