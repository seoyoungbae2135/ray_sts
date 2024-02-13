<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> list.jsp </title>
</head>
<!-- 20240213-4 -->
<body>

	<h2>게시판</h2>
	
	<a href="writeForm">글쓰기</a>
	<table>
		<tr>
			<th>번호</th> <th>제목</th> <th>작성자</th>
		</tr>
		
		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.id }</td>
				<td> <a href="/view?id=${row.id }">${row.title }</a> </td>
				<td>${row.writer }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
	
		
	
</body>
</html>