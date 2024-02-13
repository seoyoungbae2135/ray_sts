<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> write.jsp</title>
</head>
<!-- 20240213-4  -->
<body>
	<h3>글쓰기</h3>
	<form:form modelAttribute="simpleBbsDto" method="post" action="/write">
		<table>
			<tr>
				<td>작성자</td>
				<td>
					<form:input path="writer"/>
					<form:errors path="writer"/>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<form:input path="title"/>
					<form:errors path="title"/>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<form:input path="content"/>
					<form:errors path="content"/>
				</td>
			</tr>
			<tr>
				<td><a href="/list">목록</a></td>
				<td><button>작성</button></td>
			</tr>
		</table>
	</form:form>

</body>
</html>