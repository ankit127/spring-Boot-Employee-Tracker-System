package com.ankit.springboot.emp.controller;

import java.util.List;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankit.springboot.emp.entity.Employee;
import com.ankit.springboot.emp.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	
	
	
	public EmployeeController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}



	@GetMapping("/list")
	public String listEmployee(Model model)
	{
		
	    List<Employee> theEmployee = employeeService.findAll();
		
		model.addAttribute("Employee", theEmployee);
		
		return "/employees/list-employees";
	}
	

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("Employee", theEmployee);
	
		return "/employees/employee";
	}



	

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("Employee", theEmployee);
		
		// send over to our form
		return "/employees/employee";			
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("Employee") Employee theEmployee, 
			BindingResult theBindingResult) {
		
		if(theBindingResult.hasFieldErrors())
		{
			System.out.println("has error");
			return "/employees/employee";
		}
		else
		{
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
		}
	}
		
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId")int theId)
	{
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/treat")
	public String treatManagerAndAdmin()
	{
		return "/employees/treat";
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("employeeName") String theName,
						 Model theModel) {
		
		// search the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("Employee", theEmployees);
		
		// send to /employees/list
		return "/employees/list-employees";
		
	}

}


















