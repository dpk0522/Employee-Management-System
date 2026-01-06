package com.example.cool.Service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.cool.Model.Employee;
import com.example.cool.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository er;
	
	@Override
	public List<Employee> getAllEmployee(){
		
		return er.findAll();
	}

	@Override
	public void saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		er.save(e);
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = er.findById(id);
		Employee employee =null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else{
			throw new RuntimeException("Employee is not present " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
		
	}

	@Override
	public Page<Employee> findPage(int PageNo, int Size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(PageNo-1, Size);
		return er.findAll(pageable);
	}
	
	
	
	

}
