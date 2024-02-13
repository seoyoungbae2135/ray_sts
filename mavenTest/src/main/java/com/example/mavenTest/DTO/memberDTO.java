package com.example.mavenTest.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//20240202-1~
// @(에너테이션) 아래와같이 하면 get, set을 안만들어도 된다. (동일한 동작) lombok 라이브러리 필요
@Getter
@Setter
// equals, toString, hashcode 등과같은 동작 ( 변수들의 )
@Data  
public class memberDTO {
	private String email;
	private String pin;
	private String name;
	private String tel;
}


//데이터와 관련있는 클래스들을 지칭하는 용어
// DTO(Data Transfer Object) - 읽기전용, 데이터전송을 위한 객체( 전달목적)
// VO (value Object) - 여러 데이터들을 통합하여 다루는 객체, 데이터 가공을 위한 알고리즘 
// ENTITY - 데이터베이스 테이블과 매핑되는 객체, 데이터베이스를 다루기 위한 객체이다.
// DTO와 VO를 같이사용하는 경우는 일반적으로 없다. DTO와 ENTITY, VO와 ENTITY 이렇게 사용.