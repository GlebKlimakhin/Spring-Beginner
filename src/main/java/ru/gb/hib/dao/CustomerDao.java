package ru.gb.hib.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ru.gb.hib.entities.Customer;
import ru.gb.hib.entities.Product;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDao {


    private EntityManager entityManager;

    public CustomerDao() {

    }

    @PostConstruct
    private  void init(){
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory();
        entityManager = factory.createEntityManager();
    }

    public Optional<Customer> findById(long id){
        return Optional.ofNullable(
                entityManager.find(Customer.class, id)
        );
    }

    public List<Customer> findAll(){
        return entityManager.createQuery("select customer from Customer as customer").getResultList();
    }

    public void save(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public void update(long id, Customer customer){
        entityManager.getTransaction().begin();
        Customer initialProduct;
        initialProduct = customer;
        entityManager.merge(initialProduct);
        entityManager.getTransaction().commit();
    }

    public void deleteById(long id){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Customer.class, id));
        entityManager.getTransaction().commit();
    }

    public void delete(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
    }


}

/**
 * 1. В базе данных необходимо реализовать возможность хранить информацию о покупателях (id, имя) и товарах (id, название, стоимость). У каждого покупателя свой набор купленных товаров;
 * 2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
 * 3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров, и по id товара узнавать список покупателей этого товара;
 * 4. ** Добавить детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом;
 * ВАЖНО И ОБЯЗАТЕЛЬНО! Dao классы и сервис должны являться Spring бинами (Вам нужен Spring Context без веб части). Контроллеры создавать не надо.
 * ВАЖНО! Выкидываете код по подготовке данных и таблиц, и делаете отдельный скрипт и формируете базу заранее. Покупателей и товары в базу складываете заранее, через код этого делать не надо (лишнее усложнение). SQL-скрипт прикрепите к работе.
 */
