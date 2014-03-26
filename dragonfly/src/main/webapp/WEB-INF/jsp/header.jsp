<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div id="navigation">
	<div>
		<div class="logo">
			<a href="#">GPS Global</a>
		</div>
		<div class="menu">
			<ul class="inline">
				<li><a href="#">Bản đồ</a></li>
				<li><a href="#">Trực tuyến</a></li>
				<li><a href="#">Lịch sử</a></li>
				<li><a href="#">Báo cáo</a></li>
				<li><a href="#">Quản lý</a></li>
				<li><a href="#">Hỗ trợ</a></li>
				<li><a href="<c:url value='/j_spring_security_logout' />"><spring:message code="label.btn.sign_out"/></a></li>
			</ul>
		</div>
	</div>
</div>