package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Order;
import com.ecom.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id " + id + " not found"));
    }

    public void updateOrder(Order order) {
        orderRepo.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order with id " + order.getId() + " not found"));
        orderRepo.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id " + id + " not found"));
        orderRepo.deleteById(id);
    }
}
