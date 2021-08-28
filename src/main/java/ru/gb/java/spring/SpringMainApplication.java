package ru.gb.java.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.java.spring.cfgs.ContextConfiguration;
import ru.gb.java.spring.repositories.ProductRepository;
import ru.gb.java.spring.services.Cart;

import java.util.Scanner;

public class SpringMainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Cart cart = context.getBean(Cart.class);
        Cart alterCart = context.getBean(Cart.class);
        System.out.println("cart 1 hash: " + cart.hashCode() + " cart 2 hash: " + alterCart.hashCode());


        ProductRepository repository = context.getBean(ProductRepository.class);
        System.out.println(repository.getProducts().toString());


        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество продуктов, которое хотите добавить в корзину");
        int addCounter = sc.nextInt();

        while (addCounter > 0){
            System.out.println("Введите id продукта, который хотите добавить в корзину");
            cart.addProductById(sc.nextInt());
            System.out.println(cart.getCartProducts());
            addCounter--;
        }

        System.out.println("Введите количество продуктов, которое хотите удалить из корзины");
        int deleteCounter = sc.nextInt();

        while (deleteCounter > 0){
            System.out.println("Введите id продукта, который хотите добавить в корзину");
            cart.deleteProductById(sc.nextInt());
            System.out.println(cart.getCartProducts());
            deleteCounter--;
        }

    }
}
