<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<a href="logout.jsp">Logout</a> <br> <a href="welcome.jsp">HOME</a>
	</h2>
	<h1>Subject Management</h1>
	<h2>

		<a href="viewSubject.jsp">List All Subjects</a>
		<form action="addServlet" method="post">
			<table border="1" cellpadding="10">
				<h1>Add New Subject</h1>
				<tr>
					<th>Subject Name</th>
					<td><input type="text" name="subjectName"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="hidden"
						name="action" value="new" /> <input type="submit"
						value="Add Subject" /></td>

				</tr>
			</table>
		</form>
		<%
		ServletContext context = getServletContext();
		context.setAttribute("add", "addSubject");
		%>
	</h2>
</body>
</html>