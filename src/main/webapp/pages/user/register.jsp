<%@ include file="/pages/common/header.jsp" %>
<script>
	$(document).ready(function () {
		var request = $.ajax({
			url:'/astroreading/config/countries',
			type:'GET',
		}).done(function(response , status , jqXHR){
			alert(response)
		})
		
	})
</script>
<!-- <div class="left"></div> -->
<div class="main">
	<form method="post" action="/astroreading/auth/register">
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
			<div id="country">
				<select name="countries">
					
				</select>
			</div>
			<div id="country">
				<select name="states">
				</select>
			</div>
			
			<input type="submit" value="Register"/>
		</form>
	
</div>
<%@ include file="/pages/common/footer.jsp" %>
