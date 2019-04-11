<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Minutes Page</title>

<script type="text/javascript" src="jquery-3.4.0.js"></script>
<script type="text/javascript">
	$(document).ready(() => {
		$.getJSON('<spring:url value="activities.json"/>',{
			ajax:'true'
		},(data) => {
			let html = '<option value="">--Selecte one--</option>';
			$.each(data,(i,v)=>{
				html += '<option value="'+v.desc+'">'+v.desc+'</option>';
			});
			html += '</option>';
			
			$('#activities').html(html);
		})
	});
</script>

</head>
<body>
	<h1>Add Minutes Exercised</h1>

	<!-- el parametro que se envía es el que que recibe en el bean del interceptor  -->
	Idioma:
	<a href="?idioma=es">Español</a> |
	<a href="?idioma=en">English</a>

	<br>
	<!-- el commandName es el nombre del parametro que tiene el controler(ModelAttribute) para poder hacer bind con esta vista -->
	<form:form commandName="exercise">
		<table>
			<tr>
				<td><spring:message code="goal.text" /></td>
				<td><form:input path="minutes" /></td>
				<td><form:select id="activities" path="activity" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Enter Exercise" />
				</td>
			</tr>
		</table>
	</form:form>
	<h2>Our goal for the day is: ${goal.minutes}</h2>
</body>
</html>