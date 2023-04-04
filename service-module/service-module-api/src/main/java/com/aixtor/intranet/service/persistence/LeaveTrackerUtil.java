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

import com.aixtor.intranet.model.LeaveTracker;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave tracker service. This utility wraps <code>com.aixtor.intranet.service.persistence.impl.LeaveTrackerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTrackerPersistence
 * @generated
 */
public class LeaveTrackerUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LeaveTracker leaveTracker) {
		getPersistence().clearCache(leaveTracker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, LeaveTracker> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveTracker> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveTracker update(LeaveTracker leaveTracker) {
		return getPersistence().update(leaveTracker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveTracker update(
		LeaveTracker leaveTracker, ServiceContext serviceContext) {

		return getPersistence().update(leaveTracker, serviceContext);
	}

	/**
	 * Returns the leave tracker where userId = &#63; or throws a <code>NoSuchLeaveTrackerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching leave tracker
	 * @throws NoSuchLeaveTrackerException if a matching leave tracker could not be found
	 */
	public static LeaveTracker findByUserId(long userId)
		throws com.aixtor.intranet.exception.NoSuchLeaveTrackerException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the leave tracker where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching leave tracker, or <code>null</code> if a matching leave tracker could not be found
	 */
	public static LeaveTracker fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the leave tracker where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave tracker, or <code>null</code> if a matching leave tracker could not be found
	 */
	public static LeaveTracker fetchByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the leave tracker where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the leave tracker that was removed
	 */
	public static LeaveTracker removeByUserId(long userId)
		throws com.aixtor.intranet.exception.NoSuchLeaveTrackerException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of leave trackers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching leave trackers
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the leave tracker in the entity cache if it is enabled.
	 *
	 * @param leaveTracker the leave tracker
	 */
	public static void cacheResult(LeaveTracker leaveTracker) {
		getPersistence().cacheResult(leaveTracker);
	}

	/**
	 * Caches the leave trackers in the entity cache if it is enabled.
	 *
	 * @param leaveTrackers the leave trackers
	 */
	public static void cacheResult(List<LeaveTracker> leaveTrackers) {
		getPersistence().cacheResult(leaveTrackers);
	}

	/**
	 * Creates a new leave tracker with the primary key. Does not add the leave tracker to the database.
	 *
	 * @param leaveTrackerId the primary key for the new leave tracker
	 * @return the new leave tracker
	 */
	public static LeaveTracker create(long leaveTrackerId) {
		return getPersistence().create(leaveTrackerId);
	}

	/**
	 * Removes the leave tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker that was removed
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	public static LeaveTracker remove(long leaveTrackerId)
		throws com.aixtor.intranet.exception.NoSuchLeaveTrackerException {

		return getPersistence().remove(leaveTrackerId);
	}

	public static LeaveTracker updateImpl(LeaveTracker leaveTracker) {
		return getPersistence().updateImpl(leaveTracker);
	}

	/**
	 * Returns the leave tracker with the primary key or throws a <code>NoSuchLeaveTrackerException</code> if it could not be found.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	public static LeaveTracker findByPrimaryKey(long leaveTrackerId)
		throws com.aixtor.intranet.exception.NoSuchLeaveTrackerException {

		return getPersistence().findByPrimaryKey(leaveTrackerId);
	}

	/**
	 * Returns the leave tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker, or <code>null</code> if a leave tracker with the primary key could not be found
	 */
	public static LeaveTracker fetchByPrimaryKey(long leaveTrackerId) {
		return getPersistence().fetchByPrimaryKey(leaveTrackerId);
	}

	/**
	 * Returns all the leave trackers.
	 *
	 * @return the leave trackers
	 */
	public static List<LeaveTracker> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<LeaveTracker> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<LeaveTracker> findAll(
		int start, int end, OrderByComparator<LeaveTracker> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<LeaveTracker> findAll(
		int start, int end, OrderByComparator<LeaveTracker> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave trackers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave trackers.
	 *
	 * @return the number of leave trackers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveTrackerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LeaveTrackerPersistence _persistence;

}