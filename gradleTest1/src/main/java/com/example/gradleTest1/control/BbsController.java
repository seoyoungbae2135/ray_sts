package com.example.gradleTest1.control;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.gradleTest1.DAO.SimpleBbsDao;
import com.example.gradleTest1.DAO.SimpleBbsDaoImple;
import com.example.gradleTest1.DTO.SimpleBbsDto;

//20240207-4
@Controller
public class BbsController {
	
	@Autowired
	SimpleBbsDaoImple simpleBbsDaoImple;
	
	@RequestMapping( value= "/board" , method=RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("list", simpleBbsDaoImple.listDao());
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		model.addAttribute("simpleBbsDto" , new SimpleBbsDto());
		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(@Valid SimpleBbsDto simpleBbsDto ,BindingResult bind ,
			Model model) {
		if( bind.hasErrors()) {
			return "writeForm";
		}
		//작성한 내용을 유효성 검사하고 데이터 베이스에 저장하기
		simpleBbsDaoImple.writeDao(simpleBbsDto);
		return "redirect:/board"; //20240207-5
	}
	
	@RequestMapping("/view/{id}") // 20240207-6 데이터 보기
	public String view(@PathVariable String id, Model model) {
		model.addAttribute("dto", simpleBbsDaoImple.viewDao(id));
		return "view";
	}
	
	@RequestMapping("/delete/{id}") //20240207-7 데이터 삭제
	public String delete( @PathVariable String id) {
		simpleBbsDaoImple.deleteDao(id);
		return "redirect:/board";
	}
}
