package com.caiofabio.dscommerce.dto;

import com.caiofabio.dscommerce.entities.Product;
import jakarta.persistence.Column;

public class ProductDTO {


    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO(){
    }

    public ProductDTO(String description, Long id, String imgUrl, String name, Double price) {
        this.description = description;
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product entity) {
        description = entity.getDescription();
        id = entity.getId();
        imgUrl = entity.getImgUrl();
        name = entity.getName();
        price = entity.getPrice();
    }


    public String getDescription() {
        return description;
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
