package ru.gb.hib.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_customers",
    joinColumns = @JoinColumn(name = "customer_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Customer(String name, List<Product> products, String email) {
        this.name = name;
        this.products = products;
        this.email = email;
    }

    @Override
    public String toString(){
        return "id  " + this.id +
                " title " + this.name +
                " price " + this.email;
    }
}
