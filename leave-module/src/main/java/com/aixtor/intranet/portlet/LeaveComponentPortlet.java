package com.aixtor.intranet.portlet;

import com.aixtor.intranet.constants.LeaveComponentPortletKeys;
import com.aixtor.intranet.model.leave;
import com.aixtor.intranet.service.leaveLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Urva Patel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Leave Form",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/addLeave.jsp",
		"javax.portlet.name=" + LeaveComponentPortletKeys.LEAVECOMPONENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LeaveComponentPortlet extends MVCPortlet {
	
	
	private static Log log = LogFactoryUtil.getLog(LeaveComponentPortlet.class);
	
	@Reference
	CounterLocalService counterLocalService;
	
	@Reference
	UserLocalService userLocalService;
	
	@Reference
	leaveLocalService leaveLocalService;
	
	@ProcessAction(name = "addLeave")
	public void addLeave(ActionRequest request, ActionResponse response) {
		
		ThemeDisplay tDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = tDisplay.getUserId();
		String userEmail = tDisplay.getUser().getEmailAddress(); 
		String userName = tDisplay.getUser().getFullName();
		
		long leaveId = counterLocalService.increment(LeaveComponentPortlet.class.getName());
		String employeeName = ParamUtil.getString(request, "employeeName");
		String leaveType = ParamUtil.getString(request, "leaveType");
		String fromDate = ParamUtil.getString(request, "fromDate");
		String toDate = ParamUtil.getString(request, "toDate");
		String dayType = ParamUtil.getString(request, "dayType");
		String halfType = ParamUtil.getString(request, "halfType");
		String teamEmail = ParamUtil.getString(request, "teamEmail");
		String reason = ParamUtil.getString(request, "reason");
		
		leave leaves = leaveLocalService.createleave(leaveId);
		
		leaves.setLeaveId(leaveId);
		leaves.setEmployeeName(employeeName);
		leaves.setLeaveType(leaveType);
		leaves.setFromDate(fromDate);
		leaves.setToDate(toDate);
		leaves.setDayType(dayType);
		leaves.setHalfType(halfType);
		leaves.setTeamEmail(teamEmail);
		leaves.setReason(reason);
		leaves.setStatus("Pending");
		leaves.setUserId(userId);
		leaves.setUserName(userName);
		
		leaveLocalService.addleave(leaves);
		
		log.info("Data Added");
		log.info(userEmail);
		log.info(userName);
	}
	
	
}