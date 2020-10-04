<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="<c:url value="/resources/jquery-2.1.1.min.js"/>"></script> -->
<script src="http://cdn.inlife-club.com/jquery/2.1.1/jquery-2.1.1.js"> </script>
<script type="text/javascript">
	function toJson_submit() {
		ajax_request();
	}
	
	function ajax_request() {
		var userId = loginForm.identification.value;
		var userPwd = loginForm.password.value;
		$.ajax(
				{
					url:'proc',
					type:'POST',
					data:{'identification':userId, 'password':userPwd},
				//	dataType:'json',
					contentType:'application/x-www-form-urlencoded; charset=UTF-8',
					//contentType:'application/json',
					success : function(login) {
						if(login.result==true) {
							$('#result').html('로그인 성공');
						} 
						else {
							$('#result').html('로그인 실패');
						}
					},
				//	error : function(errMsg)
				//	{
				//		alert("에러 :" + errMsg);
				//	}
					error:function(request,status,error){
				        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				       }

				})
	}
</script>
</head>
<body>
<h2>jQuery-AJAX Login Demo</h2>
<div id="result"></div>
<form name="loginForm">
	id <input type="text" name="identification">
	pwd <input type="password" name="password">
	<input type="button" value="SUBMIT" onclick="toJson_submit()">
</form>
</body>
</html>