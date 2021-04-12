package com.productio.logistics.logic;

import com.productio.logistics.dal.MaterialRepo;
import com.productio.logistics.dal.OrderRepo;
import com.productio.logistics.dal.ReceiptRepo;
import com.productio.logistics.models.IncomingOrder;
import com.productio.logistics.models.IncomingReceipt;
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

    public void createOrder(IncomingOrder order) {
        Order newOrder = new Order(new Timestamp(System.currentTimeMillis()), order.getMaterialName(), order.getQuantity());

        orderRepo.save(newOrder);
    }

    public void updateOrder(Order order) {
        orderRepo.save(order);
    }

    public void deleteOrder(long id) {
        orderRepo.deleteById(id);
    }

    public void archiveOrder(IncomingReceipt incomingReceipt) {
        OrderReceipt receipt = new OrderReceipt(
                incomingReceipt.getPrice(),
                incomingReceipt.getCurrency(),
                new Timestamp(System.currentTimeMillis()),
                incomingReceipt.getMaterialName(),
                incomingReceipt.getQuantity());

        receiptRepo.save(receipt);
    }

    public List<OrderReceipt> getAllReceipts() {
        return receiptRepo.findAll();
    }
}
