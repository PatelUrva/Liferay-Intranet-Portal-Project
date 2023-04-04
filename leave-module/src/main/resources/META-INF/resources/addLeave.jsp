<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<html>
	<head>
		<link href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="Stylesheet"
		    type="text/css" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	</head>
	<body>
		<portlet:actionURL name="addLeave" var="addLeaveActionURL" />

		<form action="${addLeaveActionURL}" name="leaveForm" method="POST">
		
			<div class="form-group">
				<label>Employee Name</label>
				<input type="text" required class="form-control"  name="<portlet:namespace/>employeeName" placeholder="Enter employee name"/>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-4">
					<label>Leave Type</label>
					<select class="form-control" name="<portlet:namespace/>leaveType" required>
						<option value="Compensatory Off"> Compensatory Off </option>
						<option value="Earned Leave"> Earned Leave </option>
						<option value="Floater Holiday"> Floater Holiday </option>
						<option value="Unpaid Leave"> Unpaid Leave </option>
					</select>
				</div>
				
				<div class="form-group col-md-4">
					<label>From Date</label>
					<input type="text" required class="form-control" id="<portlet:namespace/>fromDate" name="<portlet:namespace/>fromDate" placeholder="Select date"/>
				</div>
				
				<div class="form-group col-md-4">
					<label>To Date</label>
					<input type="text" required class="form-control" id="<portlet:namespace/>toDate" name="<portlet:namespace/>toDate" placeholder="Select date"/>
				</div>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-6">
					<select class="form-control" id="<portlet:namespace/>dayType" required name="<portlet:namespace/>dayType">
						<option value="Half Day"> Half Day </option>
						<option value="Full Day"> Full Day </option>
					</select>
				</div>
			
				
				<div class="form-group col-md-6">
					<select class="form-control" name="<portlet:namespace/>halfType" required id="<portlet:namespace/>halfType">
						<option value="1st Half"> 1st Half </option>
						<option value="2nd Half"> 2nd Half </option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label>Team Email ID</label>
				<input type="text" class="form-control" required name="<portlet:namespace/>teamEmail" placeholder="Enter team email"/>
			</div>
			
			<div class="form-group">
				<label>Reason</label>
				<input type="text" class="form-control" required name="<portlet:namespace/>reason" placeholder="Enter reason"/>
			</div>
			
			<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
		</form>
	</body>
</html>

<script type="text/javascript">
$(document).ready(function () {
	var namespace  = '<portlet:namespace />';
	
	$('#' + namespace + 'fromDate').datepicker({
		minDate: 0
	});
	$('#' + namespace + 'toDate').datepicker({
		minDate: 0
	});
	
	init = function(){
		$('#' + namespace + 'dayType').on('change', function(){
			console.log(this);
			var selectedDayType = $(this).val();
			if('Full Day' == selectedDayType){
				$('#' + namespace + 'halfType').attr('disabled', true);
			}else{
				$('#' + namespace + 'halfType').attr('disabled', false);
			}
		});
	};
	
	init();
	
});
</script>

