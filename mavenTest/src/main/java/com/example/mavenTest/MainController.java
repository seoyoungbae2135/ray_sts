package com.example.mavenTest;
import java.util.Map;

import javax.servlet.http.HttpSession;

// 20240201-6~8
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mavenTest.DTO.memberDTO;
import com.example.mavenTest.service.MemberService;


@Controller
public class MainController {
	private final MemberService memberService;
	
	public MainController(MemberService memberService) {
		this.memberService=memberService;
	}
//	@GetMapping("/")
//	public ModelAndView main() {
//		ModelAndView mv = new ModelAndView("mypage"); 
//		mv.addObject("prt", "member"); // mypage.jsp에 prt에 member 문자열을(데이터값을) 넘긴 것
//		
//		return mv; 
//	}
	
	@GetMapping("/")  //주소요청
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("index"); //20240201-8 수정
		return mv; 
	}
	// 여기부터 20240202-1~
	@GetMapping("/signup") // signup 주소요청
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("signup"); // signup으로 보낸다
		return mv;
	}
	
	@GetMapping("/signin") // signin 주소요청
	public ModelAndView signin( ) {
		ModelAndView mv = new ModelAndView("signin"); // signin.jsp 로 보낸다
		return mv;
	}
	// 로그인처리 20240202-6
	@PostMapping("/signin") // 전송방식이 다르므로(위는 Get, 여기는 Post) 동일한 주소로 해도 처리된다
	public ModelAndView signin( @RequestParam Map<String, String> param , 
			HttpSession session) {
		
		ModelAndView mv = new ModelAndView("index");
		
		System.out.println( param.get("email"));
		String name = memberService.login( param );
		
		if( name !=null )
			session.setAttribute("user" , name); // mv.addObject("user", name); 이것을 변경함
		else {
			mv.setViewName("signin");
			mv.addObject("fail", "a");
		}
		return mv;
	}
	
	//회원정보 수정
	@PostMapping("/update")
	public ModelAndView update(@RequestParam Map<String, String> pm) {
		ModelAndView mv = new ModelAndView("signin");
		memberService.update(pm);
		return mv;
	}
	
	@PostMapping("/signup/Enroll") // /signup/Enroll 주소요청
	public ModelAndView signEnroll( @ModelAttribute memberDTO memberdto ) {
		
		ModelAndView mv = new ModelAndView("index");
		System.out.println( memberdto.getEmail() );
		memberService.insert(memberdto);
		return mv;
	}
	
//  하나씩 가져오는 경우
//	public ModelAndView signEnroll(
//			@RequestParam("email") String email, //@->에너테이션
//			@RequestParam("pin") String pw,
//			@RequestParam("name") String name,
//			@RequestParam("tel") String tel ) {
//		ModelAndView mv = new ModelAndView("index");  // index.jsp로 보낸다	
//		System.out.println( email ); // 회원가입클릭 
//		return mv;
//	}
}




















