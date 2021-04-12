package com.productio.logistics.controllers;

import com.productio.logistics.logic.OrderCollectionLogic;
import com.productio.logistics.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisReceiver {
    @Autowired
    OrderCollectionLogic orderCollectionLogic;

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);


    public void receiveNotificationMessage(String message) {
        LOGGER.info("Message Received from notification channel: <" + message + ">");

    }

    public void receiveCountMessage(String message) {
        LOGGER.info("Message Received from count channel: <" + message + ">");
    }

    public void createOrder(Order order) {
        this.orderCollectionLogic.createOrder(order);
    }

    public void updateOrder(Order order) {
        this.orderCollectionLogic.updateOrder(order);
    }

    public void deleteOrder(long id) {
        this.orderCollectionLogic.deleteOrder(id);
    }

    public void archiveOrder(Order order) {
        this.orderCollectionLogic.archiveOrder(order);
    }
}