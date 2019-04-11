<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Goal</title>

<style type="text/css">
.error {
	color: red;
}

.error-block {
	color: #000;
	background-color: #ffEEEE;
	border: 3px;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>

	<form:form commandName="goal">
		<form:errors path="*" cssClass="error-block" element="div" />
		<table>
			<tr>
				<th>Enter Minutes</th>
				<th><form:input path="minutes" /></th>
				<th><form:errors path="minutes" cssClass="error" /></th>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Enter the goal" /></td>
			</tr>
		</table>

	</form:form>


</body>
</html>