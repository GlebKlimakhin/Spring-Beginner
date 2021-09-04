package ru.gb.prev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public Cart cart(ProductRepository productRepository) {
        return new Cart(productRepository);
    }

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository();
    }
}
