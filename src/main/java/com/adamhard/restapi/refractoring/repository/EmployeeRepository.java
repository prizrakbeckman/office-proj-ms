package com.adamhard.restapi.refractoring.repository;

import com.adamhard.restapi.refractoring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
