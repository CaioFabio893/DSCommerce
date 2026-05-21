package com.caiofabio.dscommerce.tests;

import com.caiofabio.dscommerce.entities.Category;
import com.caiofabio.dscommerce.entities.Product;

public class ProductFactory {

    public static Product createProduct() {
        Category category = CategoryFactory.creatCategory();
        Product product = new Product( "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                , 1L, "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg", "Console PlayStation 5,",3999.0);
        product.getCategory().add(category);
        return product;
    }

    public static Product createProduct(String name){
        Product product = createProduct();
        product.setName(name);
        return product;
    }
}
