package com.example.gradleTest2.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gradleTest2.DAO.MyUserDaoImple;

@Controller
public class TestController {
	
	@Autowired
	private MyUserDaoImple myUserDaoImple;
	
	@RequestMapping("/testlist")
	public String testList(Model model) {
		model.addAttribute("list", myUserDaoImple.list());
		return "test";
	}

}
