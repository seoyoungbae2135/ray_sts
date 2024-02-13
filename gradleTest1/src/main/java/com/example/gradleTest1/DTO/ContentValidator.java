package com.example.gradleTest1.DTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// 20240206-5 유효성 검사
public class ContentValidator implements Validator{ //ContentValidator에 커서올리면 메서드작성 박스뜬다 작성클릭

	@Override
	public boolean supports(Class<?> clazz) {
		// 검증할 겍체의 클래스 확인
		return ContentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 유효성 검사
		ContentDto dto = (ContentDto)target;
		
		String writer = dto.getWriter(); //writer에 있는 값을 가져오기
		if( writer == null || writer.trim().isEmpty()) {
			errors.rejectValue("writer", "No input", "작성자입력하세요");
		}
		
		String content = dto.getContent();
		if(content==null || content.trim().isEmpty()) {
			errors.rejectValue("content", "NO input Content" , "내용을입력하세요");
		}
		
	}
	
}
