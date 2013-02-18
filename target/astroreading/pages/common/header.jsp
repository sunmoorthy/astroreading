<%@ include file="/pages/common/include.jsp" %>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="/astroreading/css/default.css"></link>
</head>
<body>
	<div id="outerBody">
		<h2>Welcome to Astro Reading</h2>
			<div id="header">
				<div style="float:right;padding:10px 10px 10px 10px">
					<a href="/astroreading/user/register">Register</a>
					  <c:choose>
    						<c:when test="${sessionScope['SESSION_USER'] == null}">
								<a href="/astroreading/auth/login">Login</a>
							</c:when>
							<c:otherwise>
								Welcome, <c:out value="${sessionScope['SESSION_USER'].firstName}"/> <c:out value="${sessionScope['SESSION_USER'].lastName}"/>
							</c:otherwise>
						</c:choose>
				</div>
			</div>

	