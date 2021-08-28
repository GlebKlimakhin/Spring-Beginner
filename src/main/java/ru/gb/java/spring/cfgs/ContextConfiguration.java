package ru.gb.java.spring.cfgs;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.java.spring.repositories.ProductRepository;
import ru.gb.java.spring.services.Cart;

@Configuration
public class ContextConfiguration {

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cart cart(ProductRepository productRepository){
        return new Cart(productRepository);
    }




}
