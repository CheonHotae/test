<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table,td,tr{
	border: 5px solid black;
	border-collapse: collapse;
	}
</style>
<body>
	<h1>MemberJoinForm_test.jsp</h1>
	<form action="memberJoin" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>아이디</td>
			<td> <input type="text" name="mid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <input type="text" name="mpw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td> <input type="text" name="mname"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td> <input type="date" name="mbirth"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td> <input type="text" name="memail"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td> <input type="text" name="maddress"></td>
		</tr>
		<tr>
			<td>프로필이미지</td>
			<td> <input type="file" name="mfile"></td>
		</tr>
		<tr>
			<th colspan="2"> <input type="submit" value="회원가입"></th>
			
		</tr>
	</table>
	</form>
	
</body>
</html>