package com.caiofabio.dscommerce.services;


import com.caiofabio.dscommerce.dto.ProductDTO;
import com.caiofabio.dscommerce.dto.ProductMinDTO;
import com.caiofabio.dscommerce.entities.Product;
import com.caiofabio.dscommerce.repositories.ProductRepository;
import com.caiofabio.dscommerce.services.exceptions.DatabaseException;
import com.caiofabio.dscommerce.services.exceptions.ResourceNotFoundException;
import com.caiofabio.dscommerce.tests.ProductFactory;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private long existingProductId, nonExistingProductId, dependentId;
    private String productName;
    private Product product;
    private ProductDTO productDTO;
    private PageImpl<Product> page;

    @BeforeEach
    public void setup() throws Exception {
        existingProductId = 1L;
        nonExistingProductId = 2L;
        dependentId = 3L;

        productName = "PlayStation 5";

        product = ProductFactory.createProduct(productName);
        productDTO = new ProductDTO(product);
        page = new PageImpl<>((List.of(product)));



        Mockito.when(repository.findById(existingProductId)).thenReturn(Optional.of(product));
        Mockito.when(repository.findById(nonExistingProductId)).thenReturn(Optional.empty());
        Mockito.when(repository.findById(dependentId)).thenReturn(Optional.of(product));

        Mockito.when(repository.searchByName(any(), (Pageable)any())).thenReturn(page);

        //insert metodo save
        Mockito.when(repository.save(any())).thenReturn(product);

        //getregerencebyid update
        Mockito.when(repository.getReferenceById(existingProductId)).thenReturn(product);
        Mockito.when(repository.getReferenceById(nonExistingProductId)).thenThrow(EntityNotFoundException.class);

        // delete
        Mockito.when(repository.existsById(existingProductId)).thenReturn(true);
        Mockito.when(repository.existsById(nonExistingProductId)).thenReturn(false);
        Mockito.when(repository.existsById(dependentId)).thenReturn(true);

        Mockito.doNothing().when(repository).deleteById(existingProductId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);

    }

    @Test
    public void findByIdShouldReturnProductDTOWhenIdExists(){
        ProductDTO result = service.findById(existingProductId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingProductId);
        Assertions.assertEquals(result.getName(), product.getName());
    }

    @Test
    public void findByIdShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists(){

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingProductId);
        });
    }


    @Test
    public void findAllShoulderReturnPagedProductMinDTO(){
        Pageable pageable = PageRequest.of(0, 12);
        String name = productName;

        Page<ProductMinDTO> result = service.findAll(name, pageable);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getSize(), 1);
        Assertions.assertEquals(result.iterator().next().getName(), productName);

    }

    @Test
    public void insertShouldReturnProductDTO(){
        ProductDTO result = service.insert(productDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingProductId);
    }

    // update retornar um productdto quando o id existir
    @Test
    public void updateShouldReturnProductDTOWhenIdExists(){

        ProductDTO result =  service.update(existingProductId, productDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingProductId);
        Assertions.assertEquals(result.getName(), productDTO.getName());
    }

    // update retornar  o ResourceNotFoundException quando o id nao existir
    @Test
    public void updateShouldThrowResourceNotFoundExceptionWhenDoesNotExist(){

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingProductId, productDTO);
        });

    }

    // delete id dependente de outra unidade
    @Test
    public void deleteShouldThrowDatabaseExceptionDependentId(){
        Assertions.assertThrows(DatabaseException.class, () -> {
            service.delete(dependentId);
        });
    }

    //deletar um id que nao existe
    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdNotExists(){
        Assertions.assertThrows(ResourceNotFoundException.class, () ->{
            service.delete(nonExistingProductId);
        });
    }

    // deletar um id que existe
    @Test
    public void deleteShouldDoNothingWheIdExists(){

        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingProductId);
        });

    }


}
