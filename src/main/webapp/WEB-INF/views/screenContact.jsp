<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />

<form:form action="demandContact?${_csrf.parameterName}=${_csrf.token}" method="post">
	<legend>Contatos</legend>
  	<div class="row">
  		<div class="col-md-6">
          <div class="input-group custom-search-form">
              <input type="text" class="form-control" placeholder="Digite o nome do contato que deseja buscar" name="contactName" />
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
              onclick="window.document.location='/schoolbus/controller/user/demandContactAll?${_csrf.parameterName}=${_csrf.token}';">
                  <i class="glyphicon glyphicon-th-list"></i> Listar Todos
              </button>
        </div>
  		</div>
  		<div class="col-lg-2 col-md-offset-2">
  		  <div class="input-group">
              <button class="btn btn-primary" type="button"
              onclick="window.document.location='/schoolbus/controller/user/saveContactView?${_csrf.parameterName}=${_csrf.token}';">
                  <i class="glyphicon glyphicon-plus-sign"></i> Novo Contato
              </button>
        </div>
  		</div>
  	</div>	
  	
  		<c:if test="${(listSize > 0 && empty listSizeSearch)}">
		    <div class="row">
		      <div class="col-md-6">
		      <h2>
		        <small>Lista de contatos</small>
		      </h2>
		      </div>
		    </div>
		    
		    <div class="table-responsive">
		      <table class="table table-striped">
		            <thead>
		                <tr>
		                    <th>Nome</th>
		                    <th>Site</th>
		                    <th>E-mail</th>
		                    <th>Telefone Fixo</th>
		                    <th>Telefone Celular</th>
		                    <th colspan="2"></th>
		                </tr>
		            </thead>
		           	<c:forEach var="contact" items="${listContacts}">
			            <tbody>
			                <tr>
			                	<c:set var="studentName" value="${contact.name}" />
		            			<c:set var="contactId" value="${contact.id}" />
			                  	<td>${contact.name}</td>
			                  	<td>${contact.site}</td>             
			                  	<td>${contact.email}</td>
			                  	<td>${contact.telephone}</td>
			                  	<td>${contact.celphone}</td>
			                  	<td><button type="button" class="btn btn-outline btn-default" title="Editar"><i class="fa fa-edit"></i></button></td>
			                  	<td><button type="button" class="btn btn-outline btn-default" data-toggle="modal" data-target="#myModal2"><i class="glyphicon glyphicon-trash"></i></button></td>
			                </tr>
			            </tbody>
		            </c:forEach>
		      </table>
		    </div>
		    
		    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog width" role="document">
			    <div class="modal-content new">
			      <div class="modal-header border-double">
			        <button type="button" class="close white" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h3 class="modal-title new" id="myModalLabel">Exclusão de Aluno</h3>
			      </div>
			      <div class="modal-body new	">
			        Tem certeza que deseja excluir ${contactName}?
			      </div>
			      <div class="modal-footer border-double">
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Cancelar</button>
			        <button type="button" class="btn btn-primary btn-lg" 
			        onclick="window.document.location='/schoolbus/controller/user/deleteContact?contactId=${contactId}&${_csrf.parameterName}=${_csrf.token}';">Excluir</button>
			      </div>
			    </div>
			    </div>
			</div>
		    
		</c:if>
	    
	    <c:if test="${listSizeSearch > 0}">
		    <div class="row">
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
		                    <th>Site</th>
		                    <th>E-mail</th>
		                    <th>Telefone Fixo</th>
		                    <th>Telefone Celular</th>
		                    <th colspan="2"></th>
		                </tr>
		            </thead>
		           	<c:forEach var="contact" items="${listContacts}">
			            <tbody>
			                <tr>
		            			<c:set var="studentName" value="${contact.name}" />
		            			<c:set var="contactId" value="${contact.id}" />
			                  	<td>${contact.name}</td>
			                  	<td>${contact.site}</td>             
			                  	<td>${contact.email}</td>
			                  	<td>${contact.telephone}</td>
			                  	<td>${contact.celphone}</td>
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
			        <h3 class="modal-title new" id="myModalLabel">Exclusão de Contato</h3>
			      </div>
			      <div class="modal-body new	">
			        Tem certeza que deseja excluir o contato ${studentName}?
			      </div>
			      <div class="modal-footer border-double">
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">Cancelar</button>
			        <button type="button" class="btn btn-primary btn-lg" 
			        onclick="window.document.location='/schoolbus/controller/user/deleteContact?contactId=${contactId}&${_csrf.parameterName}=${_csrf.token}';">Excluir</button>
			      </div>
			    </div>
			    </div>
			</div>
		</c:if>
</form:form>
<c:import url="footer.jsp" />