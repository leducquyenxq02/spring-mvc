package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.DAO.DepartmentDAO;
import com.edu.model.Department;



@Controller
@RequestMapping("departmentManagement")
public class DepartmentController {
	@Autowired
	DepartmentDAO departmentDAO;

	@RequestMapping("showDepartment")
	public String showCatalogue(Model model) {
		model.addAttribute("department", new Department());
		model.addAttribute("departments", departmentDAO.getAll());
		return "department";
	}

	@RequestMapping("list")
	public String getCatalogueDAO(Model model) {
		model.addAttribute("departments", departmentDAO.getAll());
		return "department";
	}

	@RequestMapping(value = "departmentProcess", params = { "reset=Submit" })
	public String reset1(Model model) {
		model.addAttribute("department", new Department());
		model.addAttribute("departments", departmentDAO.getAll());
		return "department";
	}

	@RequestMapping(value = "departmentProcess", params = { "add=Add" })
	public String save(@ModelAttribute("department") @Validated Department department,BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "department";
		}
		this.departmentDAO.save(department);
		return "redirect:/departmentManagement/showDepartment";
	}

	@RequestMapping(value = "departmentProcess", params = { "update=Update" })
	public String update(@ModelAttribute("department") @Validated Department department,BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("department", department);
			return "department";
		}
		this.departmentDAO.update(department);
		return "redirect:/departmentManagement/showDepartment";
	}

	@RequestMapping(value = "delete/{departmentId}")
	public String delete(@PathVariable("departmentId") int departmentId, Model model) throws Exception {
		this.departmentDAO.delete(this.departmentDAO.getDepartment(departmentId));
		return "redirect:/departmentManagement/showDepartment";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("departmentId") int departmentId, Model model) {
		model.addAttribute("departments", departmentDAO.getAll());
		model.addAttribute("department", this.departmentDAO.getDepartment(departmentId));
		return "department";
	}
}
