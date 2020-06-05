<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="vi">
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="ie=edge"> -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style type="text/css">
#container {
	width: 1000px;
	margin: 0 auto;
}

.table {
	width: 1300px;
	margin: 0 auto;
}
</style>
<title>Quản Lý Nhân Viên</title>

</head>
<body>
	<div id="container">
		<nav class="navbar navbar-light bg-light"> <a
			class="navbar-brand">Employee Manager</a>
		<form class="form-inline" action="employeeSearch">
			<input name="search" class="form-control mr-sm-2" type="search"
				placeholder="Search here" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
				value="Search">Search</button>
		</form>
		</nav>
		<br />
		<frm:form modelAttribute="employee" action="employeeProcess"
			method="get">
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput">ID</label>
				<frm:input path="id" id="id" type="text" class="form-control"
					name="formGroupExampleInput" placeholder="Enter ID" />
				<frm:errors path="id" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<frm:select path="departmentIdPK">
					<c:forEach items="${departments}" var="pb">
						<frm:option value="${pb.departmentId}">${pb.departmentId}-${pb.departmentName}</frm:option>
					</c:forEach>
				</frm:select>
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput2">Name</label>
				<frm:input path="name" id="name" type="text" class="form-control"
					name="formGroupExampleInput" placeholder="Enter Your Name" />
				<frm:errors path="name" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput3">Age</label>
				<frm:input path="age" id="age" type="text" class="form-control"
					name="formGroupExampleInput" placeholder="Enter Your Age" />
				<frm:errors path="age" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput4">Phone</label>
				<frm:input path="phone" id="phone" type="text" class="form-control"
					name="formGroupExampleInput" placeholder="Enter Your Phone Number" />
				<frm:errors path="phone" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput5">Emaill</label>
				<frm:input path="email" id="email" type="text" class="form-control"
					name="formGroupExampleInput" placeholder="Enter Your Email" />
				<frm:errors path="email" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput6">Image</label>
				<frm:input path="image" id="image" type="text" class="form-control"
					name="formGroupExampleInput" placeholder="Image" />
				<frm:errors path="image" style="color:red" />
			</div>
			<center>
				<button id="add" name="add" value="Add"
					class="btn btn-outline-success">Add</button>
				<button id="update" name="update" value="Update"
					class="btn btn-outline-primary">Update</button>
				<frm:button id="reset" name="reset" class="btn btn-outline-warning">Reset</frm:button>
			</center>
		</frm:form>
	</div>
	<br>
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Age</th>
				<th scope="col">Phone</th>
				<th scope="col">Email</th>
				<th scope="col">Image</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="s">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.phone}</td>
					<td>${s.email}</td>
					<td>${s.image}</td>
					<td>
						<button id="add" name="add" value="Add"
							class="btn btn-outline-success">
							<a href="edit?id=${s.id}">Edit</a>
						</button> <span>|</span>
						<button id="add" name="add" value="Add"
							class="btn btn-outline-success">
							<a href="delete/${s.id}">Delete</a>
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<center>
		<br>
		<button type="button" class="btn btn-outline-secondary">
			<a
				href="${pageContext.request.contextPath}/departmentManagement/showDepartment">DEPARTMENT</a>
		</button>

	</center>
</body>
</html>