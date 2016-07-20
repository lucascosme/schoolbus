<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<form:form
	action="saveStudent?responsible=${responsible.id}&${_csrf.parameterName}=${_csrf.token}"
	method="post">
	<legend>Cadastro de responsavel</legend>
	<div class="row">
		<div class="col-lg-5">
			<div class="form-group">
				<label>Nome</label> <input type="text" class="form-control"
					name="name">
			</div>
		</div>
		<div class="col-lg-2">
			<div class="form-group">
				<label>CPF</label> <input type="text" class="form-control"
					name="responsibleName">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2">
			<div class="form-group">
				<label>Telefone Residencial</label> <input type="text"
					class="form-control" name="name">
			</div>
		</div>
		<div class="col-lg-3">
			<div class="form-group">
				<label>Telefone Celular</label> <input type="text"
					class="form-control" name="name">
			</div>
		</div>
		<div class="col-lg-2">
			<div class="form-group">
				<label>Telefone Recado</label> <input type="text"
					class="form-control" name="name">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-3">
			<div class="form-group">
				<label>Endereço</label> <input type="text"
					class="form-control" name="name">
			</div>
		</div>
		<div class="col-lg-2">
			<div class="form-group">
				<label>Bairro</label> <input type="text"
					class="form-control" name="name">
			</div>
		</div>
		<div class="col-lg-2">
			<div class="form-group">
				<label>Complemento</label> <input type="text"
					class="form-control" name="name">
			</div>
		</div>
	</div>

	<br />

	<div class="row">
		<div class="col-lg-2">
			<button type="submit"
				class="btn btn-outline btn-success btn-outline btn-block">Gravar</button>
		</div>
		<div class="col-lg-2">
			<button type="reset"
				class="btn btn-outline btn-danger btn-outline btn-block">Cancelar</button>
		</div>
	</div>
</form:form>

<c:import url="footer.jsp" />