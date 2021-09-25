package com.gb.data.springdata.controllers;

import com.gb.data.springdata.entities.Product;
import com.gb.data.springdata.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class ProductMVCController {

    private final IProductRepository repository;

    @GetMapping
    public String findAll(Model model){
        List<Product> products = new ArrayList<>(repository.findAll());
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping()
    public String save(@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product-add";
        }
        repository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/form")
    public String saveForm(Product product){
        return "product-add";
    }

    @DeleteMapping("/{id}")
    public String delete(Model model, @PathVariable String id){
        repository.deleteById(Long.parseLong(id));
        return "redirect:/products";
    }


}
