package com.aixtor.intranet.portlet;

import com.aixtor.intranet.model.LeaveTracker;
import com.aixtor.intranet.service.LeaveTrackerLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Urva Patel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css?t=23423",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Employee Leave Section",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewEmployeeLeave.jsp",
		"javax.portlet.name=EmployeeLeavePortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeeLeavePortlet extends MVCPortlet {
	
	@Reference
	LeaveTrackerLocalService leaveTrackerLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay tDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LeaveTracker leaveTracker = leaveTrackerLocalService.findByUserId(tDisplay.getUserId());
		renderRequest.setAttribute("leaveTracker", leaveTracker);
		super.render(renderRequest, renderResponse);
	}
}