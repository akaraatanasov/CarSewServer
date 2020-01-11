package com.nbu.carsew.entity.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nbu.carsew.entity.Employees.Employee;
import com.nbu.carsew.entity.Employees.EmployeeExperience;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "type")
    private ItemType type;

    @ManyToOne
    @JoinColumn(name = "color")
    private Color color;

    @ManyToOne
    @JsonIgnoreProperties("itemList")
    private Employee employee;

    @ColumnDefault("false")
    private boolean isProduced;

    @ColumnDefault("false")
    private boolean isSold;

    public Item() { }

    public Item(String name, Double price, ItemType type, Color color, Employee employee) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.color = color;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean getIsProduced() {
        return isProduced;
    }

    public void setIsProduced(boolean produced) {
        isProduced = produced;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(boolean sold) {
        isSold = sold;
    }
}
