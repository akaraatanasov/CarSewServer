package com.nbu.carsew.entity.Employees;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int itemsPerHour;

    public EmployeeExperience() { }

    public EmployeeExperience(String title, int itemsPerHour) {
        this.title = title;
        this.itemsPerHour = itemsPerHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemsPerHour() {
        return itemsPerHour;
    }

    public void setItemsPerHour(int itemsPerHour) {
        this.itemsPerHour = itemsPerHour;
    }
}
