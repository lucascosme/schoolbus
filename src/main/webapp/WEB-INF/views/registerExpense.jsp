<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<c:if test="${not empty sucess}">
	<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Sucesso!</strong> ${sucess}
	</div>
</c:if>

<c:if test="${not empty warning}">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Atenção!</strong> ${warning}
	</div>
</c:if>

<c:if test="${not empty error}">
	<div class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Erro!</strong> ${error}
	</div>
</c:if>

<form:form action="saveExpense?${_csrf.parameterName}=${_csrf.token}"
	method="post">

	<legend>Cadastro de despesa</legend>
	<div class="row">
		<div class="col-lg-7">
			<div class="form-group">
				<label>Despesa</label> <input type="text" class="form-control"
					name="expenseName">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			<div class="form-group">
				<label>Valor</label> <input type="text" class="form-control"
					name="value">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-4">
			<div class="form-group">
				<label>Data da despesa</label> <input type="date"
					class="form-control" name="dateExpense">
			</div>
		</div>
	</div>

	<br />

	<div class="row">
		<div class="col-lg-1">
			<input type="submit"
				class="btn btn-outline btn-success btn-outline btn-block"
				value="Gravar" />
		</div>
		<div class="col-lg-1">
			<input type="reset"
				class="btn btn-outline btn-danger btn-outline btn-block"
				value="Cancelar" />
		</div>
	</div>

</form:form>

<c:import url="footer.jsp" />