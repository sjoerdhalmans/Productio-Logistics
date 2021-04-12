package com.productio.logistics.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class IncomingOrder implements Serializable {
    public IncomingOrder(String materialName, long quantity) {
        this.materialName = materialName;
        this.quantity = quantity;
    }

    public IncomingOrder() {

    }

    private String materialName;

    private long quantity;

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