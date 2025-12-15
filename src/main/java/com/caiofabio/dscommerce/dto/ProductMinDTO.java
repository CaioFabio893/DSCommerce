package com.caiofabio.dscommerce.dto;

import com.caiofabio.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {

// validaçao ocorre no dto

    private Long id;
    private String name;
    private Double price;
    private String imgUrl;


    public ProductMinDTO(){}


    public ProductMinDTO( Long id, String imgUrl, String name, Double price) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        imgUrl = entity.getImgUrl();
        name = entity.getName();
        price = entity.getPrice();
    }




    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
