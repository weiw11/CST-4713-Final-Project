<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/finalProject.css">
<title>Enrollment</title>
</head>
<body>
<form action="final-menu-redirector">
	<table id="registration">
		<thead>
			<tr>
				<th colspan="3">
					<b>Enrollment</b>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<b>Courses:</b>
				</td>
				<td colspan="2">
					<select name="courses">
${courses.output}
					</select>
				</td>
			</tr>
			<tr>
				<td><b>Grade:</b></td>
				<td colspan="2">
					<select name="grade">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
					</select>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td><input class="button button3" type="submit" name="action" value="Exit"></td>
				<td align="center"><input class="button button4" type="submit" name="action" value="Drop"></td>
				<td align="right"><input class="button" type="submit" name="action" value="Register"></td>
			</tr>
		</tfoot>
	</table>
</form>
</body>
</html>