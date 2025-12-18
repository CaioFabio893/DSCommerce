package com.caiofabio.dscommerce.repositories;



import com.caiofabio.dscommerce.entities.Order;
import com.caiofabio.dscommerce.entities.User;
import com.caiofabio.dscommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
