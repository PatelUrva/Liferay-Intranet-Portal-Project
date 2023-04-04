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

package com.aixtor.intranet.service.persistence;

import com.aixtor.intranet.exception.NoSuchLeaveTrackerException;
import com.aixtor.intranet.model.LeaveTracker;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTrackerUtil
 * @generated
 */
@ProviderType
public interface LeaveTrackerPersistence extends BasePersistence<LeaveTracker> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTrackerUtil} to access the leave tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the leave tracker where userId = &#63; or throws a <code>NoSuchLeaveTrackerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching leave tracker
	 * @throws NoSuchLeaveTrackerException if a matching leave tracker could not be found
	 */
	public LeaveTracker findByUserId(long userId)
		throws NoSuchLeaveTrackerException;

	/**
	 * Returns the leave tracker where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching leave tracker, or <code>null</code> if a matching leave tracker could not be found
	 */
	public LeaveTracker fetchByUserId(long userId);

	/**
	 * Returns the leave tracker where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave tracker, or <code>null</code> if a matching leave tracker could not be found
	 */
	public LeaveTracker fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the leave tracker where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the leave tracker that was removed
	 */
	public LeaveTracker removeByUserId(long userId)
		throws NoSuchLeaveTrackerException;

	/**
	 * Returns the number of leave trackers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching leave trackers
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the leave tracker in the entity cache if it is enabled.
	 *
	 * @param leaveTracker the leave tracker
	 */
	public void cacheResult(LeaveTracker leaveTracker);

	/**
	 * Caches the leave trackers in the entity cache if it is enabled.
	 *
	 * @param leaveTrackers the leave trackers
	 */
	public void cacheResult(java.util.List<LeaveTracker> leaveTrackers);

	/**
	 * Creates a new leave tracker with the primary key. Does not add the leave tracker to the database.
	 *
	 * @param leaveTrackerId the primary key for the new leave tracker
	 * @return the new leave tracker
	 */
	public LeaveTracker create(long leaveTrackerId);

	/**
	 * Removes the leave tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker that was removed
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	public LeaveTracker remove(long leaveTrackerId)
		throws NoSuchLeaveTrackerException;

	public LeaveTracker updateImpl(LeaveTracker leaveTracker);

	/**
	 * Returns the leave tracker with the primary key or throws a <code>NoSuchLeaveTrackerException</code> if it could not be found.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	public LeaveTracker findByPrimaryKey(long leaveTrackerId)
		throws NoSuchLeaveTrackerException;

	/**
	 * Returns the leave tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker, or <code>null</code> if a leave tracker with the primary key could not be found
	 */
	public LeaveTracker fetchByPrimaryKey(long leaveTrackerId);

	/**
	 * Returns all the leave trackers.
	 *
	 * @return the leave trackers
	 */
	public java.util.List<LeaveTracker> findAll();

	/**
	 * Returns a range of all the leave trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trackers
	 * @param end the upper bound of the range of leave trackers (not inclusive)
	 * @return the range of leave trackers
	 */
	public java.util.List<LeaveTracker> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trackers
	 * @param end the upper bound of the range of leave trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave trackers
	 */
	public java.util.List<LeaveTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTracker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trackers
	 * @param end the upper bound of the range of leave trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave trackers
	 */
	public java.util.List<LeaveTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTracker>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave trackers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave trackers.
	 *
	 * @return the number of leave trackers
	 */
	public int countAll();

}