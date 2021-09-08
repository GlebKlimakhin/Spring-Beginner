package ru.gb.spring.repositories;

import ru.gb.spring.entities.Product;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@ToString
public class ProductRepository {

    List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
        Collections.addAll(products,
                new Product(1, "table", 43.3f),
                new Product(2, "chair", 43.34f),
                new Product(3, "plate", 13.3f)
        );
    }

    public List<Product> findAll(){
        return products;
    }

    public Optional<Product> findById(long id){
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public void delete(long id){
        products.remove(findById(id).orElseThrow(RuntimeException::new));
    }

    public void save(Product product){
        products.add(product);
    }
}
