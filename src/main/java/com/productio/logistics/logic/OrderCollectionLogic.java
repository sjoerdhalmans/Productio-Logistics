package com.productio.logistics.logic;

import com.productio.logistics.dal.MaterialRepo;
import com.productio.logistics.dal.OrderRepo;
import com.productio.logistics.dal.ReceiptRepo;
import com.productio.logistics.models.Order;
import com.productio.logistics.models.OrderReceipt;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderCollectionLogic {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ReceiptRepo receiptRepo;

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public void createOrder(Order order) {
        orderRepo.save(order);
    }

    public void updateOrder(Order order) {
        orderRepo.save(order);
    }

    public void deleteOrder(long id) {
        orderRepo.deleteById(id);
    }

    public void archiveOrder(Order order) {
        OrderReceipt receipt = new OrderReceipt(new Timestamp(System.currentTimeMillis()), order.getMaterialName(), order.getQuantity(), order.getUnit());

        receiptRepo.save(receipt);
    }
}
