<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form:form action="saveNewPayment?paymentId=${payment.id}&${_csrf.parameterName}=${_csrf.token}" method="post">

	<legend>Despesas</legend>
	<div class="row">
		<div class="col-lg-7">
			<h2 style="margin-top: -10px;">
				<small>Selecione um periodo que deseja buscar as Despesas.</small>
			</h2>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-3">
			<label>Data Inicial</label> <input class="form-control" type="date"
				name="startDate" />
		</div>
		<div class="col-md-3">
			<label>Data Final</label> <input class="form-control" type="date"
				name="endDate" />
		</div>
		<div class="col-md-1">
			<button type="submit" class="btn btn-primary"
				style="margin-top: 24px;">
				<i class="fa fa-search"></i> Pesquisar
			</button>
		</div>
		<div class="col-md-2 col-md-offset-3" style="margin-top: 24px;">
			<button type="button" class="btn btn-primary">
				<i class="glyphicon glyphicon-plus-sign"></i> Nova Despesa
			</button>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-md-6">
			<h2>
				<small>Lista de despesas</small>
			</h2>
		</div>
	</div>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Motivo</th>
					<th>Data</th>
					<th>Valor</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>trinco da porta nova</td>
					<td>22/02/2016</td>
					<td>89.00</td>
					<td><button type="button" class="btn btn-outline btn-default"
							title="Editar">
							<i class="fa fa-edit"></i>
						</button></td>
					<td><button type="button" class="btn btn-outline btn-default"
							title="Excluir">
							<i class="glyphicon glyphicon-trash"></i>
						</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</form:form>

<c:import url="footer.jsp" />