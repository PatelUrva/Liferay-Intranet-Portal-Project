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

package com.aixtor.intranet.model.impl;

import com.aixtor.intranet.model.leave;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing leave in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class leaveCacheModel implements CacheModel<leave>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof leaveCacheModel)) {
			return false;
		}

		leaveCacheModel leaveCacheModel = (leaveCacheModel)object;

		if (leaveId == leaveCacheModel.leaveId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", leaveId=");
		sb.append(leaveId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", employeeName=");
		sb.append(employeeName);
		sb.append(", leaveType=");
		sb.append(leaveType);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", dayType=");
		sb.append(dayType);
		sb.append(", halfType=");
		sb.append(halfType);
		sb.append(", teamEmail=");
		sb.append(teamEmail);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public leave toEntityModel() {
		leaveImpl leaveImpl = new leaveImpl();

		if (uuid == null) {
			leaveImpl.setUuid("");
		}
		else {
			leaveImpl.setUuid(uuid);
		}

		leaveImpl.setLeaveId(leaveId);
		leaveImpl.setGroupId(groupId);
		leaveImpl.setCompanyId(companyId);
		leaveImpl.setUserId(userId);

		if (userName == null) {
			leaveImpl.setUserName("");
		}
		else {
			leaveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			leaveImpl.setCreateDate(null);
		}
		else {
			leaveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leaveImpl.setModifiedDate(null);
		}
		else {
			leaveImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (employeeName == null) {
			leaveImpl.setEmployeeName("");
		}
		else {
			leaveImpl.setEmployeeName(employeeName);
		}

		if (leaveType == null) {
			leaveImpl.setLeaveType("");
		}
		else {
			leaveImpl.setLeaveType(leaveType);
		}

		if (fromDate == null) {
			leaveImpl.setFromDate("");
		}
		else {
			leaveImpl.setFromDate(fromDate);
		}

		if (toDate == null) {
			leaveImpl.setToDate("");
		}
		else {
			leaveImpl.setToDate(toDate);
		}

		if (dayType == null) {
			leaveImpl.setDayType("");
		}
		else {
			leaveImpl.setDayType(dayType);
		}

		if (halfType == null) {
			leaveImpl.setHalfType("");
		}
		else {
			leaveImpl.setHalfType(halfType);
		}

		if (teamEmail == null) {
			leaveImpl.setTeamEmail("");
		}
		else {
			leaveImpl.setTeamEmail(teamEmail);
		}

		if (reason == null) {
			leaveImpl.setReason("");
		}
		else {
			leaveImpl.setReason(reason);
		}

		if (status == null) {
			leaveImpl.setStatus("");
		}
		else {
			leaveImpl.setStatus(status);
		}

		leaveImpl.resetOriginalValues();

		return leaveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		leaveId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		employeeName = objectInput.readUTF();
		leaveType = objectInput.readUTF();
		fromDate = objectInput.readUTF();
		toDate = objectInput.readUTF();
		dayType = objectInput.readUTF();
		halfType = objectInput.readUTF();
		teamEmail = objectInput.readUTF();
		reason = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(leaveId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (employeeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeName);
		}

		if (leaveType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaveType);
		}

		if (fromDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromDate);
		}

		if (toDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toDate);
		}

		if (dayType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dayType);
		}

		if (halfType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(halfType);
		}

		if (teamEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(teamEmail);
		}

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long leaveId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String employeeName;
	public String leaveType;
	public String fromDate;
	public String toDate;
	public String dayType;
	public String halfType;
	public String teamEmail;
	public String reason;
	public String status;

}