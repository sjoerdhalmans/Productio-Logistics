package com.productio.logistics.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name = "receipts")
@EntityListeners(AuditingEntityListener.class)
public class OrderReceipt {

    public OrderReceipt(@NotBlank Timestamp finished, @NotBlank String materialName, @NotBlank long quantity, @NotBlank String unit) {
        this.finished = finished;
        this.materialName = materialName;
        this.quantity = quantity;
        this.unit = unit;
    }

    public OrderReceipt() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @NotBlank
    private Timestamp finished;

    @NotBlank
    private String materialName;

    @NotBlank
    private long quantity;

    @NotBlank
    private String unit;

    public long getId() {
        return id;
    }

    public Timestamp getFinished() {
        return finished;
    }

    public void setFinished(Timestamp finished) {
        this.finished = finished;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
