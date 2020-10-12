<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Login</title>
	<script src="http://cdn.inlife-club.com/jquery/2.1.1/jquery-2.1.1.js"> </script>
	
	<script type="text/javascript">
	
	var result = "${result}";
	
	if(result === "modifyOK") {
		alert("비밀번호가 변경되었습니다.");
	} else if(result === "logoutOK") {
		alert("로그아웃 되었습니다.");
	}
	
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
					dataType:'json',
					contentType:'application/x-www-form-urlencoded; charset=UTF-8',
					//contentType:'application/json',
					success : function(login) {
						if(login.result==true) {
							//$('#result').html('로그인 성공');
							alert("로그인 성공");
							//location.href="/dashBoard.jsp";
							location.href="../board/listAll";
						} 
						else {
							//$('#result').html('로그인 실패');
							alert("로그인 실패");
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
	
    <!-- Bootstrap core CSS-->
    <link href="/static/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/static/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/static/assets/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <!-- <div class="card-header">Login</div> -->
        <div class="card-header"><a href="/sample/home">Login</a></div>
        <div class="card-body">
          <form name="loginForm">
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="identification" name="identification" class="form-control" placeholder="ID" required="required" autofocus="autofocus">
                <label for="identification">ID</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" id="password" class="form-control" placeholder="Password" required="required">
                <label for="password">Password</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me">
                  Remember Password
                </label>
              </div>
            </div>
            <!-- <a class="btn btn-primary btn-block" href="index.html">Login</a> -->
           		 <input type="button" class="btn btn-primary btn-block" value="Login" onclick="toJson_submit()">
            <!-- <input type="button" value="SUBMIT" onclick="toJson_submit()"> -->
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="/user/register">Register an Account</a>
            <a class="d-block small" href="/login/pwdFind">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/static/assets/vendor/jquery/jquery.min.js"></script>
    <script src="/static/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/static/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
