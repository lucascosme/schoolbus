<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />
<form:form>
	<legend>Arquivos</legend>
	<div class="row">
		<div class="col-lg-2" style="text-align: center">
			<div class="well well-lg">
				<figure class="figure">
					<a href="${pageContext.request.contextPath}/files/pdf/contrato.pdf">
						<img
						src="${pageContext.request.contextPath}/files/images/icone_arquivo.jpeg"
						class="figure-img img-fluid img-rounded" alt="Contrato" />
					</a>
					<figcaption>Contrato.pdf</figcaption>
				</figure>
			</div>
		</div>
	</div>


</form:form>

<c:import url="footer.jsp" />