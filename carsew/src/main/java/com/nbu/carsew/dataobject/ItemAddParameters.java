package com.nbu.carsew.dataobject;

public class ItemAddParameters {
    private String name;
    private long typeId;
    private long colorId;
    private long employeeId;
    private Double price;

    public ItemAddParameters(String name, long typeId, long colorId, long employeeId, Double price) {
        this.name = name;
        this.typeId = typeId;
        this.colorId = colorId;
        this.employeeId = employeeId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getTypeId() {
        return typeId;
    }

    public long getColorId() {
        return colorId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Double getPrice() {
        return price;
    }
}
