package com.caiofabio.dscommerce.services;

import com.caiofabio.dscommerce.dto.CategoryDTO;
import com.caiofabio.dscommerce.entities.Category;
import com.caiofabio.dscommerce.repositories.CategoryRepository;
import com.caiofabio.dscommerce.tests.CategoryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository repository;

    private Category category;
    private List<Category> list;

    @BeforeEach
    void setUp() throws Exception {
        category = CategoryFactory.creatCategory();
        list = new ArrayList<>();
        list.add(category);

        Mockito.when(repository.findAll()).thenReturn(list);
    }

    @Test
    public void findAllShouldReturnLisstCategoryDTO(){

        List<CategoryDTO> result = service.findAll();

        Assertions.assertEquals(result.size(), 1);
        Assertions.assertEquals(result.get(0).getId(), category.getId(), category.getId());
        Assertions.assertEquals(result.get(0).getName(), category.getName(), category.getName());

    }
}
