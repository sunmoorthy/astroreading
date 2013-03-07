<%@ include file="/pages/common/include.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="/astroreading/css/default.css"></link>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
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
				<a href="/astroreading/auth/home">Horoscopes</a> | <a href="/astroreading/auth/home">Astrology</a> |  <a href="/astroreading/auth/aboutus">About Us</a> | <a href="/astroreading/auth/contactus">Contact Us</a>
			</div>
			

	