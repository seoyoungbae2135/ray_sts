package com.example.gradleTest1;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
// 20240205-2
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.gradleTest1.DTO.MyInfoDTO;
import com.example.gradleTest1.DTO.person;

@Controller
public class MainController {
	// 클라이언트의 요청을 처리해주는 클래스
	
	@GetMapping("/")
	public ModelAndView main() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name", "최무선");
		return mv;
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("testKey","테스트중 박문수");
		return "test";
	}
	
	@GetMapping("/form") // 20240205-8
	public String formData() {
		return "form";
	}
	
	@RequestMapping("/input") // 사용자가입력한 데이터를 받아오는 1번째방법 20240205-8
	public String input(HttpServletRequest request, Model model) { //Model은 매개변수로 받아와야한다
		
		String id = request.getParameter("myId");
		String name = request.getParameter("myName");
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "input1";
	}
	
	@GetMapping("/input2") // 사용자가입력한 데이터를 받아오는 2번째방법 20240205-8, 일반적인 방식
	public String input(@RequestParam("myId") String id ,  //@RequestParam("myId") String id 이렇게 하나하나 모두@RequestParam을 붙여서 받는다 
			@RequestParam("myName") String name, Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("name",name);
		
		return "input2";
		
	}
	
	@GetMapping("/input3") // 사용자가입력한 데이터를 받아오는 3번째방법 20240206-1 일반적인 방식
	public String input( person person , Model model) { //person(참조변수) person(클래스) , Model(참조변수) model(클래스)
		
//		model.addAttribute("id" , per.getMyId());
//		model.addAttribute("name" , per.getMyName());
		return "input3";
	}
	
	@GetMapping("/input4/{id}/{name}") //사용자가입력한 데이터를 받아오는 4번째방법 20240206-2, /{id}/{name}:데이터를 경로처럼 사용 
	public String input4(@PathVariable String id, @PathVariable String name ,
			 Model model) {
		return "input4";
		
	}
	// 20240206-4 문제풀이
	@GetMapping("/testIn") // /testIn이라는 주소가 입력되면
	public String testInfo() { 
		return "testInput"; // testInput을 반환하겠다
	}
	
	@GetMapping("/Info") // /Info가 요청되면
	public String myInfo( MyInfoDTO myInfoDTO , Model model) { 
		
		String ageTmp = myInfoDTO.getAge(); //저장된값 가져오기 ageTmp에 저장
		if(ageTmp.length()==1)              // 10살미만은 
			ageTmp = "10살미만";
		else
			ageTmp = ageTmp.substring(0,1)+"0대";
		
		model.addAttribute("age", ageTmp ); //10대, 20대, 30대, 40대로 표기하기위한 코드
	
		return "myInfo"; // myInfo를 반환하겠다
	}
	
}


/*
 * 모델
 * 스프링에서 모델은 데이터를 저장하거나 뷰에 전달하기 위한 용도로 사용된다.
 * 		ModelAndView - 데이터와 뷰를 모두 전달할 수 있다
 * 
 *  	Model - 데이터만 전달 가능
 *  
 *  	사용자 요청에 의한 전달받은 데이터를 다시 사용자 화면에 제공하는 방법은
 *  	 Model 사용해야 한다
 *  	 사용자요청에 의해 발생된 데이터는 파라미터러 들어오는데 파라미터는 페이지가
 *  	 변경되면 사라진다. 파라미터가 사라지기전에 모델에 저장해 두어야 한다.
 * 20240206-4
 * 네이밍 규칙(권고사항? -반드시 하지않아도 되지만 대체적으로 이렇게 쓴다.)
 * 	공통부분
 * 		1. 대소문자구분
 * 		2. 예약어 사용하면 안됨(예. int, String)
 * 		3. 숫자로 시작하면 안됨
 * 		4. 특수문자는 _ 또는 $만 허용
 * 		5. 파스칼 표기법 또는 카멜표기법 사용
 * 			카멜:myName , 파스칼:MyName
 * 		6. 반의어는 반드시 대응하는 개념으로 사용
 *  	
 *  	프로젝트이름 : 대소문자 구분없이 사용가능하지만 대문자 사용을 권장
 *  	
 *  	패키지 이름
 *  		- 대소문자 구분없이 사용가능하지만 클래스명과 구분하기위해 소문자 사용을 권장
 *  		- 가급적 한단어 사용권장
 *				com.naver.comic.member 올바른예
 *				com.naver.comicMember 안종은예
 *		
 *		클래스
 *			-파스칼표기법사용
 *			-명사로 시작
 *
 *		메서드
 *			-카멜표기법 사용
 *			-동사로 시작
 *			메서드명의 접두사(일반적)
 *			  속성에 접근 : get/set
 *			  데이터
 *				생성:create
 *				조회:find	
 *				변경:update/modify
 *				삭제:delete
 *				입력:input/insert
 *				초기화:init
 *				파일불러오기:load
 *				파일저장:save
 *				유무확인:has
 *				A를 기준으로 B를 : By
 *					getAgeByBirth()
 *					getElementById()
 *
 *		변수 - 카멜표기법
 *		상수 - 전부 대문자 , 스네이크 표기법
 *
 *		신입개발자들이 자주하는 나쁜 습관
 *			1.임의적인 postfix 사용. postfix : 책에나와있는내용들을 그냥사용
 *				- 학교나 학원 또는 독학할때 다룬 주소네이밍을 사용한다.( .do )
 * 			2.확인을 위해 System.out.println을 사용한다.
 * 				-테스트나 공부의 목적으로 빠르게 확인하기 위해 사용하지만
 * 				  실제 서비스에서는 console로 출력하거나 로그기록이 남도록 파일저장을 해야한다
 * 			3.코드에 주석처리하고 왜 주석처리했는가 아무말도 남기지 않는다.
 * 				-주석처리를 했다면 다름사람이 보거나 나중에 내가 다시볼때 왜 주석을 했는지 이유가 있어야
 * 				 알아볼 수 있다. 아무기록없이 주석 할꺼면 그냥 삭제하기
 * 			4.변수이름에 _ 넣는다
 * 				-변수는 카멜표기법으로 작성한다
 * 				-대부분의 개발자들이 카멜표기법을 작성하는데 나혼자 _ 넣거나 다른방식으로 작성하면 
 * 				  따돌림 당한다.
 * 			5.메서드이름에서 형용사나 명사를 앞에 넣는다.
 * 				-newUser , anyData -> 이렇게하면 안된다!!
 * 				-createUser , saveMemberData 
 * 			6.필요이상으로 if문 많이 활용
 * 				- if문은 최소화 하는게 좋다. (map을 활용하든가, switch문이나, callback, 재귀 등등)
 * 			7.parameter가 많은데 그냥 변수로 받는다
 * 				- form 입력데이터가 10가지인데 @RequestParam으로 하나하나 다받는다.
 * 				- 파라미터가 많은 경우 객체로 받는다 (데이터받아오기 3번째방법)
 * 			8.불필요한 로그를 넣는다.
 * 				- 코드가 잘 동작하는지 테스트를 위해 System.out.println을 사용하는데
 * 				- 테스트가 끝났으면 삭제하도록 하기 또는 주석처리
 * 			9.라이브러리를 활용하지않는다
 * 				-데이터 저장을 위해 클래스를 정의하는데 직접 get/set/toString을 작성한다
 * 				-객체에 데이터를 하나하나 직접 저장 시킨다
 * 				-라이브러리를 사용하면 쉽게 빠르게 작업이 가능한데 어려운길을 간다
 * 			10. 가능한 작은 코드로 작성하지 않으려고 한다
 * 			11. 사용자 편의성을 고려하지 않는다
 * 				- 
 * 
 * 
 * */
