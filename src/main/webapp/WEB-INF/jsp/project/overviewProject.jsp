<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Overview Project</title>
<link href="/resources/styleFile.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="../projectUser">Overview</a></li>
			<li id="menuLogout"><a href="../login">Log out</a></li>
		</ul>
	</div>
	<fieldset id="overviewProjectFieldset">
		<h3 id="titleOverviewProjects">Overview Projekte</h3>
		<jsp:include page="../error/error.jsp" />
		<table>
			<tr>
				<th>Projektname</th>
				<th>Release Date</th>
				<th>Beschreibung</th>
				<th>Entwicklungsteam</th>
			</tr>
			<c:forEach items="${projects}" var="project" varStatus="loop">
				<tr>
					<td>${project.getProjectName()}</td>
					<td>${project.getReleaseDate()}</td>
					<td>${project.getDescription()}</td>
					<td>${project.getTeam().getTeamname()}</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>