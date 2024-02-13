<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- 20240207-4 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form:form modelAttribute="simpleBbsDto" method="post" action="/write">
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
				<td colspan="2">
					<button>작성</button>
					<a href="/board">목록</a>
				</td>
			</tr>
		</form:form>
	</table>
</body>
</html>