package com.caiofabio.dscommerce.services;

import com.caiofabio.dscommerce.dto.CategoryDTO;
import com.caiofabio.dscommerce.dto.ProductDTO;
import com.caiofabio.dscommerce.dto.ProductMinDTO;
import com.caiofabio.dscommerce.entities.Category;
import com.caiofabio.dscommerce.entities.Product;
import com.caiofabio.dscommerce.repositories.CategoryRepository;
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

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }


}
