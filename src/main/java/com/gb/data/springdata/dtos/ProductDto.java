package com.gb.data.springdata.dtos;

import com.gb.data.springdata.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductDto {

    private long id;
    private String title;
    private int price;

    public ProductDto(Product product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }
}
