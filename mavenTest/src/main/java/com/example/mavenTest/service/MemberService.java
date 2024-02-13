package com.example.mavenTest.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mavenTest.DAO.MemberDAO;
import com.example.mavenTest.DTO.memberDTO;

// 20240202-3
@Service
public class MemberService {
	private final MemberDAO memberdao ;
	
	@Autowired
	public MemberService(MemberDAO memberdao) {
		this.memberdao=memberdao;
	}
	
	//회원가입 저장 메서드
	public void insert( memberDTO memberdto ) {
		memberdao.insert(memberdto);
	}
	
	//로그인 처리 메서드
	public String login(Map<String,String> param) {
		return memberdao.findMemberByemailpw(param.get("email"), param.get("pin"));
	}
	
	//회원정보 수정 메서드
	//public String update(Map<String,String> pm) {
		
	//}

}
