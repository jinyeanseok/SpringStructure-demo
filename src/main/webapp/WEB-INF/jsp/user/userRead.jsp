<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>jys - Register</title>

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
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">admin user modify</div>
			<div class="card-body">
				<!-- <form method="post" autocomplete="off"> -->
				<div class="form-group">
				
					<div class="form-label-group">
						<button class="btn btn-warning">
							<a href="/user/modify_admin?identification=${UserVO.identification}">수정</a>
						</button>

						<button class="btn btn-danger">
							<a href="/user/delete_admin?identification=${UserVO.identification}">삭제</a>
						</button>
					</div>
					
					<div class="form-label-group">
						<input type="text" id="identification" name="identification"
							class="form-control" value="${UserVO.identification}"
							placeholder="ID" readonly required="required"> <label
							for="identification">ID</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="password" id="password" name="password"
							class="form-control" placeholder="password"
							value="${UserVO.password}" readonly required="required">
						<label for="password">password</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="name" name="name" class="form-control"
							placeholder="name" value="${UserVO.name}" readonly
							required="required"> <label for="name">name</label>
					</div>
				</div>

				<!-- <a class="btn btn-primary btn-block" href="login.html">Register</a> -->
				<!-- <button type="submit" class="btn btn-primary btn-block">Register</button> -->
				<!-- </form> -->
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/static/assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="/static/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/static/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
