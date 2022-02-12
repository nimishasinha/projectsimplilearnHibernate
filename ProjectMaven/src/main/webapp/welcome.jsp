<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to school</title>
</head>
<body>

	<%
	HttpSession session1 = request.getSession(false);
	String name = (String) session1.getAttribute("name");
	out.print("Welcome  " + name + " ......");
	out.print("Please Enter the Details");
	%>



	<h2>
		<a href="logout.jsp">Logout</a>
	</h2>



	<h2>Student Management</h2>
	<h3>
		<a href="createStudent.jsp">Add New Student</a> <a
			href="viewStudent.jsp">List All Students</a>
	</h3>

	<h2>ClassRoom Management</h2>
	<h3>
		<a href="createClass.jsp">Add New Class</a> <a href="viewClass.jsp">List
			All Classes</a>
	</h3>

	<h2>Teacher Management</h2>
	<h3>
		<a href="createTeacher.jsp">Add New Teacher</a> <a
			href="viewTeacher.jsp">List All Teacher</a>
	</h3>


	<h2>Subject Management</h2>
	<h3>
		<a href="createSubject.jsp">Add New Subject</a> <a
			href="viewSubject.jsp">List All Subject</a>
	</h3>
</body>
</html>