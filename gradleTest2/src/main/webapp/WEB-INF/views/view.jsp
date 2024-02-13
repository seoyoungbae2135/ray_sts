<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		작성자 : ${simpleBbsDto.writer }
	</p>
	<p>
		제목 : ${simpleBbsDto.title }
	</p>
	<p>
		내용 : ${simpleBbsDto.content }
	</p>
	<a href="/list">목록</a>
	<a href="/updateForm?id=${simpleBbsDto.id }">수정</a>
	<a href="delete?id=${simpleBbsDto.id }">삭제</a>

</body>
</html>