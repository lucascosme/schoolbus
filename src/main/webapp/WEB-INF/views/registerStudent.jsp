<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<c:if test="${not empty sucess}">
   	<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Sucesso!</strong> ${sucess}
	</div>
</c:if>	

<c:if test="${not empty warning}">
   	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Atenção!</strong> ${warning}
	</div>
</c:if>	

<c:if test="${not empty error}">
   	<div class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Erro!</strong> ${error}
	</div>
</c:if>

<form:form action="saveStudent?${_csrf.parameterName}=${_csrf.token}" method="post">
	<div class="row">
		<h1 class="page-header">
			<small> Cadastro de Aluno </small>
		</h1>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Nome</label> <input class="form-control" name="name" id="name">
						</div>
					</form>
				</div>
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Nome do Responsavel</label> <input type="text" name="respName" id="respName" />
						</div>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Telefone</label> <input class="form-control" name="telephone">
						</div>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Escola</label> <select class="form-control" name="schools">
								<c:forEach var="school" items="${listSchool}">
									<option value="${school.id}">${school.schoolName}</option>
								</c:forEach>
							</select>
						</div>
					</form>
				</div>
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Periodo</label> <select class="form-control" name="period">
								<c:forEach var="period" items="${periods}">
									<option value="${period.description}">${period.description}</option>
								</c:forEach>
							</select>
						</div>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Data de pagamento</label> <input class="form-control" type="date" name="paymentDate">
						</div>
					</form>
				</div>
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Valor</label> <input class="form-control" name="valuePayment">
						</div>
					</form>
				</div>
			</div>

			<br />

			<div class="row">
				<div class="col-lg-6">
					<button type="submit" class="btn btn-outline btn-success">Gravar</button>
					<button type="submit" class="btn btn-outline btn-danger">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
</form:form>

<c:import url="footer.jsp" />