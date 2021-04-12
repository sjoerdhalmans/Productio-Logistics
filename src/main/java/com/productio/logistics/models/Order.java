package com.productio.logistics.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {

    public Order(long id, @NotBlank Timestamp created, @NotBlank String materialName, @NotBlank long quantity) {
        this.id = id;
        this.created = created;
        this.materialName = materialName;
        this.quantity = quantity;
    }

    public Order(Timestamp created,  String materialName,  long quantity) {
        this.created = created;
        this.materialName = materialName;
        this.quantity = quantity;
    }

    public Order() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @NotBlank
    private Timestamp created;

    @NotBlank
    private String materialName;

    @NotBlank
    private long quantity;

    public long getId() {
        return id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
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
