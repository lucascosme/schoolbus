<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<form:form action="saveStudent?responsible=${responsible.id}&${_csrf.parameterName}=${_csrf.token}" method="post">
	<legend>Cadastro de aluno</legend>
	<div class="row">
		<div class="col-lg-4">
			
				<div class="form-group">
					<label>Nome</label> 
					<input type="text" class="form-control" name="name">
				</div>
			
		</div>
		<div class="col-lg-4">
			
				<div class="form-group">
					<label>Nome do Responsavel</label> 
					<input type="text" class="form-control" name="responsibleName" value="${responsible.name}" disabled>
					<c:set var="responsible" value="${responsible}" />
				</div>
			
		</div>
	</div>

	<hr />
	<div class="row">
		<div class="col-lg-3">
			
				<div class="form-group">
					<label>Escola</label> 
					<select class="form-control" name="school">
						<c:forEach var="school" items="${listSchool}">
							<option value="${school.id}">${school.schoolName}</option>
						</c:forEach>
					</select>
				</div>
			
		</div>
		<div class="col-lg-2">
			
				<div class="form-group">
					<label>Periodo</label>
					<select class="form-control" name="period">
						<c:forEach var="period" items="${periods}">
							<option value="${period.description}">${period.description}</option>
						</c:forEach>
					</select>
				</div>
			
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-lg-2">
			
				<div class="form-group">
					<label>Data de pagamento</label> 
					<input type="date" class="form-control" name="paymentDate">
				</div>
			
		</div>
		<div class="col-lg-2">
			
				<div class="form-group">
					<label>Valor</label> 
					<input type="text" class="form-control" name="paymentValue">
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