
<%@page import="filterEX.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="filterEX.User" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="login.css" />
</head>
<body>
	
	<%@ include file="menu.jspf"%>	
	<h2>Register INFORMATION</h2>
	<h3>회원가입이 완료되었습니다 !!</h3>
	<h4>회원님의 자세한 가입정보는 아래와같습니다. </h4>
	
	

	<form action="index.jsp">
		<div class="container">			
			<label for="id"><b>ID</b></label> 
			<input type="text" value= "${user.id}" readonly="readonly"> 
			<label for="name"><b>Name</b></label> 
			<input type="text" value="${user.name}" readonly="readonly"> 
			<label for="pwd"><b>Password</b></label> 
			<input type="password" value="${user.pwd}" readonly="readonly"> 
			<label for="email"><b>email</b></label> 
			<input type="email" value="${user.email}" readonly="readonly">
		</div>		
	</form>
	
	
	
	
	
</body>
</html>
