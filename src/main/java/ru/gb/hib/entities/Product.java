package ru.gb.hib.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product(String title, int price, List<Customer> customers) {
        this.title = title;
        this.price = price;
        this.customers = customers;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_customers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

    @Override
    public String toString(){
        return "id  " + this.id +
        " title " + this.title +
        " price " + this.price;
    }

    

}
