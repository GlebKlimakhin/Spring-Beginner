package ru.gb.hib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hib.dao.CustomerDao;
import ru.gb.hib.dao.ProductDao;
import ru.gb.hib.entities.Customer;
import ru.gb.hib.entities.Product;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerDao dao;

    public CustomerService(CustomerDao dao) {
        this.dao = dao;
    }

    public Customer findById(long id){
        return dao.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Customer> findAll(){
        return dao.findAll();
    }

    public void save(Customer customer){
        dao.save(customer);
    }

    public void deleteById(long id){
        dao.deleteById(id);
    }

    public void delete(Customer customer){
        dao.delete(customer);
    }

    public Optional<List<Product>> getProductsList(long id){
        Optional<Customer> customer = dao.findById(id);
        if(customer.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(
                customer.get().getProducts());
    }



}
