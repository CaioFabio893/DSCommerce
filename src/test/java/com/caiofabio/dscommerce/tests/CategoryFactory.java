package com.caiofabio.dscommerce.tests;

import com.caiofabio.dscommerce.entities.Category;

public class CategoryFactory {

    public static Category creatCategory(){
        return new Category(1L, "Games");
    }

    public static Category creatCategory(Long id, String name){
        return new Category(id,name);
    }

}
