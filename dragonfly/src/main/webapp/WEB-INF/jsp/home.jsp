<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<script type="text/javascript" src="/resources/js/jquery-1.11.0.js"></script>
<style type="text/css">
<!--
#map-container {
	width: 100%;
	height: 100%;
	background-color: #fff;
}

#left-body {
	top: 70px;
	position: absolute;
	width: 300px;
	height: auto;
	float: left;
	color: #000;
	background-color: #fff;
	font-family: Arial, sans-serif;
}

#right-body {
	position: absolute;
	color: #fff;
	float:right;
	left: 350px;
	top:60px;
	right: 5px;
	border:1px solid #aaaaaa;
	border-radius:5px;
}

#accordion{
	width: 270px;
	margin-left:10px;
	margin-top:10px;
}

#search{
	padding-top:1em;
	padding-right:1em;
	width:270px;
	margin-left:10px;
	border:1px solid #aaaaaa;
	border-radius:5px;
	color: #5E5E5E;
}
-->
</style>

<script type="text/javascript">
$(document).ready( function() {
	/* $("#carModel").click(function() {
	    var value = $(this).val();
	    trackingByCar(value);
	}); */
});

$(function() {
	$( "#accordion" ).accordion({
		collapsible: true
	});
});

</script>

<div id="map-container">
	<div id="left-body">
		<form>
		<div id="search">
			<ul style="list-style: none;">
				<li><label>Chọn thiết bị GPS để theo dõi</label></li>
				<li><label>Tìm kiếm</label> <input type="text"/></li>
			</ul>
		</div>
		<div id="accordion">
			<c:forEach var="itemGroup" items="${deviceMap}">
				<h3 style="font-weight: bold;">${itemGroup.key}</h3>
				<div>
					<c:forEach var="item" items="${itemGroup.value}"
						varStatus="itemIndex">
							<ul style="list-style: none;font-weight: bold;">
								<li>
									<a id="carModel" onclick="javascript:trackingByCar('${item.plateNumber}');" href="#">${item.plateNumber}-${item.sim}</a>
								</li>
							</ul>
						</c:forEach>
				</div>
			</c:forEach>
		</div>
		</form>
	</div>
	<div id="right-body">
		<div id="map-canvas" class="container-fluid container-full-screen">
		</div>
	</div>

</div>
