<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="addUser" var="addUserActionURL" />

<form action="${addUserActionURL}" name="userForm" method="POST">

	<div class="form-row">
		<div class="form-group col-md-6">
			<label>Email Address</label>
			<input type="text" required class="form-control"  name="<portlet:namespace/>emailAddress" />
		</div>
		
		<div class="form-group col-md-6">
			<label>Phone Number</label>
			<input type="number" required class="form-control" name="<portlet:namespace/>phoneNumber" />
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>First Name</label>
			<input type="text" required class="form-control" name="<portlet:namespace/>firstName" />
		</div>
		
		<div class="form-group col-md-6">
			<label>Last Name</label>
			<input type="text" required class="form-control" name="<portlet:namespace/>lastName" />
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>Job Title</label>
			<input type="text" required class="form-control" name="<portlet:namespace/>jobTitle" />
		</div>
		
		<div class="form-group col-md-6">
			<label>Birthday</label>
			<input type="date" required class="form-control" name="<portlet:namespace/>birthday" />
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>New Password</label>
			<input type="password" required class="form-control"  name="<portlet:namespace/>newPassword" />
		</div>
		
		<div class="form-group col-md-6">
			<label>Enter Password Again</label>
			<input type="password" required class="form-control" name="<portlet:namespace/>againPassword" />
		</div>
	</div>
	
	
	
	<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
</form>