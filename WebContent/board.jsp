<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is Board</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>


<body>
<%@ include file="menu.jspf"%>
<h1>THIS IS BOARD</h1>


	<table class="tbl-ex">
		<tr>
			<th>형식</th>
			<th>선택자 이름</th>
			<th>스타일 적용 요소</th>
			<th>호환성</th>
						
						
						
						<!-- GIT 테스트!!! -->		
		</tr>


		<tr>
			<td>a</td>
			<td>HTML</td>
			<td>모든 HTML에 적용</td>
			<td>IE4, FF1,Safari 1, 크롬 1,오페라 3.5, CSS1</td>
		</tr>



		<tr class="even">
			<td>.classname</td>
			<td>클래스</td>
			<td>클래스로 정의해 준 HTML 태그</td>
			<td>IE4, FF1,Safari 1, 크롬 1,오페라 3.5, CSS1</td>
		</tr>


		<tr>
			<td>a.classname</td>
			<td>종속 클래스</td>
			<td>특정 HTML 태그에 종속된 클래스</td>
			<td>IE4, FF1,Safari 1, 크롬 1,오페라 3.5, CSS1</td>
		</tr>



		<tr class="even">
			<td>#idname</td>
			<td>아이디</td>
			<td>아이디로 정의해준 HTML 태그</td>
			<td>IE4, FF1,Safari 1, 크롬 1,오페라 3.5, CSS1</td>
		</tr>



		<tr>
			<td>a#idname</td>
			<td>종속아이디</td>
			<td>특정 HTML 태그에 종속된 아이디</td>
			<td>IE4, FF1,Safari 1, 크롬 1,오페라 3.5, CSS1</td>

		</tr>

		<tr class="even">
			<td>*</td>
			<td>전체 선택</td>
			<td>모든 HTML 태그에 적용</td>
			<td>IE4, FF1,Safari 1, 크롬 1,오페라 3.5, CSS2</td>
		</tr>

	</table>

</body>
</html>