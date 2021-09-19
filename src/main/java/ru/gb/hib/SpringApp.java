package ru.gb.hib;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.hib.config.SpringConfiguration;
import ru.gb.hib.services.CustomerService;

public class SpringApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CustomerService service = context.getBean(CustomerService.class);
        System.out.println(service.getProductsList(1));
    }

}
