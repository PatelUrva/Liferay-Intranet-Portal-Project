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

package com.aixtor.intranet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeaveTrackerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTrackerLocalService
 * @generated
 */
public class LeaveTrackerLocalServiceWrapper
	implements LeaveTrackerLocalService,
			   ServiceWrapper<LeaveTrackerLocalService> {

	public LeaveTrackerLocalServiceWrapper() {
		this(null);
	}

	public LeaveTrackerLocalServiceWrapper(
		LeaveTrackerLocalService leaveTrackerLocalService) {

		_leaveTrackerLocalService = leaveTrackerLocalService;
	}

	/**
	 * Adds the leave tracker to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTracker the leave tracker
	 * @return the leave tracker that was added
	 */
	@Override
	public com.aixtor.intranet.model.LeaveTracker addLeaveTracker(
		com.aixtor.intranet.model.LeaveTracker leaveTracker) {

		return _leaveTrackerLocalService.addLeaveTracker(leaveTracker);
	}

	/**
	 * Creates a new leave tracker with the primary key. Does not add the leave tracker to the database.
	 *
	 * @param leaveTrackerId the primary key for the new leave tracker
	 * @return the new leave tracker
	 */
	@Override
	public com.aixtor.intranet.model.LeaveTracker createLeaveTracker(
		long leaveTrackerId) {

		return _leaveTrackerLocalService.createLeaveTracker(leaveTrackerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTrackerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave tracker from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTracker the leave tracker
	 * @return the leave tracker that was removed
	 */
	@Override
	public com.aixtor.intranet.model.LeaveTracker deleteLeaveTracker(
		com.aixtor.intranet.model.LeaveTracker leaveTracker) {

		return _leaveTrackerLocalService.deleteLeaveTracker(leaveTracker);
	}

	/**
	 * Deletes the leave tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker that was removed
	 * @throws PortalException if a leave tracker with the primary key could not be found
	 */
	@Override
	public com.aixtor.intranet.model.LeaveTracker deleteLeaveTracker(
			long leaveTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTrackerLocalService.deleteLeaveTracker(leaveTrackerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTrackerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveTrackerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveTrackerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTrackerLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _leaveTrackerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.intranet.model.impl.LeaveTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _leaveTrackerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.intranet.model.impl.LeaveTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _leaveTrackerLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _leaveTrackerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _leaveTrackerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.aixtor.intranet.model.LeaveTracker fetchLeaveTracker(
		long leaveTrackerId) {

		return _leaveTrackerLocalService.fetchLeaveTracker(leaveTrackerId);
	}

	@Override
	public com.aixtor.intranet.model.LeaveTracker findByUserId(long userId) {
		return _leaveTrackerLocalService.findByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveTrackerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveTrackerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave tracker with the primary key.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker
	 * @throws PortalException if a leave tracker with the primary key could not be found
	 */
	@Override
	public com.aixtor.intranet.model.LeaveTracker getLeaveTracker(
			long leaveTrackerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTrackerLocalService.getLeaveTracker(leaveTrackerId);
	}

	/**
	 * Returns a range of all the leave trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.intranet.model.impl.LeaveTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave trackers
	 * @param end the upper bound of the range of leave trackers (not inclusive)
	 * @return the range of leave trackers
	 */
	@Override
	public java.util.List<com.aixtor.intranet.model.LeaveTracker>
		getLeaveTrackers(int start, int end) {

		return _leaveTrackerLocalService.getLeaveTrackers(start, end);
	}

	/**
	 * Returns the number of leave trackers.
	 *
	 * @return the number of leave trackers
	 */
	@Override
	public int getLeaveTrackersCount() {
		return _leaveTrackerLocalService.getLeaveTrackersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTrackerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTrackerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave tracker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTracker the leave tracker
	 * @return the leave tracker that was updated
	 */
	@Override
	public com.aixtor.intranet.model.LeaveTracker updateLeaveTracker(
		com.aixtor.intranet.model.LeaveTracker leaveTracker) {

		return _leaveTrackerLocalService.updateLeaveTracker(leaveTracker);
	}

	@Override
	public LeaveTrackerLocalService getWrappedService() {
		return _leaveTrackerLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTrackerLocalService leaveTrackerLocalService) {

		_leaveTrackerLocalService = leaveTrackerLocalService;
	}

	private LeaveTrackerLocalService _leaveTrackerLocalService;

}