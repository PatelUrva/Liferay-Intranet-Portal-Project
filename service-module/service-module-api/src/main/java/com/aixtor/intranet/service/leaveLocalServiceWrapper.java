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
 * Provides a wrapper for {@link leaveLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see leaveLocalService
 * @generated
 */
public class leaveLocalServiceWrapper
	implements leaveLocalService, ServiceWrapper<leaveLocalService> {

	public leaveLocalServiceWrapper() {
		this(null);
	}

	public leaveLocalServiceWrapper(leaveLocalService leaveLocalService) {
		_leaveLocalService = leaveLocalService;
	}

	/**
	 * Adds the leave to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect leaveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leave the leave
	 * @return the leave that was added
	 */
	@Override
	public com.aixtor.intranet.model.leave addleave(
		com.aixtor.intranet.model.leave leave) {

		return _leaveLocalService.addleave(leave);
	}

	/**
	 * Creates a new leave with the primary key. Does not add the leave to the database.
	 *
	 * @param leaveId the primary key for the new leave
	 * @return the new leave
	 */
	@Override
	public com.aixtor.intranet.model.leave createleave(long leaveId) {
		return _leaveLocalService.createleave(leaveId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect leaveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leave the leave
	 * @return the leave that was removed
	 */
	@Override
	public com.aixtor.intranet.model.leave deleteleave(
		com.aixtor.intranet.model.leave leave) {

		return _leaveLocalService.deleteleave(leave);
	}

	/**
	 * Deletes the leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect leaveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave that was removed
	 * @throws PortalException if a leave with the primary key could not be found
	 */
	@Override
	public com.aixtor.intranet.model.leave deleteleave(long leaveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveLocalService.deleteleave(leaveId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveLocalService.dynamicQuery();
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

		return _leaveLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.intranet.model.impl.leaveModelImpl</code>.
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

		return _leaveLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.intranet.model.impl.leaveModelImpl</code>.
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

		return _leaveLocalService.dynamicQuery(
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

		return _leaveLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.aixtor.intranet.model.leave fetchleave(long leaveId) {
		return _leaveLocalService.fetchleave(leaveId);
	}

	/**
	 * Returns the leave matching the UUID and group.
	 *
	 * @param uuid the leave's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public com.aixtor.intranet.model.leave fetchleaveByUuidAndGroupId(
		String uuid, long groupId) {

		return _leaveLocalService.fetchleaveByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave with the primary key.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave
	 * @throws PortalException if a leave with the primary key could not be found
	 */
	@Override
	public com.aixtor.intranet.model.leave getleave(long leaveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveLocalService.getleave(leaveId);
	}

	/**
	 * Returns the leave matching the UUID and group.
	 *
	 * @param uuid the leave's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave
	 * @throws PortalException if a matching leave could not be found
	 */
	@Override
	public com.aixtor.intranet.model.leave getleaveByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveLocalService.getleaveByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.intranet.model.impl.leaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of leaves
	 */
	@Override
	public java.util.List<com.aixtor.intranet.model.leave> getleaves(
		int start, int end) {

		return _leaveLocalService.getleaves(start, end);
	}

	/**
	 * Returns all the leaves matching the UUID and company.
	 *
	 * @param uuid the UUID of the leaves
	 * @param companyId the primary key of the company
	 * @return the matching leaves, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.intranet.model.leave>
		getleavesByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveLocalService.getleavesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leaves matching the UUID and company.
	 *
	 * @param uuid the UUID of the leaves
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leaves, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.intranet.model.leave>
		getleavesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.aixtor.intranet.model.leave> orderByComparator) {

		return _leaveLocalService.getleavesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leaves.
	 *
	 * @return the number of leaves
	 */
	@Override
	public int getleavesCount() {
		return _leaveLocalService.getleavesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect leaveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leave the leave
	 * @return the leave that was updated
	 */
	@Override
	public com.aixtor.intranet.model.leave updateleave(
		com.aixtor.intranet.model.leave leave) {

		return _leaveLocalService.updateleave(leave);
	}

	@Override
	public leaveLocalService getWrappedService() {
		return _leaveLocalService;
	}

	@Override
	public void setWrappedService(leaveLocalService leaveLocalService) {
		_leaveLocalService = leaveLocalService;
	}

	private leaveLocalService _leaveLocalService;

}