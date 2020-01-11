package com.nbu.carsew.service;

import com.nbu.carsew.dataobject.EmployeeCreateParameters;
import com.nbu.carsew.entity.Employees.Employee;
import com.nbu.carsew.entity.Employees.EmployeeExperience;
import com.nbu.carsew.repository.EmployeeExperienceRepository;
import com.nbu.carsew.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeExperienceRepository employeeExperienceRepository;

    public List<Employee> listAll() {
        List<Employee> Employees = new ArrayList();
        employeeRepository.findAll().forEach(employee -> Employees.add(employee));
        return Employees;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void addEmployeeFromParameters(EmployeeCreateParameters parameters) {
        Optional<EmployeeExperience> experience = employeeExperienceRepository.findById(parameters.getExperienceId());
        Employee employee = new Employee(parameters.getName(), parameters.getSalary(), experience.get());
        addEmployee(employee);
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<EmployeeExperience> listExperienceTypes() {
        List<EmployeeExperience> Experiences = new ArrayList();
        employeeExperienceRepository.findAll().forEach(experience -> Experiences.add(experience));
        return Experiences;
    }

    public Employee saveOrUpdate(Employee Employee) {
        employeeRepository.save(Employee);
        return Employee;
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
//
//    
//    public Employees saveOrUpdateEmployeeForm(EmployeeForm EmployeeForm) {
//        Employees savedEmployee = saveOrUpdate(EmployeeFormToEmployee.convert(EmployeeForm));
//
//        System.out.println("Saved Employees Id: " + savedEmployee.getId());
//        return savedEmployee;
//    }
}
