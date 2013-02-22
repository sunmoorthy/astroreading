<%@ include file="/pages/common/header.jsp" %>
<div class="main">
	<div class="loginLeft">
		
	</div>
	<div class="loginRight">
		<form method="post" action="/astroreading/auth/login">
			<div>
				<label>UserName:(Registered Email address)</label>
				<input type="text" name="email"/>
			</div>
			<div>
				<label>Password:</label>
				<input type="password" name="password"/>
			</div>
			<input type="submit" value="Login"/>
		</form>
	</div>
</div>
<%@ include file="/pages/common/footer.jsp" %>

