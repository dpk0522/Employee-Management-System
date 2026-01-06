package com.example.cool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cool.Model.Employee;
//import com.example.cool.Model.Employee;
import com.example.cool.Service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl es;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {	
//		model.addAttribute("listEmployee", es.getAllEmployee());
//		return "index";
		return findPaginated(1,model);
	}
	
	@GetMapping("/newEmployeeForm")
	public String showFormEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee"; 
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		es.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String findById(@PathVariable(value="id") long id, Model model) {
		Employee employee = es.getById(id);
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteById(@PathVariable(value="id") long id) {
		es.deleteEmployee(id);
		return "redirect:/";
	}
	
	  @GetMapping("/page/{pageNo}")
	    public String findPaginated(@PathVariable int pageNo, Model model) {

	        int pageSize = 5;

	        Page<Employee> page = es.findPage(pageNo, pageSize);
	        List<Employee> listEmployee = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPage", page.getTotalPages());
	        model.addAttribute("totalItem", page.getTotalElements());
	        model.addAttribute("listEmployee", listEmployee);

	        return "index";
	    }
	
}
