package com.gb.data.springdata.repositories;

import com.gb.data.springdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(int min, int max);

    List<Product> findAllByPriceGreaterThan(int min);

    List<Product> findAllByPriceLessThan(int min);

    Optional<Product> findByTitleContaining(String part);

}
