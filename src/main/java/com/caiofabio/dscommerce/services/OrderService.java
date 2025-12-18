package com.caiofabio.dscommerce.services;

import com.caiofabio.dscommerce.dto.OrderDTO;
import com.caiofabio.dscommerce.dto.ProductDTO;
import com.caiofabio.dscommerce.entities.Order;
import com.caiofabio.dscommerce.entities.Product;
import com.caiofabio.dscommerce.repositories.OrderRepository;
import com.caiofabio.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new OrderDTO(order);
    }
}
