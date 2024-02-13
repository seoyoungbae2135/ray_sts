package com.example.gradleTest1.DTO;

import lombok.Data;

//20240206-5 유효성 검사

@Data
public class ContentDto {
	private int id;
	private String writer;
	private String content;
}
