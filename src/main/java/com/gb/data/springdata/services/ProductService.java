package com.gb.data.springdata.services;

import com.gb.data.springdata.dtos.ProductDto;
import com.gb.data.springdata.entities.Product;
import com.gb.data.springdata.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository repository;

    public Optional<ProductDto> findById(String id){
        return repository.findById(Long.parseLong(id)).map(ProductDto::new);
    }

    public List<ProductDto> findAll(){
        return repository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Product save(Product product){
       return repository.save(product);
    }

    public void delete(Product product){
        repository.delete(product);
    }

    public void deleteById(String id){
        repository.deleteById(Long.parseLong(id));
    }

    public Optional<Product> findByTitleContaining(String part){
        return repository.findByTitleContaining(part);
    }

    public List<Product> findAllByPriceBetween(int min, int max){
        return repository.findAllByPriceBetween(min, max);
    }

    public List<Product> findAllByPriceGreaterThan(int min){
        return repository.findAllByPriceGreaterThan(min);
    }

    public List<Product> findAllByPriceLessThan(int max){
        return repository.findAllByPriceLessThan(max);
    }
}
