<%@ include file="/pages/common/include.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="/astroreading/css/default.css"></link>
	<script type="text/javascript" src="/astroreading/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="/astroreading/js/jquery-ui-1.8.15.custom.min.js"></script>
	<script type="text/javascript" src="/astroreading/js/jquery-ui-timepicker-addon.js"></script>
</head>
<body>
	<div id="outerBody">
		<div id="title"><h2>Welcome to Astro Reading</h2></div>
			<div id="registerLink">
					  <c:choose>
    						<c:when test="${sessionScope['SESSION_USER'] == null}">
    							<a href="/astroreading/auth/register">Register</a>
								<a href="/astroreading/auth/login">Login</a>
							</c:when>
							<c:otherwise>
								Welcome, <c:out value="${sessionScope['SESSION_USER'].firstName}"/> <c:out value="${sessionScope['SESSION_USER'].lastName}"/>
								<a href="/astroreading/auth/logout">Logout</a>
							</c:otherwise>
						</c:choose>
			</div>
			<div id="header">
				<a href="">Horoscopes</a> | <a href="">Astrology</a> | <a href="">Contact Us</a> | <a href="">About Us</a>
			</div>
			

	