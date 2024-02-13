<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> form 받아오기</title>
</head>
<!-- 20240205-8 -->
<body>
	<form method="get" action="/input3"> <!-- 데이터받아오는 방법에 따라 /input1, input2, inpit3 으로 변경 -->
		아이디 : <input type="text" name="myId"> <br>
		이름 : <input type="text" name="myName"> <br>
		<button>작성</button> <!-- <button type="button" id="send"> -->
	</form> 
	
	<a href="/input4/sky/강하늘">강하늘</a> <!--데이터받아오는 4번째 방법에 해당 20240206-1  -->
	<a href="/input4/ha/하지원">하지원</a>  <!--주소로 받아서 처리하는 방법 /input4까지가 주소 그이하는 페이지를 주소처럼 받아오는 것 -->
</body>
</html>