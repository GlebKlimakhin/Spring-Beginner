package ru.gb.hib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.hib.dao.CustomerDao;
import ru.gb.hib.dao.ProductDao;
import ru.gb.hib.services.CustomerService;
import ru.gb.hib.services.ProductService;

@Configuration
public class SpringConfiguration {

    @Bean
    public CustomerDao customerDaoo(){
        return new CustomerDao();
    }

    @Bean
    public ProductDao productDao(){
        return new ProductDao();
    }

    @Bean
    public ProductService productService(ProductDao productDao){
        return new ProductService(productDao);
    }

    @Bean
    public CustomerService customerService(CustomerDao customerDao){
        return new CustomerService(customerDao);
    }

}
