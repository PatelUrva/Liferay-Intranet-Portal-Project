package com.aixtor.intranet.portlet;
import com.aixtor.intranet.model.leave;
import com.aixtor.intranet.service.leaveLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.List;

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
		"javax.portlet.display-name=View Leave Form",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewLeave.jsp",
		"javax.portlet.name=ViewLeave",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ViewLeavePortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(ViewLeavePortlet.class);
	
	@Reference
	leaveLocalService leaveLocalService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<leave> leaveList = leaveLocalService.getleaves(-1, -1);
		renderRequest.setAttribute("leaveList", leaveList);
		
		log.info(leaveList);
		
		super.render(renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "approveLeave")
	public void approveLeave(ActionRequest request, ActionResponse response) {
		
		long leaveId = ParamUtil.getLong(request, "leaveId",GetterUtil.DEFAULT_LONG);
		
		leave leaves = null;
		try {
			leaves = leaveLocalService.getleave(leaveId);
		} catch (PortalException e) {
			log.error(e.getCause(), e);
		}
		if(Validator.isNotNull(leaves)) {
			leaves.setStatus("Approved");
			leaveLocalService.updateleave(leaves);
			log.info("Data Updated");
		}
	}
	
	@ProcessAction(name = "rejectLeave")
	public void rejectLeave(ActionRequest request, ActionResponse response) {
		
		long leaveId = ParamUtil.getLong(request, "leaveId",GetterUtil.DEFAULT_LONG);
		
		leave leaves = null;
		try {
			leaves = leaveLocalService.getleave(leaveId);
		} catch (PortalException e) {
			log.error(e.getCause(), e);
		}
		if(Validator.isNotNull(leaves)) {
			leaves.setStatus("Rejected");
			leaveLocalService.updateleave(leaves);
			log.info("Data Updated");
		}
	}

}
