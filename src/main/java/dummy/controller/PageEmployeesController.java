package dummy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dummy.model.EmployeeModel;
import dummy.service.EmployeeServiceImpl;

@RestController
public class PageEmployeesController {
	
	@Autowired
	EmployeeServiceImpl service;
	List<EmployeeModel> employees;
	int size  = 50;
	
	@RequestMapping("/employees")
	public ModelAndView getEmployees(HttpServletRequest req, ModelMap map){
		if(req.getAttribute("pageCount").equals(0)) {
			 employees = service.getEmployees((int) req.getAttribute("pageCount"), size);
			 return new ModelAndView("ViewAllEmployees","employees", employees);
		}else {
			employees = service.getEmployees(((int) req.getAttribute("pageCount") + 1), size);
			 return new ModelAndView("ViewAllEmployees", "employees", employees);
		}
	}

}
