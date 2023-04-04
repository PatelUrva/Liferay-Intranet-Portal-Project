<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="init.jsp"%>
<table class="table table-striped">
    <tr >
        <th>Employee Name</th>
        <th>Leave Type</th>
        <th>From Date</th>
        <th>To Date</th>
        <th>Half Day / Full Day</th>
        <th>1st / 2nd Half</th>
        <th>Team Email</th>
        <th>Reason</th>
        <th>Status</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>
    <c:forEach items="${leaveList}" var="leave">  
    
        <portlet:actionURL name="approveLeave" var="approveLeaveURL">
            <portlet:param name="leaveId" value="${leave.getLeaveId()}"/>
        </portlet:actionURL>
        
        <portlet:actionURL name="rejectLeave" var="rejectLeaveURL">
            <portlet:param name="leaveId" value="${leave.getLeaveId()}"/>
        </portlet:actionURL>
                
        <tr> 
            <td>${leave.getEmployeeName()}</td>
            <td>${leave.getLeaveType()}</td>
            <td>${leave.getFromDate()}</td>
            <td>${leave.getToDate()}</td>
            <td>${leave.getDayType()}</td>
            <td>${leave.getHalfType()}</td>
            <td>${leave.getTeamEmail()}</td>
            <td>${leave.getReason()}</td>
            <td>${leave.getStatus()}</td>
            
            <td class="text-center" style="width:50px">
                <a href="${approveLeaveURL}" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to approve this leave?');"> 
                    Approve
                </a>
            </td>  
            <td class="text-center" style="width:50px">
                <a href="${rejectLeaveURL}" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to reject this leave?');"> 
                    Reject
                </a>
            </td>                                     
         </tr>
    </c:forEach>
</table>
