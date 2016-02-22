<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form:form action="balanceCalc?${_csrf.parameterName}=${_csrf.token}"
	method="post">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="glyphicon glyphicon-stats"></i> Balanço
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<h1>
								<small>Selecione um periodo que deseja fazer o balanço.</small>
							</h1>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-3">
							<label>Data Inicial</label> <input class="form-control"
								type="date" name="startDate" />
						</div>
						<div class="col-lg-3">
							<label>Data Final</label> <input class="form-control" type="date"
								name="endDate" />
						</div>
						<div class="col-lg-1">
							<button type="submit"
								class="btn btn-primary" style="margin-top: 24px;">Pesquisar</button>
						</div>
					</div>
					<br><br>
					<hr />
					<div class="row">
						<div class="col-lg-4">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th colspan="2"><i>RECEITA</i></th>
										</tr>
										<tr>
											<th>Data</th>
											<th>Valor</th>
											
										</tr>
									</thead>
									<c:forEach var="payment" items="${payments}">
										<tbody>
											<tr>
												<td>${payment.expirationDate}</td>
												<td>${payment.value}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th colspan="4"><i>DESPESA</i></th>
										</tr>
										<tr>
											<th>Data</th>
											<th>Motivo</th>
											<th>Status</th>
											<th>Valor</th>
											
										</tr>
									</thead>
									<c:forEach var="expense" items="${expenses}">
										<tbody>
											<tr>
												<td>${expense.dateExpense}</td>
												<td>${expense.expense}</td>
												<td>${expense.status}</td>
												<td>${expense.value}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>

<c:import url="footer.jsp" />