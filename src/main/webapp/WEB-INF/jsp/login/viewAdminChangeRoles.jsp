<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change role of user</title>
<link href="/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="../projectAdmin">Overview</a></li>
			<li><a href="../project">Add Project</a></li>
			<li><a href="..//project/role">Change Roles</a></li>
			<li id="menuLogout">Log out</li>
		</ul>
	</div>

	<form:form method="post" action="/project/role/submit"
		modelAttribute="login">
		<fieldset id="registerFieldset">
			<h3 id="titleRegister">Change Role Of User</h3>
			<jsp:include page="../error/error.jsp" />
			<br>
			<form:label for="username" path="username" id="labelUsername">Username: </form:label>
			<form:select path="username">
				<c:forEach items="${usernames}" var="username" varStatus="loop">
					<form:option name="username" value="${username.getLoginId()}">${username.getUsername()}</form:option>
				</c:forEach>
			</form:select>
			<br> <label for="role" id="labelRole">Role: </label> <input
				type="radio" name="role" value="AD"> Admin <input
				type="radio" name="role" value="US"> User <br> <br>

			<input type="submit" id="submitButtonRegister" value="Submit" />
			<button id="cancelButtonRegister">Cancel</button>
		</fieldset>
	</form:form>
</body>
</html>