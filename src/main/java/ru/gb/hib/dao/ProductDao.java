package ru.gb.hib.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ru.gb.hib.entities.Product;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao {


    private EntityManager entityManager;

    public ProductDao() {

    }

    @PostConstruct
    private void init(){
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();
        entityManager = factory.createEntityManager();
    }

    public Optional<Product> findById(long id){
        return Optional.ofNullable(
                entityManager.find(Product.class, id)
        );
    }

    public List<Product> findAll(){
        return entityManager.createQuery("select product from Product as product").getResultList();
    }

    public void save(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public void update(long id, Product product){
        entityManager.getTransaction().begin();
        Product initialProduct = entityManager.find(Product.class, id);
        initialProduct = product;
        entityManager.persist(initialProduct);
        entityManager.getTransaction().commit();
    }

    public void delete(long id){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class, id));
        entityManager.getTransaction().commit();
    }
}
