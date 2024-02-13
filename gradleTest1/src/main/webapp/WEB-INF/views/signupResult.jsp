<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="row" items="${list }">
		<p>이메일 : ${memberDto.email }</p>
		<p> 이름 : ${memberDto.name }</p>
		<p>비밀번호 : ${memberDto.password }</p>
		<p>도시 : ${memberDto.city }</p>
		<p>주소 : ${memberDto.state }</p>
		<p>우편번호 : ${memberDto.zipCode }</p>
	</c:forEach>

</body>
</html>