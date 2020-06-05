<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title><spring:message code="global.register.link.title" /></title>
<style type="text/css">
        .container {
            width:600px;
        }

        .login-container {
            margin-top: 5%;
            margin-bottom: 5%;
        }

        .login-form-1 {
            padding: 5%;
            box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
        }

        .login-form-1 h3 {
            text-align: center;
            color: #333;
        }

        .login-container form {
            padding: 10%;
        }

        .btnSubmit {
            width: 50%;
            border-radius: 1rem;
            padding: 1.5%;
            border: none;
            cursor: pointer;
        }

        .login-form-1 .btnSubmit {
            font-weight: 600;
            color: #fff;
            background-color: #0062cc;
        }
    </style>
</head>
<body>
	${message}
	<div class="container">
        <div class="login-form-1">
            <h3>
                <spring:message code="global.register.link.title" />
            </h3>
            <frm:form modelAttribute="user" action="registerAction" method="POST">
                <div class="form-group">
                    <spring:message code="username" />
                    <frm:input path="userName" id="userName" type="text" class="form-control" placeholder="Your Email *"
                        value="" />
                </div>
                <div class="form-group">
                    <spring:message code="pass" />
                    <frm:input path="pass" id="pass" type="password" class="form-control" placeholder="Your Password *"
                        value="" />
                </div>
                <div class="form-group" align="center">
                    <frm:button id="register" name="register" type="submit" class="btnSubmit" value="Register"><spring:message code="global.register.link.title" /></frm:button>
                </div>
            </frm:form>
            <div align="right">
                <spring:message code="ngonngu" /> : <a href="?lang=en">English</a> | <a href="?lang=vi">VN</a>
            </div>
        </div>
        <br>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th scope="col">
                        <spring:message code="cotid" />
                    </th>
                    <th scope="col">
                        <spring:message code="cotten" />
                    </th>
                    <th scope="col">
                        <spring:message code="hanhdong" />
                    </th>
                </tr>
                <%
			        int i = 1;
		        %>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><%=i++%></td>
                        <td>${user.userName}</td>
                        <td>
                            <button id="add" name="add" value="Add" class="btn btn-outline-success">
                                <a href="edit?id=${user.userName}"><spring:message code="update" /></a>
                            </button>
                            <span>|</span>
                            <button id="add" name="add" value="Add" class="btn btn-outline-success">
                                <a href="delete?id=${user.userName}"><spring:message code="delete" /></a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>