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
			<a href="logout.jsp">Logout</a> <br>
			<a href="welcome.jsp">HOME</a> 
		</h2>
         <h1>Class Room Management</h1>
		<h2>
			
			<a href="viewClass.jsp">List All ClassRooms</a>
			<form action="classRoom" method="post">
				<table border="1" cellpadding="10">
					<h1>Add New Class</h1>
					<tr>
						<th>Name</th>
						<td><input type="text" name="classRoomName"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="hidden"  name="action" value="new"/>
						<input type="submit" value="Add ClassRoom" /></td>
						
					</tr>
				</table>
			</form>
			
		</h2>
      
</body>
</html>