package com.productio.logistics.logic;

import com.productio.logistics.dal.OrderRepo;
import com.productio.logistics.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCollectionLogic {
    @Autowired
    OrderRepo orderRepo;

    public List<Order> getAll() {
        return orderRepo.findAll();
    }
}
