<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%		
		// 1. 세션을 종료시킨다
		session.invalidate(); 

		// 2. index.jsp로 이동한다.
		response.sendRedirect("index.jsp");
	%>
	
</body>
</html>