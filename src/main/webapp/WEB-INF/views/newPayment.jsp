<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:import url="header.jsp" />
<form>
         <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="glyphicon glyphicon-usd"></i> Pagamento
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Digite o nome do aluno que deseja buscar">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-5">
                                <h1><small>Valor: R$ 90,00</small></h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-5">
                                <h1><small>Vencimento: 12/10/2015</small></h1>
                            </div>
                        </div>

                        <br />

                            <div class="row">
                                <div class="col-lg-3">
                                    <button type="submit" class="btn btn-outline btn-success btn-outline btn-block">Efetuar Pagamento</button>
                                </div>
                                <div class="col-lg-2">
                                    <button type="submit" class="btn btn-outline btn-danger btn-outline btn-block">Cancelar</button>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

<c:import url="footer.jsp" />