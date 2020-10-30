
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="login.css" />
</head>
<body>
	<%@ include file="menu.jspf"%>
	<h1>Register Form</h1>

	<form action="RegisterAction.jsp" method="post"
		onSubmit="return passSubmit();">
		<div class="container">
			<label for="id"><b>ID</b></label> <input type="text"
				placeholder="Enter ID" name="id" id="id"> <label for="name"><b>Name</b></label>
			<input type="text" placeholder="Enter name" name="name" id="name">
			<label for="pwd"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="pwd" id="pwd"> <label
				for="email"><b>email</b></label> <input type="email"
				placeholder="Enter Email" name="email" id="email">
		</div>
		<button onclick="check();">가입</button>
	</form>



	
	<script type="text/javascript">
		
	// msg가 비어있지 않다면 msg를 출력해준다.
	<c:if test="${empty param.msg ? false : true}">
	alert("${param.msg}");	 
	</c:if> 
  
			
	// 각 태그 ID를 변수화한다.		
	let uid = document.getElementById("id");				
	let uname = document.getElementById("name");		
	let upwd = document.getElementById('pwd');
	let uemail = document.getElementById('email');						
				
					
		
		function check() {								
			// passSubmit()가 자동 호출됨;					
		}//end func	
		
		function passSubmit() {
			if (isValid()) {
			return true;	
			}
			return false;
		}//end func
			 				
													      	      			
		// 값이 유효하면 true, 그렇지 않으면 false
		function isValid() {
			// UTF-8 문자열의 Byte 크기 구하기.		
			let unameBytes = stringByteSize(uname.value);
			let upwdBytes = stringByteSize(upwd.value);
			let uemailBytes = stringByteSize(uemail.value);	
			
			// + 는 대,소 영문자, 숫자가 한번 이상 나온다는 의미이며 
			//꺽쇠 바깥쪽의 별표(아스타리스크,*)는 꺽쇠 안의 조건이 0번 이상 반복된다는 의미이다
			// 글자 6이상 20이하
			let regType = /^[A-Za-z0-9+]{6,20}$/;
			
		//오직 숫자와 영문자만 있다면 -> true
		if(!regType.test(uid.value)) {			
			alert(uid.id + "확인해보세요. 영어+숫자 6자 이상 ~ 20자 이하 (한글 X)");
			return false;
		}		
				
		/* id 이후로는 바이트 수가 20이하면 됨 */		
		if (unameBytes > 20 || unameBytes < 6) {
			alert(uname.id + "확인해보세요. 6자 이상 ~ 20자 이하 (한글은 한글자당 3개 차지)");
			return false;
		} 
		
		if (upwdBytes > 20 || upwdBytes < 6) {
			alert(upwd.id + "확인해보세요. 6자 이상 ~ 20자 이하 (한글은 한글자당 3개 차지)");
			return false;
		} 
		
		if (uemailBytes > 20 || uemailBytes < 6) {
			alert(uemail.id + "확인해보세요. 6자 이상 ~ 20자 이하 (한글은 한글자당 3개 차지)");
			return false;
		}
		
			return true;
		} //end func
								
		
	// 각 문자의 유니코드 코드를 분석하여, UTF-8로 변환시 차지하는
    // byte 수를 리턴한다.
    function charByteSize(ch) {
      if (ch == null || ch.length == 0) {
        return 0;
      }

      var charCode = ch.charCodeAt(0);

      if (charCode <= 0x00007F) {
        return 1;
      } else if (charCode <= 0x0007FF) {
        return 2;
      } else if (charCode <= 0x00FFFF) {
        return 3;
      } else {
        return 4;
      }
    }//end func
        

	  // 문자열을 UTF-8로 변환했을 경우 차지하게 되는 byte 수를 리턴한다.
    function stringByteSize(str) {
      if (str == null || str.length == 0) {
        return 0;
      }

      var size = 0;
      for (var i = 0; i < str.length; i++) {
        size += charByteSize(str.charAt(i));
      }

      return size;
    }//end func		
    
    
	</script>
</body>
</html>
