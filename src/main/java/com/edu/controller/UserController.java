package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.DAO.EmployeeDAO;
import com.edu.DAO.UserDAO;
import com.edu.model.Employee;
import com.edu.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EmployeeDAO employeeDao;

	@RequestMapping(value ="home" )
	public String home(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = "login")
	public String showLogin(ModelMap model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "register")
	public String showRegister(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.getAll());
		return "register";
	}

	@RequestMapping(value = "registerAction", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, ModelMap model) {
		if (userDao.getUser(user.getUserName()) == null) {
			userDao.save(new User(user.getUserName(), user.getPass()));
			model.addAttribute("message", user.getUserName());
			return "welcome";
		} else {
			model.addAttribute("message", "Tên đăng nhập đã được sử dụng!!!");
			model.addAttribute("users", userDao.getAll());
			return "register";
		}
	}

	@RequestMapping(value = "loginAction", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, ModelMap model) {
		if (!userDao.getUser(user.getUserName(), user.getPass()).isEmpty()) {
			model.addAttribute("message", user.getUserName());
			model.addAttribute("employee", new Employee());
			model.addAttribute("employees", employeeDao.getAll());
			return "employee";
		}
		model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu sai!");
		return "login";
	}

	@RequestMapping(value = "delete")
	public String delete(@RequestParam("id") String userName, ModelMap model) {
		User user = userDao.getUser(userName);
		if (user != null) {
			userDao.delete(user);
		}
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.getAll());
		return "register";
	}

}
