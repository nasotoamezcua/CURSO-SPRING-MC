<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Telefono</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
<link href="<c:url value="/resources/css/telefono.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/telefono.js" />"></script>


</head>
<body>	
	<div class="prueba">Hola</div>

	<div class="container">
		<form:form action="registrarTelefono" method="post" modelAttribute="command">

			<div class="form-group">
				<fieldset>
					<div>
						<label for="nombres">Persona</label>
						<form:select path="persona.id" items="${personas}"
							itemLabel="nombresCompletos" itemValue="id" />
					</div>
					<div>
						<label for="numero">Número</label>
						<form:input path="numero" type="text" class="form-control"
							placeholder="Número" />
					</div>

					<div class="row">
						<div class="col-sm-1">
							<div>
								<input type="submit" class="btn btn-primary" value="Aceptar" />
							</div>

						</div>
						<div class="col-sm-1">
							<div>
								<a href="./personas.htm">Regresar</a>
							</div>
						</div>

					</div>

				</fieldset>
			</div>

		</form:form>

	</div>
</body>
</html>