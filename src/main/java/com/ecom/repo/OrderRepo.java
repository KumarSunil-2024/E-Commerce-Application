package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Order;
import com.ecom.entity.User;

public interface OrderRepo extends JpaRepository<Order,Long>{

	public Order findByUser(User user);
	
}
