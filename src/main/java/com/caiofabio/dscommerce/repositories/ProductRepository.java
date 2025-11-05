package com.caiofabio.dscommerce.repositories;

import com.caiofabio.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //JPDL
    @Query("SELECT obj FROM Product obj " +
            " WHERE UPPER(obj.name)  LIKE UPPER(CONCAT('%', :name, '%')) ")
    Page<Product> searchByName(String name, Pageable pageable);

//   SQL RAIZ
//   @Query(nativeQuery = true, value = "SELECT * " +
//           "FROM tb_product " +
//           "WHERE  UPPER(name) LIKE UPPER(CONCAT('%', :name, '%')) ",
//            countQuery = "SELECT COUNT(*) " +
//                    "FROM tb_product " +
//                    "WHERE UPPER(name) LIKE UPPER(CONCAT('%', :name, '%'))")
//   Page<Product> searchByName(@Param("name") String name, Pageable pageable);

}
