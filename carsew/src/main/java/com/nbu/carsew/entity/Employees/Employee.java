package com.nbu.carsew.entity.Employees;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nbu.carsew.entity.Items.Item;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Double salary;

    @ManyToOne
    @JoinColumn(name = "employee_experience")
    private EmployeeExperience experience;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties("employee")
    @Where(clause = "is_produced = false")
//    @Where(clause = "is_sold = false")
    private List<Item> itemList;

    public Employee() { }

    public Employee(String name, Double salary, EmployeeExperience experience, List<Item> itemList) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.itemList = itemList;
    }

    public Employee(String name, Double salary, EmployeeExperience experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.itemList = new ArrayList<Item>();
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeExperience getExperience() {
        return this.experience;
    }

    public void setExperience(EmployeeExperience experience) {
        this.experience = experience;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
