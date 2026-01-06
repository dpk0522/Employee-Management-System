package com.example.cool.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cool.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {

	
}
