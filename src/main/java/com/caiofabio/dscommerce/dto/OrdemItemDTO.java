package com.caiofabio.dscommerce.dto;

import com.caiofabio.dscommerce.entities.OrderItem;

public class OrdemItemDTO {

    private Long productId;
    private String name;
    private Double price;
    private Integer qunatity;

    public OrdemItemDTO(){}

    public OrdemItemDTO(Long productId, String name, Double price, Integer qunatity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.qunatity = qunatity;
    }

    public OrdemItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        qunatity = entity.getQuantity();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQunatity() {
        return qunatity;
    }


    public Double getSubTotal(){
        return price * qunatity;
    }
}
