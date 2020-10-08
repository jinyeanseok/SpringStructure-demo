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

<title>Board read</title>
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
				<a href="/admin/listAll">글</a>
			</div>
			<div class="card-body">

				<div>
					<!-- <button type="button" class="btn btn-primary"
						onclick="location.href='listAll' ">목록</button>
						<br /> -->

						<button class="btn btn-warning">
							<a href="/admin/update?board_number=${BoardVO.board_number}">수정</a>
						</button>

						<button class="btn btn-danger">
							<a href="/admin/delete?board_number=${BoardVO.board_number}">삭제</a>
						</button>


				</div>
				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="title" name="title" class="form-control"
							placeholder="TITLE" value="${BoardVO.title}" required="required"
							readonly autofocus="autofocus"> <label for="title">TITLE</label>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label-group">
						<input type="text" id="identification" name="identification"
							class="form-control" placeholder="identification"
							value="${BoardVO.identification}" readonly required="required">
						<label for="identification">ID</label>
					</div>
				</div>

				<!-- <c:if test="${user.identification == BoardVO.identification }">
					<button type="submit" class="btn btn-primary btn-block">등록</button>
				</c:if> -->

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
