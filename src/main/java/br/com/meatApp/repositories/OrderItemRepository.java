package br.com.meatApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meatApp.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
