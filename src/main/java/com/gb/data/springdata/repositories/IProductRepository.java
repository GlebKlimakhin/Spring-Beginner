package com.gb.data.springdata.repositories;

import com.gb.data.springdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> getAllByPriceBetween(int min, int max);

    List<Product> getAllByPriceGreaterThan(int min);

    List<Product> getAllByPriceLessThan(int min);

    Optional<Product> getByTitleContaining(String part);

}
