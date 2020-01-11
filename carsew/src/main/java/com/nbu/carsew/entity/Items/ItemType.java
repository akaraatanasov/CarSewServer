package com.nbu.carsew.entity.Items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Double materialPrice;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getMaterialsPrice() {
        return materialPrice;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMaterialsPrice(Double materialPrice) {
        this.materialPrice = materialPrice;
    }
}
