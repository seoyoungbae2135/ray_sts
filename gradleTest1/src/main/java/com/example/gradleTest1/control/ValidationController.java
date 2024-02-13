package com.example.gradleTest1.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gradleTest1.DAO.MemberDao;
import com.example.gradleTest1.DTO.ContentDto;
import com.example.gradleTest1.DTO.MemberDto;

//20240206-7
@Controller
public class ValidationController {
	
	@Autowired
	private MemberDao memberDao;
	
	//유효성 검사 2 - form 입력 양식 페이지
	@GetMapping("/valid2")
	public String input(Model model) {
		model.addAttribute("memberDto", new MemberDto());
		return "signup";
	}
	
	@GetMapping("/submit")
	public String input( @Valid MemberDto memberDto ,   //@Valid: 간단한 유효성검사
			BindingResult bind, Model model) { //BindingResult bind 는 유효성 검사해서 이름을 "입력하세요" 띄우는 코드
	if( bind.hasErrors()) {
		return "signup";
	}
	
	memberDao.insertMember(memberDto); // 20240207-2 저장하기위한 코드
	
	List<MemberDto> list = memberDao.list();
	
	model.addAttribute("list" , list);
	
		return "signupResult";
	}
	
}
