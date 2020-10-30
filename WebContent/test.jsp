<%@page import="filterEX.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id ="user" class="filterEX.User" scope="request"/>
<c:set var="c" value= "5" scope="request"/>

<c:if test="${c == 'hi' }" >
	같나?? <br>
</c:if>




<br>

<script> var b = 3;</script>

<% int a = 3; %>

a = 3;
 
<br>
a = <%=a%>

<br>
a = ${a}

<br>
b = ${b}

<br>
c = ${c}


<br>
user = ${user}

<br>
user = <%=user%>



</body>
</html>