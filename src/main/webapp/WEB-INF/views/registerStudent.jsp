<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<c:if test="${not empty sucess}">
   	<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Sucesso!</strong> ${sucess}
	</div>
</c:if>	

<c:if test="${not empty warning}">
   	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Atenção!</strong> ${warning}
	</div>
</c:if>	

<c:if test="${not empty error}">
   	<div class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<strong>Erro!</strong> ${error}
	</div>
</c:if>

<form:form action="saveStudent?${_csrf.parameterName}=${_csrf.token}" method="post">
	<input type="text" name="name" />
	<input type="text" name="telephone" />
	<input type="text" name="responsibleName" />
	<input type="text" name="paymentValue" />
	<input type="date" name="paymentDate" />
	 <select class="form-control" name="period">
		<c:forEach var="period" items="${periods}">
			<option value="${period.description}">${period.description}</option>
		</c:forEach>
	</select>
	
	<select class="form-control" name="school">
		<c:forEach var="school" items="${listSchool}">
			<option value="${school.id}">${school.schoolName}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Salvar" />
</form:form>

<c:import url="footer.jsp" />