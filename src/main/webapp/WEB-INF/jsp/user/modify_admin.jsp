<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>jys - Login</title>
<script src="http://cdn.inlife-club.com/jquery/2.1.1/jquery-2.1.1.js">
	
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
<script type="text/javascript">
	
</script>

<!-- Bootstrap core CSS-->
<link href="/static/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/static/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="/static/assets/css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

	<div class="container">
		<div class="card card-login mx-auto mt-5">

			<div class="card-header">modify</div>
			<div class="card-body">
				<form method="post" autocomplete="off">
					<div class="form-group">

						<!-- 관리자 입장에서의 회원 변경 test -->
						

						 <c:if test="${user.identification == UserVO.identification }">
						<div class="form-label-group">
							<input type="text" id="identification" name="identification"
								class="form-control" placeholder="ID"
								value="${user.identification}" readonly required="required"
								autofocus="autofocus"> <label for="identification">ID</label>
						</div>
						</c:if>
						
						

					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="password" name="password"
								class="form-control" placeholder="New PassWord"
								required="required"> <label for="password">New
								PassWord</label>
						</div>
					</div>
					
					<!-- <a class="btn btn-primary btn-block" href="index.html">Login</a> -->
					<!-- <input type="button" class="btn btn-primary btn-block" value="modify"> -->
					<button class="btn btn-primary btn-block"
						type="submit">Change Password</button>
				</form>
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
