package com.nbu.carsew.dataobject;

import com.nbu.carsew.entity.Employees.Employee;
import com.nbu.carsew.entity.Items.Color;
import com.nbu.carsew.entity.Items.ItemType;

import java.util.List;

public class ItemCreateParameters {
    private List<Color> colors;
    private List<ItemType> types;
    private List<Employee> employees;

    public ItemCreateParameters(List<Color> colors, List<ItemType> types, List<Employee> employees) {
        this.colors = colors;
        this.types = types;
        this.employees = employees;
    }

    public List<Color> getColors() {
        return colors;
    }

    public List<ItemType> getTypes() {
        return types;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
