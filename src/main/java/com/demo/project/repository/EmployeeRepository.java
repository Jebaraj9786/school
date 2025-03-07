package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}