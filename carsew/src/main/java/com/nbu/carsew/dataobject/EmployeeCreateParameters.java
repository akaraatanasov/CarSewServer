package com.nbu.carsew.dataobject;

import java.util.List;

public class EmployeeCreateParameters {
    private String name;
    private Double salary;
    private long experienceId;

    public EmployeeCreateParameters(String name, Double salary, long experienceId) {
        this.name = name;
        this.salary = salary;
        this.experienceId = experienceId;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public long getExperienceId() {
        return experienceId;
    }
}
