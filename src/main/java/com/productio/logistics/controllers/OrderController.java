package com.productio.logistics.controllers;

import com.productio.logistics.logic.OrderCollectionLogic;
import com.productio.logistics.models.IncomingOrder;
import com.productio.logistics.models.IncomingReceipt;
import com.productio.logistics.models.Order;
import com.productio.logistics.models.OrderReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderCollectionLogic orderCollectionLogic;

    @GetMapping(value = "/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(value = "/getAllReceipts")
    public List<OrderReceipt> getAllReceipts() {
        return orderCollectionLogic.getAllReceipts();
    }

    @GetMapping(value = "/getAllOrders")
    public List<Order> getAll() {
        return orderCollectionLogic.getAll();
    }

    @PostMapping(value ="/createOrder")
    public void create(@RequestBody IncomingOrder order) {
        orderCollectionLogic.createOrder(order);
    }

    @PutMapping(value ="/updateOrder")
    public void update(@RequestBody Order order) {
        orderCollectionLogic.updateOrder(order);
    }

    @DeleteMapping(value ="/deleteOrder/{orderid}")
    public void delete(@PathVariable(value="orderid") long id) {
        orderCollectionLogic.deleteOrder(id);
    }

    @PostMapping(value ="/archiveOrder")
    public void archive(@RequestBody IncomingReceipt receipt) {
        orderCollectionLogic.archiveOrder(receipt);
    }
}
