package com.nbu.carsew.repository;

import com.nbu.carsew.entity.Employees.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
//
//    @Query(value = "SELECT c FROM Employees c WHERE c.grades > :grades")
//    List<Employees> findEmployeesGradesGreaterThan(@Param("grades") int grades);

}
