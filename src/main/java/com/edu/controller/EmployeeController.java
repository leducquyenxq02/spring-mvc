package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.DAO.DepartmentDAO;
import com.edu.DAO.EmployeeDAO;
import com.edu.model.Employee;

@Controller
@RequestMapping("employeeManagement")
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDao;
	@Autowired
	private DepartmentDAO departmentDao;
	
	@RequestMapping("showEmployee")
	public String showStudent(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employeeDao.getAll());
		model.addAttribute("departments", departmentDao.getAll());
		return "employee";
	}
	@RequestMapping(value = "employeeProcess", params = { "reset=Submit" })
	public String reset(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employeeDao.getAll());
		return "employee";
	}
	
	@RequestMapping("list")
	public String getEmployees(ModelMap model) {
		model.addAttribute("employees", employeeDao.getAll());
		return "employee";
	}
	@RequestMapping(value = "employeeSearch")
	public String search(@RequestParam("search") String search, Model model) {
		if (search == null || search.equals("")) {
			model.addAttribute("employees", employeeDao.getAll());
		} else {
			model.addAttribute("employees", employeeDao.search(search));
		}
		model.addAttribute("employee", new Employee());
		return "employee";
	}

	@RequestMapping(value = "employeeProcess", params = { "add=Add" })
	public String save(@ModelAttribute("employee") @Validated Employee employee, BindingResult result, ModelMap model) {
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartmentIdPK()));
		if (result.hasErrors()) {
			return "employee";
		}
		this.employeeDao.save(employee);
		return "redirect:/employeeManagement/showEmployee";
	}
	
	

	@RequestMapping(value = "employeeProcess", params = { "update=Update" })
	public String update(@ModelAttribute("employee") @Validated Employee employee, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("employee", employee);
			return "employee";
		}
		this.employeeDao.update(employee);
		return "redirect:/employeeManagement/showEmployee";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") int id, ModelMap model) {
		this.employeeDao.delete(this.employeeDao.getEmployee(id));
		return "redirect:/employeeManagement/showEmployee";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("employees", employeeDao.getAll());
		model.addAttribute("employee", this.employeeDao.getEmployee(id));
		model.addAttribute("departments", departmentDao.getAll());
		return "employee";
	}

}
