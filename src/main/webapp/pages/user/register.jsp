<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(document).ready(function () {
		var request = $.ajax({
			url:'/astroreading/config/countries',
			type:'GET',
		}).done(function(response , status , jqXHR){
			$.each(response.countries , function(){
				if($(this).attr('code')=='US') {
					$('#countrySelect').append("<option value='"+ $(this).attr('code') +"'selected>"+ $(this).attr('name') +"</option")
					
				}else{
					$('#countrySelect').append("<option value='"+ $(this).attr('code') +"'>"+ $(this).attr('name') +"</option")
				}
			})
			
			if(response) {
				$.states("US");
			}
			// Get Countries by country code
		})
		$('.dateofbirthPicker').datepicker({
			      changeMonth: true,
			      changeYear: true
			    });
		$('.timeofbirthPicker').timepicker({
			showSecond: true,
		    timeFormat: 'hh:mm:ss'
		    });
		
		$('#countrySelect').change(function() {
			$.states($(this).val());
		})
	})

$.states = function(countryCode) {
		var request = $.ajax({
			url:'/astroreading/config/states?countryCode='+countryCode,
			type:'GET',
		}).done(function(response , status , jqXHR){
			if(!response.states || response.states.length <=0){
				$('#stateSelect').hide();
				$('#stateInput').show();
				
			}else{
				$('#stateSelect').attr('style','diplay:inline');
				$.each(response.states , function(){
					$('#stateSelect').append("<option value='"+ $(this).attr('code') +"'>"+ $(this).attr('name') +"</option")
				})
				$('#stateInput').hide();
			}
		})
	
}

	
</script>
<!-- <div class="left"></div> -->
<div class="main">
	<div class="innerBox">
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
					<input type="text" name="user.cityOfBirth" maxlength="50"/>
				</div>
				<div id="state">
					<label>State of Birth</label>
					<select name="user.stateOfBirth" id="stateSelect" style="display:none">
					</select>
					<input type="text" name="user.stateOfBirth" id="stateInput" style="display:none"/>
				</div>
				<div id="country">
					<label>Country of Birth</label>
					<select name="user.countryOfBirth" id="countrySelect">
					</select>
				</div>
				<input type="submit" value="Register"/>
			</form>
		</div>
</div>
<%@ include file="/pages/common/footer.jsp" %>
