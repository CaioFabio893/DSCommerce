package com.caiofabio.dscommerce.repositories;

import com.caiofabio.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
