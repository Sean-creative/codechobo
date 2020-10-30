
<%@page import="filterEX.User"%>
<%@page import="filterEX.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="login.css" />
</head>
<body>
	<%						
	// 1. 세션에서 사용자 아이디값을 가져온다.
		String sID = (String) session.getAttribute("id");
	
	// 2. DB에서 사용자 정보를 가져온다.
		UserDao userDao = UserDao.getInstance();
	
	// 3. useBean 값에다가 넣어준다.	
		User user = userDao.selectUser(sID);		
		System.out.println(user);
	%>
	
	<%@ include file="menu.jspf"%>	
	<h2>USER INFORMATION</h2>	
	<h4>회원님의 자세한 개인정보는 아래와같습니다. <br> 
	 정보 변경 뒤에 '수정' 버튼을 눌러주세요.  <br>
	 삭제 버튼을 누를 시 즉시 삭제되니 주의해주세요!</h4>
	


	<form action="ModifyAction" method="post">
		<div class="container">			
			<label for="id"><b>ID</b></label> 
			<input type="text" name="id" value= "<%=user.getId()%>" readonly="readonly"> 
			<label for="name"><b>Name</b></label> 
			<input type="text" name="name" value="<%=user.getName()%>" > 
			<label for="pwd"><b>Password</b></label> 
			<input type="password" name="pwd" value="<%=user.getPwd()%>" > 
			<label for="email"><b>email</b></label> 
			<input type="email"name="email" value="<%=user.getEmail()%>" >
							
			<button name="button" value="modify"> 수정</button>
			<button name="button" value="remove"> 삭제</button>
		</div>		
	</form>
					
</body>
</html>
