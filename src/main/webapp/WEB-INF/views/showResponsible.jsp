<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form:form
	action="searchResponsible?${_csrf.parameterName}=${_csrf.token}"
	method="post">
	<legend>Busca de responsavel</legend>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-6">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control"
						placeholder="Digite o nome do responsavel pelo aluno." name="name" />
					<span class="input-group-btn">
						<button class="btn btn-primary" type="submit">
							<i class="fa fa-search"></i> Pesquisar
						</button>
					</span>
				</div>
			</div>
			<div class="col-lg-2 col-md-offset-4">
				<div class="input-group">
					<button class="btn btn-primary" type="button"
						onclick="window.document.location='/schoolbus/controller/user/registerResponsibleView?${_csrf.parameterName}=${_csrf.token}';">
						<i class="glyphicon glyphicon-plus-sign"></i> Novo Responsavel
					</button>
				</div>
			</div>
		</div>

		<hr />

		<c:if test="${(listResponsiblesSize > 0)}">
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
								<td>${responsible.documentNumber}</td>
								<td>${responsible.homePhone}</td>
								<td>${responsible.celPhone}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</div>
</form:form>

<c:import url="footer.jsp" />