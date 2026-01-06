package com.example.cool.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.cool.Model.Employee;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	void saveEmployee(Employee e);
	Employee getById(long id); 
	void deleteEmployee(long id);
	Page<Employee> findPage(int PageNo,int Size);
}
