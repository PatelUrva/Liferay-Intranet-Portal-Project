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

import com.aixtor.intranet.model.leave;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave service. This utility wraps <code>com.aixtor.intranet.service.persistence.impl.leavePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leavePersistence
 * @generated
 */
public class leaveUtil {

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
	public static void clearCache(leave leave) {
		getPersistence().clearCache(leave);
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
	public static Map<Serializable, leave> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<leave> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<leave> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<leave> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static leave update(leave leave) {
		return getPersistence().update(leave);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static leave update(leave leave, ServiceContext serviceContext) {
		return getPersistence().update(leave, serviceContext);
	}

	/**
	 * Returns all the leaves where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leaves
	 */
	public static List<leave> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leaves where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of matching leaves
	 */
	public static List<leave> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leaves where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leaves where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByUuid_First(
			String uuid, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByUuid_First(
		String uuid, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByUuid_Last(
			String uuid, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByUuid_Last(
		String uuid, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leaves before and after the current leave in the ordered set where uuid = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave[] findByUuid_PrevAndNext(
			long leaveId, String uuid,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leaves where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leaves where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leaves
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchleaveException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByUUID_G(String uuid, long groupId)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave that was removed
	 */
	public static leave removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leaves where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leaves
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leaves
	 */
	public static List<leave> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of matching leaves
	 */
	public static List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leaves before and after the current leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave[] findByUuid_C_PrevAndNext(
			long leaveId, String uuid, long companyId,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leaves where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leaves
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the leaves where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @return the matching leaves
	 */
	public static List<leave> findByemployeeName(String employeeName) {
		return getPersistence().findByemployeeName(employeeName);
	}

	/**
	 * Returns a range of all the leaves where employeeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param employeeName the employee name
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of matching leaves
	 */
	public static List<leave> findByemployeeName(
		String employeeName, int start, int end) {

		return getPersistence().findByemployeeName(employeeName, start, end);
	}

	/**
	 * Returns an ordered range of all the leaves where employeeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param employeeName the employee name
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByemployeeName(
		String employeeName, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().findByemployeeName(
			employeeName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leaves where employeeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param employeeName the employee name
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByemployeeName(
		String employeeName, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByemployeeName(
			employeeName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByemployeeName_First(
			String employeeName, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByemployeeName_First(
			employeeName, orderByComparator);
	}

	/**
	 * Returns the first leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByemployeeName_First(
		String employeeName, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByemployeeName_First(
			employeeName, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByemployeeName_Last(
			String employeeName, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByemployeeName_Last(
			employeeName, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByemployeeName_Last(
		String employeeName, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByemployeeName_Last(
			employeeName, orderByComparator);
	}

	/**
	 * Returns the leaves before and after the current leave in the ordered set where employeeName = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave[] findByemployeeName_PrevAndNext(
			long leaveId, String employeeName,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByemployeeName_PrevAndNext(
			leaveId, employeeName, orderByComparator);
	}

	/**
	 * Removes all the leaves where employeeName = &#63; from the database.
	 *
	 * @param employeeName the employee name
	 */
	public static void removeByemployeeName(String employeeName) {
		getPersistence().removeByemployeeName(employeeName);
	}

	/**
	 * Returns the number of leaves where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @return the number of matching leaves
	 */
	public static int countByemployeeName(String employeeName) {
		return getPersistence().countByemployeeName(employeeName);
	}

	/**
	 * Returns all the leaves where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @return the matching leaves
	 */
	public static List<leave> findByfromDate(String fromDate) {
		return getPersistence().findByfromDate(fromDate);
	}

	/**
	 * Returns a range of all the leaves where fromDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of matching leaves
	 */
	public static List<leave> findByfromDate(
		String fromDate, int start, int end) {

		return getPersistence().findByfromDate(fromDate, start, end);
	}

	/**
	 * Returns an ordered range of all the leaves where fromDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByfromDate(
		String fromDate, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().findByfromDate(
			fromDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leaves where fromDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findByfromDate(
		String fromDate, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfromDate(
			fromDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByfromDate_First(
			String fromDate, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByfromDate_First(
			fromDate, orderByComparator);
	}

	/**
	 * Returns the first leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByfromDate_First(
		String fromDate, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByfromDate_First(
			fromDate, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findByfromDate_Last(
			String fromDate, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByfromDate_Last(
			fromDate, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchByfromDate_Last(
		String fromDate, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchByfromDate_Last(
			fromDate, orderByComparator);
	}

	/**
	 * Returns the leaves before and after the current leave in the ordered set where fromDate = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave[] findByfromDate_PrevAndNext(
			long leaveId, String fromDate,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByfromDate_PrevAndNext(
			leaveId, fromDate, orderByComparator);
	}

	/**
	 * Removes all the leaves where fromDate = &#63; from the database.
	 *
	 * @param fromDate the from date
	 */
	public static void removeByfromDate(String fromDate) {
		getPersistence().removeByfromDate(fromDate);
	}

	/**
	 * Returns the number of leaves where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @return the number of matching leaves
	 */
	public static int countByfromDate(String fromDate) {
		return getPersistence().countByfromDate(fromDate);
	}

	/**
	 * Returns all the leaves where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the matching leaves
	 */
	public static List<leave> findBytoDate(String toDate) {
		return getPersistence().findBytoDate(toDate);
	}

	/**
	 * Returns a range of all the leaves where toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param toDate the to date
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of matching leaves
	 */
	public static List<leave> findBytoDate(String toDate, int start, int end) {
		return getPersistence().findBytoDate(toDate, start, end);
	}

	/**
	 * Returns an ordered range of all the leaves where toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param toDate the to date
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findBytoDate(
		String toDate, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return getPersistence().findBytoDate(
			toDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leaves where toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param toDate the to date
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leaves
	 */
	public static List<leave> findBytoDate(
		String toDate, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytoDate(
			toDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findBytoDate_First(
			String toDate, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findBytoDate_First(toDate, orderByComparator);
	}

	/**
	 * Returns the first leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchBytoDate_First(
		String toDate, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchBytoDate_First(toDate, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public static leave findBytoDate_Last(
			String toDate, OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findBytoDate_Last(toDate, orderByComparator);
	}

	/**
	 * Returns the last leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public static leave fetchBytoDate_Last(
		String toDate, OrderByComparator<leave> orderByComparator) {

		return getPersistence().fetchBytoDate_Last(toDate, orderByComparator);
	}

	/**
	 * Returns the leaves before and after the current leave in the ordered set where toDate = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave[] findBytoDate_PrevAndNext(
			long leaveId, String toDate,
			OrderByComparator<leave> orderByComparator)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findBytoDate_PrevAndNext(
			leaveId, toDate, orderByComparator);
	}

	/**
	 * Removes all the leaves where toDate = &#63; from the database.
	 *
	 * @param toDate the to date
	 */
	public static void removeBytoDate(String toDate) {
		getPersistence().removeBytoDate(toDate);
	}

	/**
	 * Returns the number of leaves where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the number of matching leaves
	 */
	public static int countBytoDate(String toDate) {
		return getPersistence().countBytoDate(toDate);
	}

	/**
	 * Caches the leave in the entity cache if it is enabled.
	 *
	 * @param leave the leave
	 */
	public static void cacheResult(leave leave) {
		getPersistence().cacheResult(leave);
	}

	/**
	 * Caches the leaves in the entity cache if it is enabled.
	 *
	 * @param leaves the leaves
	 */
	public static void cacheResult(List<leave> leaves) {
		getPersistence().cacheResult(leaves);
	}

	/**
	 * Creates a new leave with the primary key. Does not add the leave to the database.
	 *
	 * @param leaveId the primary key for the new leave
	 * @return the new leave
	 */
	public static leave create(long leaveId) {
		return getPersistence().create(leaveId);
	}

	/**
	 * Removes the leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave that was removed
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave remove(long leaveId)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().remove(leaveId);
	}

	public static leave updateImpl(leave leave) {
		return getPersistence().updateImpl(leave);
	}

	/**
	 * Returns the leave with the primary key or throws a <code>NoSuchleaveException</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public static leave findByPrimaryKey(long leaveId)
		throws com.aixtor.intranet.exception.NoSuchleaveException {

		return getPersistence().findByPrimaryKey(leaveId);
	}

	/**
	 * Returns the leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave, or <code>null</code> if a leave with the primary key could not be found
	 */
	public static leave fetchByPrimaryKey(long leaveId) {
		return getPersistence().fetchByPrimaryKey(leaveId);
	}

	/**
	 * Returns all the leaves.
	 *
	 * @return the leaves
	 */
	public static List<leave> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @return the range of leaves
	 */
	public static List<leave> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leaves
	 */
	public static List<leave> findAll(
		int start, int end, OrderByComparator<leave> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>leaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leaves
	 * @param end the upper bound of the range of leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leaves
	 */
	public static List<leave> findAll(
		int start, int end, OrderByComparator<leave> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leaves from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leaves.
	 *
	 * @return the number of leaves
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static leavePersistence getPersistence() {
		return _persistence;
	}

	private static volatile leavePersistence _persistence;

}