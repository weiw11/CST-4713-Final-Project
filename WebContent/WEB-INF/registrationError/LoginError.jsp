<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/finalProject.css">
<title>Login Error</title>
</head>
<body>
	<form action="RegistLogin.jsp">
		<table id="registration">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #d04747;">
						Login Error
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 20%;">
						<b>Invalid SSN: </b>
					</td>
					<td align="right">
						<%=request.getAttribute("invalidInput")%>
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