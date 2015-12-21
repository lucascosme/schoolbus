<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Spring MVC Security - Login</title>
<link href="${pageContext.request.contextPath}/assets/css/style.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div id="login-form">
			<h3>Login</h3>
			<c:if test="${not empty errorMessage}">
				<div style="background-color:white; color: red; text-align: center;">
					<strong>${errorMessage}</strong>
				</div>
			</c:if>			
			<fieldset>
				<form name='loginForm' action="<c:url value='/login' />" method='POST'>
					<input id="username" name="username" type="text" value="Username" onBlur="if(this.value=='')this.value='Username'" onFocus="if(this.value=='Username')this.value='' "><!-- JS because of IE support; better: placeholder="Username" -->
					<input id="password" name="password" type="password" value="Password" onBlur="if(this.value=='')this.value='Password'" onFocus="if(this.value=='Password')this.value='' "><!-- JS because of IE support; better: placeholder="Password" -->
					<input id="login" type="submit" value="Login">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>