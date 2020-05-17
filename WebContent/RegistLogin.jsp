<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/finalProject.css">
<title>Final Project</title>
</head>
<body>
	<form action="final-validate-login">
		<table id="registration">
			<thead>
				<tr>
					<th colspan="2">
						<b>Login</b>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 20%;">
						<b>SSN:</b>
					</td>
					<td>
						<input type="text" name="ssn" value="${student.ssn}" autofocus/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right">
						<input class="button button2" type="submit" value="Login" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>