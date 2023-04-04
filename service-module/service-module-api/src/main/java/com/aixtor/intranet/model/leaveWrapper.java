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

package com.aixtor.intranet.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link leave}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leave
 * @generated
 */
public class leaveWrapper
	extends BaseModelWrapper<leave> implements leave, ModelWrapper<leave> {

	public leaveWrapper(leave leave) {
		super(leave);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("leaveId", getLeaveId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeName", getEmployeeName());
		attributes.put("leaveType", getLeaveType());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("dayType", getDayType());
		attributes.put("halfType", getHalfType());
		attributes.put("teamEmail", getTeamEmail());
		attributes.put("reason", getReason());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long leaveId = (Long)attributes.get("leaveId");

		if (leaveId != null) {
			setLeaveId(leaveId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String employeeName = (String)attributes.get("employeeName");

		if (employeeName != null) {
			setEmployeeName(employeeName);
		}

		String leaveType = (String)attributes.get("leaveType");

		if (leaveType != null) {
			setLeaveType(leaveType);
		}

		String fromDate = (String)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		String toDate = (String)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String dayType = (String)attributes.get("dayType");

		if (dayType != null) {
			setDayType(dayType);
		}

		String halfType = (String)attributes.get("halfType");

		if (halfType != null) {
			setHalfType(halfType);
		}

		String teamEmail = (String)attributes.get("teamEmail");

		if (teamEmail != null) {
			setTeamEmail(teamEmail);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public leave cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this leave.
	 *
	 * @return the company ID of this leave
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave.
	 *
	 * @return the create date of this leave
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the day type of this leave.
	 *
	 * @return the day type of this leave
	 */
	@Override
	public String getDayType() {
		return model.getDayType();
	}

	/**
	 * Returns the employee name of this leave.
	 *
	 * @return the employee name of this leave
	 */
	@Override
	public String getEmployeeName() {
		return model.getEmployeeName();
	}

	/**
	 * Returns the from date of this leave.
	 *
	 * @return the from date of this leave
	 */
	@Override
	public String getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the group ID of this leave.
	 *
	 * @return the group ID of this leave
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the half type of this leave.
	 *
	 * @return the half type of this leave
	 */
	@Override
	public String getHalfType() {
		return model.getHalfType();
	}

	/**
	 * Returns the leave ID of this leave.
	 *
	 * @return the leave ID of this leave
	 */
	@Override
	public long getLeaveId() {
		return model.getLeaveId();
	}

	/**
	 * Returns the leave type of this leave.
	 *
	 * @return the leave type of this leave
	 */
	@Override
	public String getLeaveType() {
		return model.getLeaveType();
	}

	/**
	 * Returns the modified date of this leave.
	 *
	 * @return the modified date of this leave
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave.
	 *
	 * @return the primary key of this leave
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this leave.
	 *
	 * @return the reason of this leave
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the status of this leave.
	 *
	 * @return the status of this leave
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the team email of this leave.
	 *
	 * @return the team email of this leave
	 */
	@Override
	public String getTeamEmail() {
		return model.getTeamEmail();
	}

	/**
	 * Returns the to date of this leave.
	 *
	 * @return the to date of this leave
	 */
	@Override
	public String getToDate() {
		return model.getToDate();
	}

	/**
	 * Returns the user ID of this leave.
	 *
	 * @return the user ID of this leave
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this leave.
	 *
	 * @return the user name of this leave
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this leave.
	 *
	 * @return the user uuid of this leave
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this leave.
	 *
	 * @return the uuid of this leave
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this leave.
	 *
	 * @param companyId the company ID of this leave
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave.
	 *
	 * @param createDate the create date of this leave
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the day type of this leave.
	 *
	 * @param dayType the day type of this leave
	 */
	@Override
	public void setDayType(String dayType) {
		model.setDayType(dayType);
	}

	/**
	 * Sets the employee name of this leave.
	 *
	 * @param employeeName the employee name of this leave
	 */
	@Override
	public void setEmployeeName(String employeeName) {
		model.setEmployeeName(employeeName);
	}

	/**
	 * Sets the from date of this leave.
	 *
	 * @param fromDate the from date of this leave
	 */
	@Override
	public void setFromDate(String fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the group ID of this leave.
	 *
	 * @param groupId the group ID of this leave
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the half type of this leave.
	 *
	 * @param halfType the half type of this leave
	 */
	@Override
	public void setHalfType(String halfType) {
		model.setHalfType(halfType);
	}

	/**
	 * Sets the leave ID of this leave.
	 *
	 * @param leaveId the leave ID of this leave
	 */
	@Override
	public void setLeaveId(long leaveId) {
		model.setLeaveId(leaveId);
	}

	/**
	 * Sets the leave type of this leave.
	 *
	 * @param leaveType the leave type of this leave
	 */
	@Override
	public void setLeaveType(String leaveType) {
		model.setLeaveType(leaveType);
	}

	/**
	 * Sets the modified date of this leave.
	 *
	 * @param modifiedDate the modified date of this leave
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave.
	 *
	 * @param primaryKey the primary key of this leave
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this leave.
	 *
	 * @param reason the reason of this leave
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the status of this leave.
	 *
	 * @param status the status of this leave
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the team email of this leave.
	 *
	 * @param teamEmail the team email of this leave
	 */
	@Override
	public void setTeamEmail(String teamEmail) {
		model.setTeamEmail(teamEmail);
	}

	/**
	 * Sets the to date of this leave.
	 *
	 * @param toDate the to date of this leave
	 */
	@Override
	public void setToDate(String toDate) {
		model.setToDate(toDate);
	}

	/**
	 * Sets the user ID of this leave.
	 *
	 * @param userId the user ID of this leave
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this leave.
	 *
	 * @param userName the user name of this leave
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this leave.
	 *
	 * @param userUuid the user uuid of this leave
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this leave.
	 *
	 * @param uuid the uuid of this leave
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected leaveWrapper wrap(leave leave) {
		return new leaveWrapper(leave);
	}

}