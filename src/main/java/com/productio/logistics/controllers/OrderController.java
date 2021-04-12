package com.productio.logistics.controllers;

import com.productio.logistics.logic.OrderCollectionLogic;
import com.productio.logistics.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderCollectionLogic orderCollectionLogic;

    @GetMapping(value = "/getAllOrders")
    public List<Order> getAll() {
        return orderCollectionLogic.getAll();
    }
}
