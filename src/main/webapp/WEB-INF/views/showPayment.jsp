<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form:form action="searchStudent?${_csrf.parameterName}=${_csrf.token}"
	method="post">
	<legend>Busca de aluno</legend>
	<div class="panel-body">
		<div class="row" align="center">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control"
						placeholder="Digite o nome do aluno que deseja buscar" name="name">
					<span class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</div>
		</div>

		<hr />
	
		<c:if test="${(listStudentsSize > 0)}">
		<h2>
			<small> Selecione a baixo o aluno referente ao pagamento.</small>
		</h2>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Escola</th>
						<th>Periodo</th>
						<th>Status</th>
					</tr>
				</thead>
				<c:forEach var="student" items="${listStudents}">
					<tbody>
						<tr
							onclick="window.document.location='/schoolbus/controller/user/newPaymentView?studentId=${student.id}&${_csrf.parameterName}=${_csrf.token}';"
							style="cursor: Pointer">
							<td>${student.name}</td>
							<td>${student.school.schoolName}</td>
							<td>${student.period}</td>
							<td>${student.status}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
		</c:if>
	</div>
</form:form>

<c:import url="footer.jsp" />