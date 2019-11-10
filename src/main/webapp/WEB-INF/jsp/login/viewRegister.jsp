<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link href="/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<fieldset id="registerFieldset">
		<form:form method="post" action="/register/submit"
			modelAttribute="register">
			<h3 id="titleRegister">Registrieren</h3>
			<jsp:include page="../error/error.jsp" />
			<form:label for="name" path="name" id="labelName">Name*: </form:label>
			<form:input type="text" name="name" path="name" id="inputName" />
			<br>
			<form:label for="lastname" path="lastname" id="labelLastname">Nachname*: </form:label>
			<form:input type="text" id="inputLastname" name="lastname"
				path="lastname" />
			<br>
			<form:label for="username" path="username" id="labelUsername">Username*: </form:label>
			<form:input type="text" name="username" path="username"
				id="inputUsername" />
			<br>
			<form:label for="password" path="password" id="labelPassword">Passwort*:
			</form:label>
			<form:input type="text" id="inputPassword" name="password"
				path="password" />
			<br>
			<form:label for="confirmPassword" path="confirmPassword"
				id="labelConfirmPassword">Bestätige<br> Passwort*: </form:label>
			<form:input type="text" id="inputConfirmPassword"
				name="confirmPassword" path="confirmPassword" />
			<br>
			<form:label for="email" path="email" id="labelEmail">E-Mail*: </form:label>
			<form:input type="text" name="email" path="email" id="inputEmail" />
			<br>
			<br>
			<input type="submit" id="submitButtonRegister" value="Submit" />
			<a href="../login"><input type="button" id="cancelButtonRegister" value="Cancel"></a>
		</form:form>
	</fieldset>
</body>
</html>