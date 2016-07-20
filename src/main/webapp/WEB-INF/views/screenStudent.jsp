<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<script type="text/javascript">
	function nextPage() {
		var currentPage = $('#currentPage').val();
		$.ajax({
		    dataType : "json",
		    data : {currentPage: currentPage},
		    url : 'nextPage',
		    type: 'GET',
		    success : function(response) {   

		    	$('#studentsTable tbody').remove();
		        studentBeans = response.studentBeans;
		        paginator = response.paginator;
		        page = response.page;
		        numberOfPages = response.numberOfPages;
		        $.each(studentBeans,function(index) {
		        	studentId = studentBeans[index].id;
		        	name = studentBeans[index].name;
		        	status = studentBeans[index].status;
		        	
		            var htmlrow ="<tr>" + 
		            				"<td>" + name + "</td>"  + 
		            				"<td>"+ status +"</td>" + 
		            				"<td>" + 
		            					"<button type=\"button\" class=\"btn btn-outline btn-default\" data-toggle=\"modal\" data-target=\"#myModal2\" id=\"" + studentId + "\"><i class=\"glyphicon glyphicon-trash\"></i></button>" + 
		            				"</td>" + 
		            				"<td></td>" + 
		            			"</tr>";         
		            $('#studentsTable').append(htmlrow);
		        })
		        
		    },      
		    error : function(){
		        alert("error");
		    }
		});
	};
	
	window.onload = function(){
		$('#myModal2').on('show.bs.modal', function (e) {
			$(this).find('#studentName').html('Aluno ID: ' + e.relatedTarget.id);
		});
	}
</script>


<form:form action="demandStudent?${_csrf.parameterName}=${_csrf.token}"
	method="post">
	<legend>Alunos</legend>
	<div class="row">
		<div class="col-md-6">
			<div class="input-group custom-search-form">
				<input type="text" class="form-control"
					placeholder="Digite o nome do aluno que deseja buscar" name="name" />
				<span class="input-group-btn">
					<button class="btn btn-primary" type="submit">
						<i class="fa fa-search"></i> Pesquisar
					</button>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div class="input-group">
				<button class="btn btn-primary" type="button"
					onclick="window.document.location='/schoolbus/controller/user/demandStudentAll?${_csrf.parameterName}=${_csrf.token}';">
					<i class="glyphicon glyphicon-th-list"></i> Listar Todos
				</button>
			</div>
		</div>
		<div class="col-lg-2 col-md-offset-2">
			<div class="input-group">
				<button class="btn btn-primary" type="button"
					onclick="window.document.location='/schoolbus/controller/user/showresponsibleView?${_csrf.parameterName}=${_csrf.token}';">
					<i class="glyphicon glyphicon-plus-sign"></i> Novo Aluno
				</button>
			</div>
		</div>
	</div>
	<c:if test="${(listSize > 0 && empty listStudents)}">
	<div class="row">
		<div class="col-md-6">
			<h2>
				<small>Lista de alunos</small>
			</h2>
		</div>
	</div>

	<div class="table-responsive">
		<table class="table table-striped" id="studentsTable">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Pagamento</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<c:forEach var="student" items="${students}">
				<tbody>
					<tr>
						<td>${student.name}</td>
						<td>${student.status}</td>
						<td><button type="button" class="btn btn-outline btn-default"
								title="Editar">
								<i class="fa fa-edit"></i>
							</button></td>
						<td><button type="button" class="btn btn-outline btn-default"
								data-toggle="modal" data-target="#myModal2" id="${student.id}">
								<i class="glyphicon glyphicon-trash"></i>
							</button></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<c:set var="page" value="${page}" />
	
	<div class="row">
		<c:if test="${page == 0}">
			<div class="col-md-2">
				<button type="button" class="btn btn-primary disabled">
					<< Pagina Anterior</button>
			</div>
		</c:if>
		<c:if test="${page > 0}">
		<div class="col-md-2">
			<button class="btn btn-primary" type="button"
				onclick="window.document.location='/schoolbus/controller/user/previousPage?actualPage=${page}&${_csrf.parameterName}=${_csrf.token}';">
				<< Pagina Anterior</button>
		</div>
		</c:if>
		
		<input type="hidden" value="${page}" id="currentPage">
		<c:if test="${page+1 < numberOfPages}">
			<div class="col-md-2">
				<button class="btn btn-primary" type="button"
					onclick="nextPage(${page})">
					Proxima Pagina >></button>
			</div>
		</c:if>
		<c:if test="${page+1 == numberOfPages}">
			<div class="col-md-2">
				<button type="button" class="btn btn-primary disabled">
					Proxima Pagina >></button>
			</div>
		</c:if>
	</div>

	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog width" role="document">
			<div class="modal-content new">
				<div class="modal-header border-double">
					<button type="button" class="close white" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title new" id="myModalLabel">Exclusão de Aluno</h3>
				</div>
				<div id="studentName" class="modal-body new"></div>
				<div class="modal-footer border-double">
					<button type="button" class="btn btn-primary btn-lg"
						data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary btn-lg"
						onclick="window.document.location='/schoolbus/controller/user/deleteStudent?studentId=${studentId}&${_csrf.parameterName}=${_csrf.token}';">Excluir</button>
				</div>
			</div>
		</div>
	</div>

	</c:if>

	<%--  <c:if test="${listSizeSearch > 0}"> --%>
	<%--  <div class="row">
		      <div class="col-md-6">
		      <h2>
		        <small>Resultado da busca</small>
		      </h2>
		      </div>
		    </div>
		    
		    <div class="table-responsive">
		      <table class="table table-striped">
		            <thead>
		                <tr>
		                    <th>Nome</th>
		                    <th>Telefone Residencial</th>
		                    <th>Pagamento</th>
		                    <th colspan="2"></th>
		                </tr>
		            </thead>
		           	<c:forEach var="student" items="${listStudents}">
			            <tbody>
			                <tr>
		            			<c:set var="studentName" value="${student.name}" />
		            			<c:set var="studentId" value="${student.id}" />
			                  	<td>${student.name}</td>
			                  	<td>${student.homePhone}</td>             
			                  	<td>${student.status}</td>
			                  	<td><button type="button" class="btn btn-outline btn-default" title="Editar"><i class="fa fa-edit"></i></button></td>
			                  	<td><button type="button" class="btn btn-outline btn-default" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-trash"></i></button></td>
			                </tr>
			            </tbody>
		            </c:forEach>
		      </table>
		    </div>
		    
		     <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog width" role="document">
			    <div class="modal-content new">
			      <div class="modal-header border-double">
			        <button type="button" class="close white" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h3 class="modal-title new" id="myModalLabel">Exclusão de Aluno</h3>
			      </div>
			      <div class="modal-body new	">
			        Tem certeza que deseja excluir ${studentName}?
			      </div>
			      <div class="modal-footer border-double">
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Cancelar</button>
			        <button type="button" class="btn btn-primary btn-lg" 
			        onclick="window.document.location='/schoolbus/controller/user/deleteStudent?studentId=${studentId}&${_csrf.parameterName}=${_csrf.token}';">Excluir</button>
			      </div>
			    </div>
			    </div>
			</div> --%>
	<%-- </c:if> --%>
</form:form>
<c:import url="footer.jsp" />