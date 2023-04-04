<%@ include file="/init.jsp" %>

<portlet:renderURL var="addUserActionURL">
    <portlet:param name="mvcPath" value="/addUser.jsp" />
</portlet:renderURL>


<div class="mb-5">
    <a href="${addUserActionURL}" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"> Add Employee </i>
    </a>
</div>

<table class="table table-striped">
    <tr >
        <th>Employee Name</th>
        <th>Email Address</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Job Title</th>
        <th>Birth Date</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${usersList}" var="users">  
   
        <portlet:actionURL name="deleteUser" var="deleteUserURL">
            <portlet:param name="userId" value="${users.getUserId()}"/>
        </portlet:actionURL>
                
        <tr> 
            <td> ${users.getFullName()} </td>
            <td> ${users.getEmailAddress()} </td>
            <td> ${users.getFirstName()} </td>
            <td> ${users.getLastName()} </td>
            <td> ${users.getJobTitle()} </td>
            <td> ${users.getBirthday()} </td>
            <td class="text-center" style="width:50px">
                <a href="${deleteUserURL}" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to delete this employee?');"> 
                    Delete
                </a>
            </td>                          
         </tr>
    </c:forEach>
</table>