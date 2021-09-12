package ru.gb.hib.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gb.hib.entities.Product;
import ru.gb.hib.dao.ProductDao;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductDao dao;

    public ProductController(ProductDao productDao) {
        this.dao = productDao;
    }

    @GetMapping()
    public List<Product> getAll(){
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product getByid(@PathVariable String id){
        return dao.findById(Long.parseLong(id)).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public void save(@RequestParam Product product){
        dao.save(product);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable String id, @RequestParam Product product){
        dao.update(Long.parseLong(id), product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        dao.delete(Long.parseLong(id));
    }


}
