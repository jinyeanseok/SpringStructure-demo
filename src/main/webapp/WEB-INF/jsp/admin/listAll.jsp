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

<title>Admin - Dashboard</title>

<style type="text/css">
.center {
	text-align: center;
	margin-left: 700px
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script>
	var result = "${result}";
	if (result === "modifyOK") {
		alert("비밀번호가 변경되었습니다.");
	} else if (result === "registerOK") {
		alert("회원가입이 완료되었습니다.");
	} else if (result === "deleteOK") {
		alert("회원삭제가 완료되었습니다.");
	}
</script>

<!-- Bootstrap core CSS-->
<link href="/static/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/static/assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="/static/assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/static/assets/css/sb-admin.css" rel="stylesheet">


</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

	<a class="navbar-brand mr-1" href="/admin/listAll">Admin Page</a>

	<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
		id="sidebarToggle" href="#">
		<i class="fas fa-bars"></i>
	</button>

	<div class="center">
		<c:if test="${user != null }">
      	     ${user.name}님 안녕하세요
      </c:if>
	</div>

	<!-- Navbar Search -->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search for..."
				aria-label="Search" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-primary" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- Navbar -->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
				class="badge badge-danger">9+</span>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="alertsDropdown">
				<a class="dropdown-item" href="#">Action</a> <a
					class="dropdown-item" href="#">Another action</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Something else here</a>
			</div></li>
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
				class="badge badge-danger">7</span>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="messagesDropdown">
				<a class="dropdown-item" href="#">Action</a> <a
					class="dropdown-item" href="#">Another action</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Something else here</a>
			</div></li>

		<li class="nav-item dropdown no-arrow">
			<!-- <button class="nav-link dropdown-toggle" data-toggle="dropdown" id="userDropdown" aria-haspopup="true"
			aria-expanded="false" ></button> --> <a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
		</a>

			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="#">Settings</a> <a
					class="dropdown-item" href="#">Activity Log</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="/user/register">register</a> <a
					class="dropdown-item" href="/login/form">login</a>
				<c:if test="${user != null }">
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
					<a class="dropdown-item" href="/user/modify">modify</a>
					<a class="dropdown-item" href="/user/delete">delete</a>

				</c:if>

				<!-- 회원정보 변경추가 -->
			</div>
		</li>
	</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="/admin/listAll"> <i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Dashboard</span>
			</a></li>

			<c:if test="${user.verify == 9}">
				<li class="nav-item"><a class="nav-link" href="/user/userAll">
						<i class="fas fa-fw fa-tachometer-alt"></i> <span>회원관리</span>
				</a></li>
			</c:if>

			<!-- 루트 관리자인 admin만 관리자 가입할 수 있는 링크 보이도록 -->
			<c:if test="${user.identification == 'admin'}">
				<li class="nav-item"><a class="nav-link"
					href="/admin/admin_register"> <i
						class="fas fa-fw fa-chart-area"></i> <span>관리자가입</span>
				</a></li>
			</c:if>
			
				<li class="nav-item"><a class="nav-link"
					href="/user/userIntegrated"> <i
						class="fas fa-fw fa-chart-area"></i> <span>회원 기록</span>
				</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="/board/boardIntegrated"> <i
						class="fas fa-fw fa-chart-area"></i> <span>게시판 기록</span>
				</a></li>

		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Overview</li>
				</ol>

				<!-- Icon Cards-->
				<div class="row">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-primary o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-comments"></i>
								</div>
								<div class="mr-5">26 New Messages!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-list"></i>
								</div>
								<div class="mr-5">11 New Tasks!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-success o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">123 New Orders!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-life-ring"></i>
								</div>
								<div class="mr-5">13 New Tickets!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
				</div>

				<!-- Area Chart Example-->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-chart-area"></i> Area Chart Example
					</div>
					<div class="card-body">
						<canvas id="myAreaChart" width="100%" height="30"></canvas>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Data Table Example
					</div>
					<div class="card-body">

						<!-- <c:if test="${user.identification != null}">
						<a href="/board/register"><button
								class="btn btn-primary btn-xs">새글 작성</button></a>
					</c:if> -->

						<a href="/admin/register"><button
								class="btn btn-primary btn-xs">새글 작성</button></a>
								
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<tr>
									<!-- 한줄 -->
									<th>번호</th>
									<!-- 첫번째 칸 -->
									<th>제목</th>
									<!-- 두번째 칸 -->
									<th>작성자</th>
									<!-- 세번째 칸 -->
									<th>작성일자</th>
								</tr>

								<c:forEach items="${list}" var="boardVO">
									<tr>
										<td>${boardVO.board_number}</td>
										<td><a
											href="/admin/read?board_number=${boardVO.board_number}">${boardVO.title}</a></td>
										<td>${boardVO.identification}</td>
										<td><fmt:formatDate pattern="YYYY-MM-dd"
												value="${boardVO.create_date}" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright © Your Website 2018</span>
				</div>
			</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="/user/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/static/assets/vendor/jquery/jquery.min.js"></script>
	<script
		src="/static/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/static/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="/static/assets/vendor/chart.js/Chart.min.js"></script>
	<script src="/static/assets/vendor/datatables/jquery.dataTables.js"></script>
	<script src="/static/assets/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/static/assets/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="/static/assets/js/demo/datatables-demo.js"></script>
	<script src="/static/assets/js/demo/chart-area-demo.js"></script>

</body>

</html>