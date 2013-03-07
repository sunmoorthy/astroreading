<%@ include file="/pages/common/header.jsp" %>
<script>
	$(document).ready(function () {
		var request = $.ajax({
			url:'/astroreading/config/countries',
			type:'GET',
		}).done(function(response , status , jqXHR){
			$.each(response.countries , function(){
				$('#countrySelect').append("<option value='"+ $(this).attr('code') +"'>"+ $(this).attr('name') +"</option")
			})
		})
		
		$('.dateofbirthPicker').datepicker({
			      changeMonth: true,
			      changeYear: true
			    });
		$('.timeofbirthPicker').timepicker({
			showSecond: true,
		    timeFormat: 'hh:mm:ss'
		    });
		
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
				<input type="text" name="user.dateOfBirth" maxlength="50" class="dateofbirthPicker"/>
			</div>
			
			<div>
				<label>Time of Birth:(HH:MM:SS)</label>
				<input type="text" name="user.timeOfBirth" maxlength="50" class="timeofbirthPicker"/>
			</div>
			<div>
				<label>City of Birth</label>
				<input type="text" name="user.placeOfBirth" maxlength="50"/>
			</div>
			<div id="state">
				<label>State of Birth</label>
				<select name="user.stateOfBirth" id="stateSelect">
				</select>
			</div>
			<div id="country">
				<label>Country of Birth</label>
				<select name="user.countryOfBirth" id="countrySelect">
				</select>
			</div>
			<input type="submit" value="Register"/>
		</form>
	
</div>
<%@ include file="/pages/common/footer.jsp" %>
