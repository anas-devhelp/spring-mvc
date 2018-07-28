<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/commonHeaderJsCss.jsp"></jsp:include>
<title>Roles | List</title>
</head>
<body class="fixed-sn white-skin">
	<jsp:include page="../common/navigation.jsp"/>
	<!--Main layout-->
	<main>
		<div class="container-fluid">
			<!--Section: Table-->
			<section>
				<div class="card card-cascade narrower z-depth-0">
				<!--Card image-->
				<div class="view gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">
					<div>
						<button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2"><i class="fa fa-th-large mt-0"></i></button>
						<button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2"><i class="fa fa-columns mt-0"></i></button>
					</div>
	
					<a href="" class="white-text mx-3">Roles: List</a>
					<div>
						<button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2"><i class="fa fa-pencil mt-0"></i></button>
						<button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2"><i class="fa fa-remove mt-0"></i></button>
						<button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2"><i class="fa fa-info-circle mt-0"></i></button>
					</div>
	
				</div>
				<!--/Card image-->
	
				<div class="px-4">
	
					<div class="table-responsive">
						<!--Table-->
						<table class="table table-hover mb-0">
	
							<!--Table head-->
							<thead>
								<tr>
									<th>
										<input type="checkbox" id="checkbox">
										<label for="checkbox" class="mr-2 label-table"></label>
									</th>
									<th class="th-lg">Name<i class="fa fa-sort ml-1"></i></th>
									<th class="th-lg">Description<i class="fa fa-sort ml-1"></i></th>
									<th class="th-lg">Actions</th>
								</tr>
							</thead>
							<!--Table head-->
	
							<!--Table body-->
							<tbody>
								<c:forEach items="${entities}" var="role">
									<tr>
										<th scope="row">
											<input type="checkbox" id="domaincheckbox${role.id}">
											<label for="domaincheckbox${role.id}" class="label-table"></label>
										</th>
										<td>${role.name}</td>
										<td>${role.description}</td>
										<td>
											<a href="<c:url value='/role-permissions/${role.id}/edit' />">Permissions</a>&nbsp;&nbsp;
											<a href="<c:url value='/roles/${role.id}/edit' />">Edit</a>&nbsp;&nbsp;
											<a href="<c:url value='/roles/${role.id}/delete' />">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<!--Table body-->
						</table>
						<!--Table-->
					</div>
	
					<hr class="my-0">
	
					<!--Bottom Table UI-->
					<div class="d-flex justify-content-between">
	
						<!--Name-->
						<select class="mdb-select colorful-select dropdown-primary mt-2 hidden-md-down">
							<option value="" disabled >Rows number</option>
							<option value="1" selected>5 rows</option>
							<option value="2">25 rows</option>
							<option value="3">50 rows</option>
							<option value="4">100 rows</option>
						</select>
	
						<!--Pagination -->
						<nav class="my-4">
							<ul class="pagination pagination-circle pg-blue mb-0">
	
								<!--First-->
								<li class="page-item disabled clearfix d-none d-md-block"><a class="page-link">First</a></li>
	
								<!--Arrow left-->
								<li class="page-item disabled">
									<a class="page-link" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
								</li>
	
								<!--Numbers-->
								<li class="page-item active"><a class="page-link">1</a></li>
								<li class="page-item"><a class="page-link">2</a></li>
								<li class="page-item"><a class="page-link">3</a></li>
								<li class="page-item"><a class="page-link">4</a></li>
								<li class="page-item"><a class="page-link">5</a></li>
	
								<!--Arrow right-->
								<li class="page-item">
									<a class="page-link" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
									</a>
								</li>
	
								<!--First-->
								<li class="page-item clearfix d-none d-md-block"><a class="page-link">Last</a></li>
	
							</ul>
						</nav>
						<!--/Pagination -->
	
					</div>
					<!--Bottom Table UI-->
					</div>
					 
			</div>
			</section>	
			<section class="mb-5 pb-4">
				<a href="<c:url value='/roles/new' />" class="btn btn-primary waves-effect waves-light">Add new</a>
			</section>	
		</div>
	</main> 
	<jsp:include page="../common/commonFooterJsCss.jsp"/>
</body>
</html>