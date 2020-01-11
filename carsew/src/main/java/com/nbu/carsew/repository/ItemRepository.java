package com.nbu.carsew.repository;

import com.nbu.carsew.entity.Items.Item;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
//
//    @Query(value = "SELECT c FROM Employees c WHERE c.grades > :grades")
//    List<Employees> findEmployeesGradesGreaterThan(@Param("grades") int grades);


}