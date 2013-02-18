<%@ include file="/pages/common/header.jsp" %>
<div class="left"></div>
<div class="right">
	<form method="post" action="/astroreading/user/register">
			<div>
				<label>First Name:</label>
				<input type="text" name="user.firstName" maxlength="50"/>
			</div>
			<div>
				<label>Last Name:</label>
				<input type="text" name="user.lastName" maxlength="50"/>
			</div>
			<div>
				<label>Email Address:</label>
				<input type="text" name="user.email" maxlength="50"/>
			</div>
			<div>
				<label>Password</label>
				<input type="password" name="user.password" maxlength="25"/>
			</div>
			<div>
				<label>Date of Birth:(MM/DD/YYYY)</label>
				<input type="password" name="user.dateOfBirth" maxlength="50"/>
			</div>
			<input type="submit" value="Register"/>
		</form>
	
</div>
<%@ include file="/pages/common/footer.jsp" %>
