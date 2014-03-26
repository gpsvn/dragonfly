<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style type="text/css">
.width-450{
	width: 450px;
}

.top-150{
	top:150px;
}

.left-400{
	left:400px;
}
#panel{
	border:1px solid #aaaaaa;
	border-radius:5px;
	position: fixed;
}

#loginContent{
	top:150px;
	left:400px;
	width:450px;
	padding:1.5em 0 0 8em;
	position: static;
	font-size: .8em;
}

#panel h3{
	padding: .5em 2em .5em 2em;
	position: relative;
	margin: 0px;
	text-align: center;
	font-size: 1em;
}
</style>
<head>
	<jsp:include page="layout/css-head.jsp" />
	<jsp:include page="layout/js-body.jsp" />
	<jsp:include page="layout/js-head.jsp" />
	
</head>
<script>

</script>
<body class="login">
    <div class="ui_block_element simple_page_element">
        <div id="panel" class="top-150 width-450 left-400">
        	<h3 class="ui-state-active ui-corner-top"> GPS</h3>
        	<div id="loginContent">
		        <form id="form-signin" class="form" action="<c:url value='/j_spring_security_check'/>" method="post">
		                <c:if test="${not empty param.error}">
		                    <div class="form-group">
		                        <label class="error nopopup"><spring:message code="login.wrong"/></label>
		                    </div>
		                </c:if>
		                <div class="form-group">
		                    <input type="text" id="j_username" name="j_username" class="form-control" maxlength="20" placeholder="<spring:message code="label.username"/>" autofocus>
		                </div>
		
		                <div class="form-group">
		                    <input type="password" id="j_password" name="j_password" class="form-control" placeholder="<spring:message code="label.password"/>">
		                </div>
		                <div >
			                <ul class="inline">
			                        <li>
			                            <label>
			                                <input type="checkbox" id="remember" name="_spring_security_remember_me" checked="checked">
			                                <spring:message code="label.remember"/>
			                            </label>
			                        </li>
			                        <li>
			                            <label>
			                                <a href="<c:url value='/resetpassword'/>"><spring:message code="label.forgot.password"/></a>
			                            </label>
			                        </li>
			                </ul>
		                </div>
		                <button type="submit" style="margin-left: 50px;"><spring:message code="label.btn.sign_in"/></button>
		                <div class="divider in_form"></div>
		        </form>
	        </div>
			<div style="font-weight: bold; color: #000000;">
				<ul class="simple_page_tab">
					<li><a href="<c:url value='/register'/>" class="register_tab"><spring:message
								code="label.btn.sign_up" /></a></li>
				</ul>
			</div>
		</div>
    </div>
</body>
