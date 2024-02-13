package com.example.gradleTest1.control;
//20240206-5 유효성검사
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gradleTest1.DTO.ContentDto;
import com.example.gradleTest1.DTO.ContentValidator;

@Controller
public class ValController {
	
	@GetMapping("/inputForm")
	public String input(Model model) {
		model.addAttribute("contentDto", new ContentDto());
		return "contentForm";
	}
	
	@GetMapping("/create")
	public String input( ContentDto contentDto , Model model ,
			BindingResult result) {
		String page = "contentDone";
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto , result);
		if( result.hasErrors()) { //witer 또는 content에 값을 입력하지않은경우 error값 있음
			page="contentForm";
			
		}
		return page;
	}
	
}
