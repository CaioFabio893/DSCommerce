package com.caiofabio.dscommerce.services;

import com.caiofabio.dscommerce.dto.ProductDTO;
import com.caiofabio.dscommerce.entities.Product;
import com.caiofabio.dscommerce.repositories.ProductRepository;
import com.caiofabio.dscommerce.services.exceptions.DatabaseException;
import com.caiofabio.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    // buscar produto por id
    // orElseThorw o id nao exista
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
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
        try{
            Product entity = repository.getReferenceById(id);
            //o metodo foi criado embaixo, boas praticas
            copyDtoEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    // deletar pelo id
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    // metodo craido para cadrasto e atualizacao
    private void copyDtoEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }


}
