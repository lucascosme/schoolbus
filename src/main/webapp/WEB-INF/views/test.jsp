<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />
<form:form action="teststudent?${_csrf.parameterName}=${_csrf.token}" method="POST">
         <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="glyphicon glyphicon-usd"></i> Test
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Digite o nome do aluno que deseja buscar">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>

<c:import url="footer.jsp" />