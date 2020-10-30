
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="login.css" />
</head>
<body>
	<%@ include file="menu.jspf"%>

	<%!public boolean checkLogin(String sID) {
		if (sID == null)
			return false;
		return true;
	}%>

	<%
		// destination이라는 key가 없으면 ""가 들어간다.
		String destination = request.getParameter("destination");
		String sID = (String) session.getAttribute("id");

	
		System.out.println("destination!!! : " + destination);
		System.out.println("sID!!!!!! : " + sID);

		/* 1. 로그인하고 관련된 세션이 있으면 index로 보낸다. */
		if (checkLogin(sID))
			response.sendRedirect("index.jsp");
	%>


	<!-- 2. 로그인 관련 세션이 없으면 로그인 보여준다. -->
	<h2>Login Form</h2>

	<form action="LoginAction?destination=${param.destination}"
		method="post">

		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="id"> <label for="psw"><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="pwd">

			<%-- <input type="hidden" name="boardpath" value="<%=boardPath%>"> --%>
			<button type="submit">Login</button>
		</div>
	</form>
</body>
</html>
