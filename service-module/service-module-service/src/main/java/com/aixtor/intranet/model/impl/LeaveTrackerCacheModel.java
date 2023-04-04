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

import com.aixtor.intranet.model.LeaveTracker;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaveTracker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LeaveTrackerCacheModel
	implements CacheModel<LeaveTracker>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LeaveTrackerCacheModel)) {
			return false;
		}

		LeaveTrackerCacheModel leaveTrackerCacheModel =
			(LeaveTrackerCacheModel)object;

		if (leaveTrackerId == leaveTrackerCacheModel.leaveTrackerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, leaveTrackerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{leaveTrackerId=");
		sb.append(leaveTrackerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", totalCompen=");
		sb.append(totalCompen);
		sb.append(", bookedCompen=");
		sb.append(bookedCompen);
		sb.append(", totalEarned=");
		sb.append(totalEarned);
		sb.append(", bookedEarned=");
		sb.append(bookedEarned);
		sb.append(", totalFloater=");
		sb.append(totalFloater);
		sb.append(", bookedFloater=");
		sb.append(bookedFloater);
		sb.append(", totalUnpaid=");
		sb.append(totalUnpaid);
		sb.append(", bookedUnpaid=");
		sb.append(bookedUnpaid);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaveTracker toEntityModel() {
		LeaveTrackerImpl leaveTrackerImpl = new LeaveTrackerImpl();

		leaveTrackerImpl.setLeaveTrackerId(leaveTrackerId);
		leaveTrackerImpl.setUserId(userId);
		leaveTrackerImpl.setTotalCompen(totalCompen);
		leaveTrackerImpl.setBookedCompen(bookedCompen);
		leaveTrackerImpl.setTotalEarned(totalEarned);
		leaveTrackerImpl.setBookedEarned(bookedEarned);
		leaveTrackerImpl.setTotalFloater(totalFloater);
		leaveTrackerImpl.setBookedFloater(bookedFloater);
		leaveTrackerImpl.setTotalUnpaid(totalUnpaid);
		leaveTrackerImpl.setBookedUnpaid(bookedUnpaid);

		if (createDate == Long.MIN_VALUE) {
			leaveTrackerImpl.setCreateDate(null);
		}
		else {
			leaveTrackerImpl.setCreateDate(new Date(createDate));
		}

		leaveTrackerImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			leaveTrackerImpl.setModifiedDate(null);
		}
		else {
			leaveTrackerImpl.setModifiedDate(new Date(modifiedDate));
		}

		leaveTrackerImpl.setModifiedBy(modifiedBy);
		leaveTrackerImpl.setGroupId(groupId);
		leaveTrackerImpl.setCompanyId(companyId);

		leaveTrackerImpl.resetOriginalValues();

		return leaveTrackerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		leaveTrackerId = objectInput.readLong();

		userId = objectInput.readLong();

		totalCompen = objectInput.readInt();

		bookedCompen = objectInput.readInt();

		totalEarned = objectInput.readInt();

		bookedEarned = objectInput.readInt();

		totalFloater = objectInput.readInt();

		bookedFloater = objectInput.readInt();

		totalUnpaid = objectInput.readInt();

		bookedUnpaid = objectInput.readInt();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(leaveTrackerId);

		objectOutput.writeLong(userId);

		objectOutput.writeInt(totalCompen);

		objectOutput.writeInt(bookedCompen);

		objectOutput.writeInt(totalEarned);

		objectOutput.writeInt(bookedEarned);

		objectOutput.writeInt(totalFloater);

		objectOutput.writeInt(bookedFloater);

		objectOutput.writeInt(totalUnpaid);

		objectOutput.writeInt(bookedUnpaid);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
	}

	public long leaveTrackerId;
	public long userId;
	public int totalCompen;
	public int bookedCompen;
	public int totalEarned;
	public int bookedEarned;
	public int totalFloater;
	public int bookedFloater;
	public int totalUnpaid;
	public int bookedUnpaid;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public long groupId;
	public long companyId;

}