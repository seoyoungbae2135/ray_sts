package com.example.gradleTest1.DTO;
import javax.validation.constraints.NotBlank;

//20240207-4
import lombok.Data;

@Data
public class SimpleBbsDto {
	
	private int id;
	@NotBlank(message="작성자를 입력하세요")
	private String writer;
	@NotBlank(message="제목을 입력하세요")
	private String title;
	@NotBlank(message="내용을 입력하세요")
	private String content;
}
