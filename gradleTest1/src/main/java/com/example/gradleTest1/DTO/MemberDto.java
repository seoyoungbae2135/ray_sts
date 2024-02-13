package com.example.gradleTest1.DTO;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//20240206-7 여기서 유효성 검사 작업
import lombok.Data;

@Data
public class MemberDto {
	
	@Email  //email형식이 아니면 에러메시지 띄움
	private String email;
	@NotNull(message="name is not input")  // 값이 없는경우 메세지 " " 띄운다
	private String name;
	@NotBlank(message="비밀번호를 입력하세요")   //비어있거나 스페이스만 있는 경우       
	@Size(min = 6, message="비밀번호는 6자리 이상입니다")
	private String password;
	@NotBlank(message="도시를 입력하세요")
	@NotEmpty(message="city is requeired") //비어있는경우
	private String city;
	@NotBlank(message="주소를 입력하세요") 
	private String state;
	@NotBlank(message="우편번호를 입력하세요") 
	@Digits(integer=5, fraction=0, message="우편번호는 5자리 숫자입니다") //자릿수
	private String zipCode;
}

/*
 *  @NotNull - null불가
 *  @Null - null만 입력가능
 *  @NotEmpty - null, 빈문자열 불가
 *  @NotBlank - null, 빈문자열,스페이스공간 불가
 *  @Size(min , max) - 문자열, 배열의 크기가 만족한가
 *  @Pattern(regex=) - 정규식 만족하는가
 *  @Max(숫자) - 숫자 지정값 이하인가
 *  @Min(숫자) - 숫자 지정값 이상인가
 *  @Email - 이메일 형식인가
 *  @Digits(integer, fraction) - 지정된 정수와 소수자리 만족하는가
 *  @Future - 지금보다 앞일인가
 *  @Past - 지금보다 과거인가
 * 
 * 
 * 
 */
 