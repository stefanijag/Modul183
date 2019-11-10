<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form:form method="post" action="/login/check" modelAttribute="login">
		<fieldset id="loginFieldset">
			<h3 id="loginTitle">Login</h3>
			<jsp:include page="../error/error.jsp" />
			<form:label for="username" path="username" id="labelUsername">Username: </form:label>
			<form:input type="text" name="username" path="username"
				id="inputUsername" />
			<br>
			<form:label for="password" path="password" id="labelPassword">Passwort:
			</form:label>
			<form:input type="password" name="password" path="password"
				id="inputPassword" />
			<br>
		<input type="submit" id="submitButtonLogin" value="Submit" />
		<br>
		<br>
		<a href="../register">Kein Account? Registriere dich hier</a>
		</fieldset>
	</form:form>
</body>
</html>