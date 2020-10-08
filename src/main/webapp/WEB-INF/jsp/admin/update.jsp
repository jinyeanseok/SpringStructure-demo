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

<title>Board update</title>
<script src="http://cdn.inlife-club.com/jquery/2.1.1/jquery-2.1.1.js">
	
</script>

<script type="text/javascript">
	var result = "${result}";
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
			<!-- <div class="card-header">Login</div> -->
			<div class="card-header">
				<a href="/admin/listAll">글 수정</a>
			</div>
			<div class="card-body">
				<form name="loginForm" method="post">
	
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="title" name="title" class="form-control" value="${BoardVO.title}"
								placeholder="TITLE" required="required" autofocus="autofocus">
							<label for="title">TITLE</label>
						</div>
					</div>
					
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="identification" name="identification" class="form-control"
								placeholder="identification" value="${BoardVO.identification}" required="required" readonly> <label
								for="identification">ID</label>
						</div>
					</div>

					<button type="submit" class="btn btn-primary btn-block">등록</button>

				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="static/assets/vendor/jquery/jquery.min.js"></script>
	<script src="static/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="static/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
