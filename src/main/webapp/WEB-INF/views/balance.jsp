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
	<legend>Balanço</legend>
	<div class="panel-body">
		<div class="row">
			<div class="col-lg-7">
				<h2 style="margin-top: -10px;">
					<small>Selecione um periodo que deseja fazer o balanço.</small>
				</h2>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-3">
				<label>Data Inicial</label> <input class="form-control" type="date"
					name="startDate" />
			</div>
			<div class="col-lg-3">
				<label>Data Final</label> <input class="form-control" type="date"
					name="endDate" />
			</div>
			<div class="col-lg-1">
				<button type="submit" class="btn btn-primary"
					style="margin-top: 24px;">Pesquisar</button>
			</div>
		</div>
		
		<hr />
		
		<c:if test="${paymentSize > 0 or expenseSize > 0}">
			<div class="row">
				<div class="col-lg-6">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th colspan="3"><i>RECEITAS</i></th>
								</tr>
								<tr>
									<th>Aluno</th>
									<th>Valor</th>
									<th>Data</th>
	
								</tr>
							</thead>
							<tbody>
								<c:forEach var="payment" items="${payments}">
									<tr>
										<td>${payment.student.name}</td>
										<td>${payment.value}</td>
										<td>${payment.expirationDate}</td>
									</tr>
								</c:forEach>
								<tr>
									<td><b>TOTAL</b></td>
									<td colspan="2">${paymentSum}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th colspan="4"><i>DESPESAS</i></th>
								</tr>
								<tr>
									<th>Motivo</th>
									<th>Valor</th>
									<th>Status</th>
									<th>Data</th>
	
								</tr>
							</thead>
							<tbody>
								<c:forEach var="expense" items="${expenses}">
									<tr>
										<td>${expense.expense}</td>
										<td>${expense.value}</td>
										<td>${expense.status}</td>
										<td>${expense.dateExpense}</td>
									</tr>
								</c:forEach>
								<tr>
									<td><b>TOTAL</b></td>
									<td colspan="3">${expenseSum}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="col-lg-5">
					<h3>
						Saldo do periodo: <strong>R$ ${receivingLiquid}</strong>
					</h3>
				</div>
			</div>	
		</c:if>
 	</div>
</form:form>

<c:import url="footer.jsp" />