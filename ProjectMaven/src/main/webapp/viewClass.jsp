<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="com.simplilearn.FactoryProvider"%>
<%@ page import="java.util.*"%>
<%@ page import="com.simplilearn.pojo.ClassRoomPOJO"%>
<%@ page import="org.hibernate.Query"%>
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

	<%
	Session s = FactoryProvider.getFactory().openSession();
	Query q = s.createQuery("from ClassRoomPOJO");
	List<ClassRoomPOJO> list = q.list();

	ServletContext context = getServletContext();
	context.setAttribute("edit", "editClass");
	context.setAttribute("delete", "deleteClass");
	%>
	<h1>List of Classes</h1>
	<table border="1" cellpadding="10">
		<tr>
			<th>Class Id</th>
			<th>Class Name</th>
			<th>Operation</th>
		</tr>

		<%
		for (ClassRoomPOJO classroomlist : list) {
		%>
		<tr>

			<td><input type="text" name="classlistid"
				value=<%=classroomlist.getclasstId()%>></td>
			<td><input type="text" name="classlistname"
				value=<%=classroomlist.getClassName()%>></td>
			<td><a
				href="edit.jsp?class_id=<%=classroomlist.getclasstId()%>">Edit
					Class</a> <a
				href="deleteServlet?class_id=<%=classroomlist.getclasstId()%>">Delete
					Class</a></td>

		</tr>

		<%
		}
		%>
	</table>
	<%
	s.close();
	%>

</body>
</html>