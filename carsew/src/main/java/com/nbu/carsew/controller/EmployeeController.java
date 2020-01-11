package com.nbu.carsew.controller;

import com.nbu.carsew.dataobject.EmployeeCreateParameters;
import com.nbu.carsew.dataobject.ItemCreateParameters;
import com.nbu.carsew.entity.Employees.Employee;
import com.nbu.carsew.entity.Employees.EmployeeExperience;
import com.nbu.carsew.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    @RequestMapping("/")
//    public String redirToList(){
//        return "redirect:/employee/list";
//    }

    @RequestMapping({"/employee/list", "/employee"})
    public List<Employee> listEmployees(){
        return employeeService.listAll();
    }

    @RequestMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") long id) { return employeeService.getById(id); }

    @RequestMapping("/employee/create")
    public List<EmployeeExperience> getEmployeeCreateParamteters() {
        return employeeService.listExperienceTypes();
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/employee/create")
//    void addEmployee(@RequestBody Employee employee) {
//        employeeService.addEmployee(employee);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/employee/create")
    void addEmployee(@RequestBody EmployeeCreateParameters employeeParameters) {
        employeeService.addEmployeeFromParameters(employeeParameters);
    }
}
