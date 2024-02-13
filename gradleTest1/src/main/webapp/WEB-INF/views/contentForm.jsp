<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 20240206-6 유효성 검사 에러메세지출력 -->
<body>

	<form:form modelAttribute="contentDto" method="get" action="/create">
		작성자 : <form:input path="writer"/>  
			<form:errors path="writer" style="color:red;"/> <!-- 에러메세지출력코드 -->
		<br>
		내용 : <form:input path="content"/>  
			<form:errors path="content" style="color:red;"/> <!-- 에러메세지출력코드 -->
		<br>
		<button> 작성 </button>
	</form:form>

</body>
</html>