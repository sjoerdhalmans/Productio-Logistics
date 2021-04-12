package com.productio.logistics.models;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

public class IncomingReceipt {
    public IncomingReceipt(long price, String currency, String materialName, long quantity) {
        this.price = price;
        this.currency = currency;
        this.materialName = materialName;
        this.quantity = quantity;
    }

    public IncomingReceipt() {

    }

    private long price;

    private String currency;

    private String materialName;

    private long quantity;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
