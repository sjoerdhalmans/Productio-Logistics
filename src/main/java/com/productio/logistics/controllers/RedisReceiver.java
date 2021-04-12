package com.productio.logistics.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productio.logistics.logic.OrderCollectionLogic;
import com.productio.logistics.models.IncomingOrder;
import com.productio.logistics.models.IncomingReceipt;
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

    public void createOrder(String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        IncomingOrder order = objectMapper.readValue(body, IncomingOrder.class);

        this.orderCollectionLogic.createOrder(order);
    }

    public void updateOrder(String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(body, Order.class);

        this.orderCollectionLogic.updateOrder(order);
    }

    public void deleteOrder(String body) {
        this.orderCollectionLogic.deleteOrder(Long.parseLong(body));
    }

    public void archiveOrder(String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        IncomingReceipt receipt = objectMapper.readValue(body, IncomingReceipt.class);

        this.orderCollectionLogic.archiveOrder(receipt);
    }
}