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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LeaveTracker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTracker
 * @generated
 */
public class LeaveTrackerWrapper
	extends BaseModelWrapper<LeaveTracker>
	implements LeaveTracker, ModelWrapper<LeaveTracker> {

	public LeaveTrackerWrapper(LeaveTracker leaveTracker) {
		super(leaveTracker);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveTrackerId", getLeaveTrackerId());
		attributes.put("userId", getUserId());
		attributes.put("totalCompen", getTotalCompen());
		attributes.put("bookedCompen", getBookedCompen());
		attributes.put("totalEarned", getTotalEarned());
		attributes.put("bookedEarned", getBookedEarned());
		attributes.put("totalFloater", getTotalFloater());
		attributes.put("bookedFloater", getBookedFloater());
		attributes.put("totalUnpaid", getTotalUnpaid());
		attributes.put("bookedUnpaid", getBookedUnpaid());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveTrackerId = (Long)attributes.get("leaveTrackerId");

		if (leaveTrackerId != null) {
			setLeaveTrackerId(leaveTrackerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer totalCompen = (Integer)attributes.get("totalCompen");

		if (totalCompen != null) {
			setTotalCompen(totalCompen);
		}

		Integer bookedCompen = (Integer)attributes.get("bookedCompen");

		if (bookedCompen != null) {
			setBookedCompen(bookedCompen);
		}

		Integer totalEarned = (Integer)attributes.get("totalEarned");

		if (totalEarned != null) {
			setTotalEarned(totalEarned);
		}

		Integer bookedEarned = (Integer)attributes.get("bookedEarned");

		if (bookedEarned != null) {
			setBookedEarned(bookedEarned);
		}

		Integer totalFloater = (Integer)attributes.get("totalFloater");

		if (totalFloater != null) {
			setTotalFloater(totalFloater);
		}

		Integer bookedFloater = (Integer)attributes.get("bookedFloater");

		if (bookedFloater != null) {
			setBookedFloater(bookedFloater);
		}

		Integer totalUnpaid = (Integer)attributes.get("totalUnpaid");

		if (totalUnpaid != null) {
			setTotalUnpaid(totalUnpaid);
		}

		Integer bookedUnpaid = (Integer)attributes.get("bookedUnpaid");

		if (bookedUnpaid != null) {
			setBookedUnpaid(bookedUnpaid);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public LeaveTracker cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the booked compen of this leave tracker.
	 *
	 * @return the booked compen of this leave tracker
	 */
	@Override
	public int getBookedCompen() {
		return model.getBookedCompen();
	}

	/**
	 * Returns the booked earned of this leave tracker.
	 *
	 * @return the booked earned of this leave tracker
	 */
	@Override
	public int getBookedEarned() {
		return model.getBookedEarned();
	}

	/**
	 * Returns the booked floater of this leave tracker.
	 *
	 * @return the booked floater of this leave tracker
	 */
	@Override
	public int getBookedFloater() {
		return model.getBookedFloater();
	}

	/**
	 * Returns the booked unpaid of this leave tracker.
	 *
	 * @return the booked unpaid of this leave tracker
	 */
	@Override
	public int getBookedUnpaid() {
		return model.getBookedUnpaid();
	}

	/**
	 * Returns the company ID of this leave tracker.
	 *
	 * @return the company ID of this leave tracker
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this leave tracker.
	 *
	 * @return the create date of this leave tracker
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this leave tracker.
	 *
	 * @return the created by of this leave tracker
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the group ID of this leave tracker.
	 *
	 * @return the group ID of this leave tracker
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leave tracker ID of this leave tracker.
	 *
	 * @return the leave tracker ID of this leave tracker
	 */
	@Override
	public long getLeaveTrackerId() {
		return model.getLeaveTrackerId();
	}

	/**
	 * Returns the modified by of this leave tracker.
	 *
	 * @return the modified by of this leave tracker
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this leave tracker.
	 *
	 * @return the modified date of this leave tracker
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this leave tracker.
	 *
	 * @return the primary key of this leave tracker
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total compen of this leave tracker.
	 *
	 * @return the total compen of this leave tracker
	 */
	@Override
	public int getTotalCompen() {
		return model.getTotalCompen();
	}

	/**
	 * Returns the total earned of this leave tracker.
	 *
	 * @return the total earned of this leave tracker
	 */
	@Override
	public int getTotalEarned() {
		return model.getTotalEarned();
	}

	/**
	 * Returns the total floater of this leave tracker.
	 *
	 * @return the total floater of this leave tracker
	 */
	@Override
	public int getTotalFloater() {
		return model.getTotalFloater();
	}

	/**
	 * Returns the total unpaid of this leave tracker.
	 *
	 * @return the total unpaid of this leave tracker
	 */
	@Override
	public int getTotalUnpaid() {
		return model.getTotalUnpaid();
	}

	/**
	 * Returns the user ID of this leave tracker.
	 *
	 * @return the user ID of this leave tracker
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this leave tracker.
	 *
	 * @return the user uuid of this leave tracker
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the booked compen of this leave tracker.
	 *
	 * @param bookedCompen the booked compen of this leave tracker
	 */
	@Override
	public void setBookedCompen(int bookedCompen) {
		model.setBookedCompen(bookedCompen);
	}

	/**
	 * Sets the booked earned of this leave tracker.
	 *
	 * @param bookedEarned the booked earned of this leave tracker
	 */
	@Override
	public void setBookedEarned(int bookedEarned) {
		model.setBookedEarned(bookedEarned);
	}

	/**
	 * Sets the booked floater of this leave tracker.
	 *
	 * @param bookedFloater the booked floater of this leave tracker
	 */
	@Override
	public void setBookedFloater(int bookedFloater) {
		model.setBookedFloater(bookedFloater);
	}

	/**
	 * Sets the booked unpaid of this leave tracker.
	 *
	 * @param bookedUnpaid the booked unpaid of this leave tracker
	 */
	@Override
	public void setBookedUnpaid(int bookedUnpaid) {
		model.setBookedUnpaid(bookedUnpaid);
	}

	/**
	 * Sets the company ID of this leave tracker.
	 *
	 * @param companyId the company ID of this leave tracker
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this leave tracker.
	 *
	 * @param createDate the create date of this leave tracker
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this leave tracker.
	 *
	 * @param createdBy the created by of this leave tracker
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the group ID of this leave tracker.
	 *
	 * @param groupId the group ID of this leave tracker
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leave tracker ID of this leave tracker.
	 *
	 * @param leaveTrackerId the leave tracker ID of this leave tracker
	 */
	@Override
	public void setLeaveTrackerId(long leaveTrackerId) {
		model.setLeaveTrackerId(leaveTrackerId);
	}

	/**
	 * Sets the modified by of this leave tracker.
	 *
	 * @param modifiedBy the modified by of this leave tracker
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this leave tracker.
	 *
	 * @param modifiedDate the modified date of this leave tracker
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this leave tracker.
	 *
	 * @param primaryKey the primary key of this leave tracker
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total compen of this leave tracker.
	 *
	 * @param totalCompen the total compen of this leave tracker
	 */
	@Override
	public void setTotalCompen(int totalCompen) {
		model.setTotalCompen(totalCompen);
	}

	/**
	 * Sets the total earned of this leave tracker.
	 *
	 * @param totalEarned the total earned of this leave tracker
	 */
	@Override
	public void setTotalEarned(int totalEarned) {
		model.setTotalEarned(totalEarned);
	}

	/**
	 * Sets the total floater of this leave tracker.
	 *
	 * @param totalFloater the total floater of this leave tracker
	 */
	@Override
	public void setTotalFloater(int totalFloater) {
		model.setTotalFloater(totalFloater);
	}

	/**
	 * Sets the total unpaid of this leave tracker.
	 *
	 * @param totalUnpaid the total unpaid of this leave tracker
	 */
	@Override
	public void setTotalUnpaid(int totalUnpaid) {
		model.setTotalUnpaid(totalUnpaid);
	}

	/**
	 * Sets the user ID of this leave tracker.
	 *
	 * @param userId the user ID of this leave tracker
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this leave tracker.
	 *
	 * @param userUuid the user uuid of this leave tracker
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LeaveTrackerWrapper wrap(LeaveTracker leaveTracker) {
		return new LeaveTrackerWrapper(leaveTracker);
	}

}