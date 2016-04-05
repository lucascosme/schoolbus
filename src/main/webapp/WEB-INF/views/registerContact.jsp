<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<form:form action="saveContact?${_csrf.parameterName}=${_csrf.token}" method="post">
	<legend>Cadastro de contato</legend>
	<div class="row">
		<div class="col-lg-6">
				<div class="form-group">
					<label>Nome</label> 
					<input type="text" class="form-control" name="contactName">
				</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
				<div class="form-group">
					<label>Site</label> 
					<input type="text" class="form-control" name="site">
				</div>
		</div>
		<div class="col-lg-3">
			
				<div class="form-group">
					<label>E-mail</label> 
					<input type="text" class="form-control" name="email">
				</div>
			
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			
				<div class="form-group">
					<label>Telefone Fixo</label> 
					<input type="text" class="form-control" name="telephone">
				</div>
			
		</div>
		<div class="col-lg-3">
			
				<div class="form-group">
					<label>Telefone Celular</label> 
					<input type="text" class="form-control" name="celphone">
				</div>
			
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-lg-3">
				<div class="form-group">
					<label>Endereço</label> 
					<input type="text" class="form-control" name="address" placeholder="Rua, número">
				</div>
		</div>
		<div class="col-lg-3">
				<div class="form-group">
					<label>Bairro</label> 
					<input type="text" class="form-control" name="neighborhood">
				</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
				<div class="form-group">
					<label>Cidade</label> 
					<input type="text" class="form-control" name="city">
				</div>
		</div>
		<div class="col-lg-1">
				<div class="form-group">
					<label>Estado</label> 
					<input type="text" class="form-control" name="state">
				</div>
		</div>
	</div>
	
	<br />

	<div class="row">
		<div class="col-lg-1">
			<button type="submit" class="btn btn-outline btn-success btn-outline btn-block">Gravar</button>
		</div>
		<div class="col-lg-1">
			<button type="reset" class="btn btn-outline btn-danger btn-outline btn-block">Cancelar</button>
		</div>
	</div>
</form:form>

<c:import url="footer.jsp" />