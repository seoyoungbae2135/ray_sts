<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> update.jsp </title>

<link rel="stylesheet" href="http://localhost/css/update.css">
</head>
<body>
	<h2>글 수정</h2>
	<form:form modelAttribute="simpleBbsDto" method="post" action="/update">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>작성자</td>
				<td>
					<form:input path="writer" readonly="true" />
				</td> 
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<form:input path="title" />
					<form:errors path="title" />
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<form:input path="content" />
					<form:errors path="content" />
				</td>
			</tr>
			<tr>
				<td> <a href="/list">목록</a> </td>
				<td><button>수정</button>
			</tr>
		</table>
		
	</form:form>
</body>
</html>