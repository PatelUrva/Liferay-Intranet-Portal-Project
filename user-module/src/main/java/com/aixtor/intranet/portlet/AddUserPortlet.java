package com.aixtor.intranet.portlet;

import com.aixtor.intranet.model.LeaveTracker;
import com.aixtor.intranet.service.LeaveTrackerLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Employee Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=AddUserPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AddUserPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(AddUserPortlet.class);

	@Reference
	UserLocalService userLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	@Reference
	LeaveTrackerLocalService leaveTrackerLocalService;
	
	@Reference
	RoleLocalService roleLocalService;
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<User> userList = userLocalService.getUsers(-1, -1);
		List<User> usersList = userLocalService.getRoleUsers(62106);
		renderRequest.setAttribute("usersList", usersList);
		super.render(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "addUser")
	public void addUser(ActionRequest request, ActionResponse response) {

		ThemeDisplay tDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = tDisplay.getUserId();

		// String userEmail = tDisplay.getUser().getEmailAddress();
		// String userName = tDisplay.getUser().getFullName();

		//long userId = counterLocalService.increment(AddUserPortlet.class.getName());
		long companyId = 20097;
		Locale locale = tDisplay.getLocale();

		String emailAddress = ParamUtil.getString(request, "emailAddress");
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String jobTitle = ParamUtil.getString(request, "jobTitle");
		String birthday = ParamUtil.getString(request, "birthday");
		int day = 1;
		int month = 0;
		int year = 1970;
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			//LocalDate currentDate = LocalDate.parse(birthday);
			day = date.getDate();
			year = date.getYear();
			month = date.getMonth();
		} catch (Exception e) {
			// TODO: handle exception
		}

		String password1 = ParamUtil.getString(request, "newPassword");
		String password2 = ParamUtil.getString(request, "againPassword");

		try {
			String roleName = "Intranet Developer";
			long roleId = RoleLocalServiceUtil.getRole(companyId, roleName).getRoleId();
			long groupId = GroupLocalServiceUtil.getGroup(companyId, "Employee").getGroupId();
			User addUser = userLocalService.addUser(tDisplay.getUserId(), companyId, false, password1, password2, true,
					null, emailAddress, locale, firstName, "", lastName, 0L, 
					0L, false, 0, 1, 1970, jobTitle, 
					new long[] {groupId}, null, new long[] {roleId}, null, false, new ServiceContext());
			log.info("Password " + addUser.getPasswordUnencrypted());
			if (Validator.isNotNull(addUser)) {
				addUser.setStatus(WorkflowConstants.STATUS_APPROVED);
				userLocalService.updateUser(addUser);
				
				LeaveTracker leaveTracker = leaveTrackerLocalService.findByUserId(addUser.getUserId());
				leaveTracker.setTotalCompen(5);
				leaveTracker.setTotalEarned(10);
				leaveTracker.setTotalFloater(2);
				leaveTracker.setTotalUnpaid(10);
				leaveTracker.setUserId(userId);
				leaveTracker.setCreateDate(new Date());
				leaveTracker.setModifiedDate(new Date());
				leaveTracker.setCreatedBy(userId);
				leaveTracker.setModifiedBy(userId);
				leaveTracker.setGroupId(groupId);
				leaveTracker.setCompanyId(companyId);
				
				leaveTrackerLocalService.updateLeaveTracker(leaveTracker);

			}
		} catch (Exception e) {
			log.error(e.getMessage() , e);
		}

		log.info("Data Added");
	}
	
	@ProcessAction(name = "deleteUser")
	public void deleteUser(ActionRequest request, ActionResponse response) {
		
		long userId = ParamUtil.getLong(request, "userId",GetterUtil.DEFAULT_LONG);
		try {
			userLocalService.deleteUser(userId);
			userLocalService.deleteRoleUser(62106, userId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}