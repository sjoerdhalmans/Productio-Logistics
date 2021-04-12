package com.productio.logistics.controllers;

import com.productio.logistics.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);


    public void receiveNotificationMessage(String message) {
        LOGGER.info("Message Received from notification channel: <" + message + ">");

    }

    public void receiveCountMessage(String message) {
        LOGGER.info("Message Received from count channel: <" + message + ">");
    }
}