package com.caiofabio.dscommerce.services;

import com.caiofabio.dscommerce.dto.ProductDTO;
import com.caiofabio.dscommerce.entities.Product;
import com.caiofabio.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    // buscar produto por id
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    // buscar todos os produtos listado
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    // inserir produtos - nome, descriçao, preço, imagem
    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product entity = new Product();
        //o metodo foi criado embaixo, boas praticas
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }


    // atualizar pelo id
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        Product entity = repository.getReferenceById(id);
        //o metodo foi criado embaixo, boas praticas
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }


    // metodo craido para cadrasto e atualizacao
    private void copyDtoEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }


}
