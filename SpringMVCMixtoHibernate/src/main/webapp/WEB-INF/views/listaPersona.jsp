<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Personas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">	
	
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<!-- Para temas logout se tiene enviar los token csrf -->
			<!-- uando se utiliza el csrf se necesita cerrar la session por post  -->
			<form action="j_spring_security_logout" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h3>
					Bienvenido : ${pageContext.request.userPrincipal.name} | <a
						href="javascript:formSubmit()"> Cerrar Sesión</a>
				</h3>
			</c:if>


		</sec:authorize>
	
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr class="info">
						<th>ID</th>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th colspan="2">Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${personas}" var="persona">
						<tr class="active">
							<td><c:out value="${persona.id}" /></td>
							<td><c:out value="${persona.nombres}" /></td>
							<td><c:out value="${persona.apellidos}" /></td>
							<td><a href="irEditar?id=<c:out value="${persona.id }"/>">Actualizar</a></td>
							<td><a href="remover?id=<c:out value="${persona.id }"/>">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br />

		<div class="row">
			<div class="col-sm-1">
				<form method="get" action="irRegistrar">
					<button class="btn btn-primary">Agregar</button>
				</form>				
			</div>
			<div class="col-sm-1">
				<form method="get" action="irTelefono">
					<button class="btn btn-primary">Telefonos</button>
				</form>
			</div>

		</div>



	</div>
</body>
</html>