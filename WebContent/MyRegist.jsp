<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/finalProject.css">
<title>My Registration</title>
</head>
<body>
	<table id="registration">
		<thead>
			<tr>
				<th colspan="3"><b>Student Info </b></th>
			</tr>
			<tr>
				<td colspan="2"><b>Name: </b>${student.fullName}</td>
				<td align="right"><b>Phone #: </b>${student.phone}</td>
			</tr>
			<tr>
				<td colspan="3"><b>My Classes:</b></td>
			</tr>
			<tr>
				<th>Course ID</th>
				<th style="width:60%;">Course Title</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
${enrollment.output}
		</tbody>
		<tfoot>
			<tr>
				<td><form action="RegistLogin.jsp">
						<input class="button button3" type="submit" value="Exit" />
					</form></td>
				<td></td>
				<td colspan="2" align="right">
					<form action="Enroll.jsp">
						<input class="button" type="submit" value="Enroll" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>