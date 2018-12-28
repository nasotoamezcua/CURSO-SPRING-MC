<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Logeo</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="login" class="active" id="login-form-link">Login</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="alert alert-success">${msg}</div>
							</c:if>
							<div class="col-lg-12">
								<form id="login-form" action="j_spring_security_check"
									method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="usuario" id="username" tabindex="1"
											class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="clave" id="password" tabindex="2"
											class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-primary"
													value="Login"> 
													<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>