<%@page import="filterEX.User"%>
<%@page import="filterEX.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="filterEX.User" scope="request" />


	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String target;

		userSet(user, id, name, pwd, email);

		// 중복값이 없을경우			
		if (keyDuplicated(id)) {
			userDao.insertUser(user);
			target = "registerInfo.jsp";
		}
		// 중복값이 있을 경우
		else {
			target = "registerForm.jsp?msg=Duplicatd tryAgain";
		}
	%>
	<jsp:forward page="<%=target%>" />



	<%!
	UserDao userDao = UserDao.getInstance();

	public void userSet(User user, String id, String name, String pwd, String email) {
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
		user.setEmail(email);
	}

	public boolean keyDuplicated(String id) {
		// DB와 연결을 해서 중복된 값이 있는지 확인한다.					
		User userDB = userDao.selectUser(id);

			if (userDB.getName() == null) {}
			if (userDB.getPwd() == null) {}
			if (userDB.getEmail() == null) {}
			if (userDB.getId() == null) {}
			else return false;			
		return true;
	}%>

	