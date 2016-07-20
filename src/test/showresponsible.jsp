<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form:form action="searchResponsible?${_csrf.parameterName}=${_csrf.token}"
	method="post">
	<legend>Busca por responsavel</legend>
	<div class="panel-body">
		<div class="row" align="center">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control"
						placeholder="Digite o nome do responsavel que deseja buscar" name="name">
					<span class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</div>
		</div>

		<hr />
	
		<h2>
			<small> Selecione a baixo o responsavel pelo aluno.</small>
		</h2>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>CPF</th>
						<th>Telefone Residencial</th>
						<th>Telefone Celular</th>
					</tr>
				</thead>
				<c:forEach var="responsible" items="${listResponsibles}">
					<tbody>
						<tr
							onclick="window.document.location='/schoolbus/controller/user/registerStudentView?responsibleId=${responsible.id}&${_csrf.parameterName}=${_csrf.token}';"
							style="cursor: Pointer">
							<td>${responsible.name}</td>
							<td>${responsible.documentonumber}</td>
							<td>${responsible.homephone}</td>
							<td>${responsible.celphone}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</form:form>

<c:import url="footer.jsp" />