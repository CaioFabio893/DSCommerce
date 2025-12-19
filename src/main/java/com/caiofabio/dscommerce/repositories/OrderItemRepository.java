package com.caiofabio.dscommerce.repositories;



import com.caiofabio.dscommerce.entities.Order;
import com.caiofabio.dscommerce.entities.OrderItem;
import com.caiofabio.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
