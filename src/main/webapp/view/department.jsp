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
<title>Quản Lý Phòng Ban</title>

</head>
<body>
	<div id="container">
		<nav class="navbar navbar-light bg-light"> <a
			class="navbar-brand">Department Manager</a> <!-- <form class="form-inline" action="employeeSearch">
           		<input name="search" class="form-control mr-sm-2" type="search" placeholder="Search here" aria-label="Search">
            	<button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">Search</button>
        	</form> --> </nav>
		<br />
		<frm:form modelAttribute="department" action="departmentProcess"
			method="get">
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput">Department ID</label>
				<frm:input path="departmentId" id="departmentId" type="text"
					class="form-control" name="formGroupExampleInput"
					placeholder="Enter Department ID" />
				<frm:errors path="departmentId" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput2">Department Name</label>
				<frm:input path="departmentName" id="departmentName" type="text"
					class="form-control" name="formGroupExampleInput"
					placeholder="Enter Department Name" />
				<frm:errors path="departmentName" style="color:red" />
			</div>
			<div class="form-group col-md-6 mb-3">
				<label for="formGroupExampleInput3">Adress</label>
				<frm:input path="adress" id="adress" type="text"
					class="form-control" name="formGroupExampleInput"
					placeholder="Enter Adress" />
				<frm:errors path="adress" style="color:red" />
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
				<th scope="col">Department ID</th>
				<th scope="col">Department Name</th>
				<th scope="col">Adress</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${departments}" var="d">
				<tr>
					<td>${d.departmentId}</td>
					<td>${d.departmentName}</td>
					<td>${d.adress}</td>
					<td>
						<button class="btn btn-outline-info">
							<a href="edit?departmentId=${d.departmentId}">Edit</a>
						</button> <span>|</span>
						<button class="btn btn-outline-danger">
							<a href="delete/${d.departmentId}">Delete</a>
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
				href="${pageContext.request.contextPath}/employeeManagement/showEmployee">EMPLOYEE</a>
		</button>

	</center>
</body>
</html>