/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.aixtor.intranet.service.impl;

import com.aixtor.intranet.exception.NoSuchLeaveTrackerException;
import com.aixtor.intranet.model.LeaveTracker;
import com.aixtor.intranet.service.base.LeaveTrackerLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aixtor.intranet.model.LeaveTracker",
	service = AopService.class
)
public class LeaveTrackerLocalServiceImpl
	extends LeaveTrackerLocalServiceBaseImpl {
	
	public LeaveTracker findByUserId(long userId) {
		try {
			return leaveTrackerPersistence.findByUserId(userId);
		} catch (NoSuchLeaveTrackerException e) {
		}
		return createLeaveTracker(-1);
	}
}