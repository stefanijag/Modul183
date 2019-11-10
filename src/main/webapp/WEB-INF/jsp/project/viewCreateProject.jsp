<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Project</title>
<link href="/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="../projectAdmin">Overview</a></li>
			<li><a href="../project">Add Project</a></li>
			<li><a href="..//project/role">Change Roles</a></li>
			<li id="menuLogout"><a href="../login">Log out</a></li>
		</ul>
	</div>
	<form:form method="post" action="/project/add"
		modelAttribute="project">
		<fieldset id="createProjectFieldset">
			<h3 id="titleCreateProject">Add New Project</h3>
			<jsp:include page="../error/error.jsp"/>
			<form:label for="projectName" path="projectName" id="labelProjectName">Project Name*: </form:label>
			<form:input type="text" name="projectName" path="projectName" id="inputProjectName" /><br>
			<form:label for="releaseDate" path="releaseDate" id="labelReleaseDate">Release Date*: </form:label>
			<form:input type="date" id="inputReleaseDate" name="releaseDate"
				path="releaseDate"/>
			<br>
			<form:label for="description" path="description" id="labelDescription">Description*: </form:label>
			<form:input type="text" name="description" path="description" id="inputDescription" /><br>		
			<input type="submit" id="submitButtonCreateProject" value="Submit" />
			<a href="../overviewProjectAdmin"><input type="button" id="cancelButtonCreateProject" value="Cancel"/></a>
		</fieldset>
	</form:form>
</body>
</html>