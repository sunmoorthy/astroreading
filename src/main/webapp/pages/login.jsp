<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="/pages/common/header.jsp"></s:include>
<div class="left"></div>
<div class="right">
	<form method="post" action="/astroreading/login">
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
<s:include value="/pages/common/footer.jsp"></s:include>

