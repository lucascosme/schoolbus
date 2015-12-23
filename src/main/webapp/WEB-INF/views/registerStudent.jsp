<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form>
	<div class="row">
		<h1 class="page-header">
			<small> Cadastro de Aluno </small>
		</h1>
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Nome</label> <input class="form-control">
						</div>
					</form>
				</div>
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Nome do Responsavel</label> <input class="form-control">
						</div>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Telefone</label> <input class="form-control">
						</div>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3">
					<form role="form">
						<div class="form-group">
							<label>Escola</label> <select class="form-control" name="schools">
								<c:forEach var="school" items="${listSchool}">
									<option value="${school.id}">${school.schoolName}</option>
								</c:forEach>
							</select>
						</div>
					</form>
				</div>
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Periodo</label> <select class="form-control" name="period">
								<c:forEach var="period" items="${periods}">
									<option>${period.description}</option>
								</c:forEach>
							</select>
						</div>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Data de pagamento</label> <input class="form-control">
						</div>
					</form>
				</div>
				<div class="col-lg-2">
					<form role="form">
						<div class="form-group">
							<label>Valor</label> <input class="form-control">
						</div>
					</form>
				</div>
			</div>

			<br />

			<div class="row">
				<div class="col-lg-1">
					<button type="submit"
						class="btn btn-outline btn-success btn-outline btn-block">Gravar</button>
				</div>
				<div class="col-lg-1">
					<button type="submit"
						class="btn btn-outline btn-danger btn-outline btn-block">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
</form>

<c:import url="footer.jsp" />