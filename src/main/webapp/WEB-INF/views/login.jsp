<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>School Bus</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/assets/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/assets/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/assets/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link
	href="${pageContext.request.contextPath}/assets/css/style-auxiliar.css"
	rel="stylesheet" type="text/css">

</head>

<body>

	<form name='loginForm' action="<c:url value='/login' />" method='POST'>
		<div class="row block-header without-margin">
			<div id="date"></div>
  			<div id="clock"></div>
		</div>

		<div class="row without-margin">
			<div class="col-md-6 text-center">
				<img
					src="${pageContext.request.contextPath}/assets/img/logo-teste.png"
					width="400" height="276">
			</div>
			<div class="col-md-6 border-left">
				<div class="welle">

					<div class="row">
						<div class="col-md-12">
							<h2 class="wellcome">Seja bem-vindo !</h2>
							<p class="parag">Para prosseguir informe seu nome de usuário
								e senha.</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-10">
							<c:if test="${not empty errorMessage}">
							   	<div class="alert alert-danger alert-dismissible" role="alert">
									<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									${errorMessage}
								</div>
							</c:if>	
							<div class="form-group">
								<label>Usuário</label> <input class="form-control"
									name="username" type="text" autofocus>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-10">
							<div class="form-group">
								<label>Senha</label> <input class="form-control" name="password"
									type="password" value="">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-5">
							<input type="submit"
								class="btn btn-lg btn-primary btn-block button-login"
								value="Entrar" /><input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
						<div class="col-md-5">
							<input type="reset"
								class="btn btn-lg btn-primary btn-block button-login"
								value="Cancelar" /><input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="row block-footer without-margin">
			<p class="text-right margin">
				<small>Copyright 2016 by LC Solution</small>
			</p>
		</div>
	</form>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/assets/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/assets/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath}/assets/dist/js/sb-admin-2.js"></script>
	
	<!-- Clock -->
	<script type="text/javascript">
		document.getElementById('date').innerHTML = moment().format('DD-MM-YYYY');

		setInterval(function(){document.getElementById('clock').innerHTML = moment().format('h:mm:ss A');}, 1000);
	</script>
</body>

</html>
