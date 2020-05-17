<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/finalProject.css">
<title>Drop Error</title>
</head>
<body>
	<form action="MyRegist.jsp">
		<table id="registration">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #d04747;">
						<b>Error Dropping Class </b>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<b>ID: </b><%=request.getAttribute("invalidCourseID")%>
					</td>
					<td>
						<b>Title: </b><%=request.getAttribute("invalidCourseTitle")%>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" class="button button2" value="Return" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>