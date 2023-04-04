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

import com.aixtor.intranet.exception.NoSuchleaveException;
import com.aixtor.intranet.model.leave;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leaveUtil
 * @generated
 */
@ProviderType
public interface leavePersistence extends BasePersistence<leave> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link leaveUtil} to access the leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leaves where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leaves
	 */
	public java.util.List<leave> findByUuid(String uuid);

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
	public java.util.List<leave> findByUuid(String uuid, int start, int end);

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
	public java.util.List<leave> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public java.util.List<leave> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the first leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the last leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the last leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the leaves before and after the current leave in the ordered set where uuid = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public leave[] findByUuid_PrevAndNext(
			long leaveId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Removes all the leaves where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leaves where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leaves
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchleaveException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByUUID_G(String uuid, long groupId)
		throws NoSuchleaveException;

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave that was removed
	 */
	public leave removeByUUID_G(String uuid, long groupId)
		throws NoSuchleaveException;

	/**
	 * Returns the number of leaves where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leaves
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leaves
	 */
	public java.util.List<leave> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public java.util.List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the first leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the last leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the last leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public leave[] findByUuid_C_PrevAndNext(
			long leaveId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Removes all the leaves where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leaves
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the leaves where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @return the matching leaves
	 */
	public java.util.List<leave> findByemployeeName(String employeeName);

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
	public java.util.List<leave> findByemployeeName(
		String employeeName, int start, int end);

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
	public java.util.List<leave> findByemployeeName(
		String employeeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public java.util.List<leave> findByemployeeName(
		String employeeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByemployeeName_First(
			String employeeName,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the first leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByemployeeName_First(
		String employeeName,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the last leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByemployeeName_Last(
			String employeeName,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the last leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByemployeeName_Last(
		String employeeName,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the leaves before and after the current leave in the ordered set where employeeName = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public leave[] findByemployeeName_PrevAndNext(
			long leaveId, String employeeName,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Removes all the leaves where employeeName = &#63; from the database.
	 *
	 * @param employeeName the employee name
	 */
	public void removeByemployeeName(String employeeName);

	/**
	 * Returns the number of leaves where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @return the number of matching leaves
	 */
	public int countByemployeeName(String employeeName);

	/**
	 * Returns all the leaves where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @return the matching leaves
	 */
	public java.util.List<leave> findByfromDate(String fromDate);

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
	public java.util.List<leave> findByfromDate(
		String fromDate, int start, int end);

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
	public java.util.List<leave> findByfromDate(
		String fromDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public java.util.List<leave> findByfromDate(
		String fromDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByfromDate_First(
			String fromDate,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the first leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByfromDate_First(
		String fromDate,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the last leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findByfromDate_Last(
			String fromDate,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the last leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchByfromDate_Last(
		String fromDate,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the leaves before and after the current leave in the ordered set where fromDate = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public leave[] findByfromDate_PrevAndNext(
			long leaveId, String fromDate,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Removes all the leaves where fromDate = &#63; from the database.
	 *
	 * @param fromDate the from date
	 */
	public void removeByfromDate(String fromDate);

	/**
	 * Returns the number of leaves where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @return the number of matching leaves
	 */
	public int countByfromDate(String fromDate);

	/**
	 * Returns all the leaves where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the matching leaves
	 */
	public java.util.List<leave> findBytoDate(String toDate);

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
	public java.util.List<leave> findBytoDate(
		String toDate, int start, int end);

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
	public java.util.List<leave> findBytoDate(
		String toDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public java.util.List<leave> findBytoDate(
		String toDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findBytoDate_First(
			String toDate,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the first leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchBytoDate_First(
		String toDate,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the last leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	public leave findBytoDate_Last(
			String toDate,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Returns the last leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	public leave fetchBytoDate_Last(
		String toDate,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

	/**
	 * Returns the leaves before and after the current leave in the ordered set where toDate = &#63;.
	 *
	 * @param leaveId the primary key of the current leave
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public leave[] findBytoDate_PrevAndNext(
			long leaveId, String toDate,
			com.liferay.portal.kernel.util.OrderByComparator<leave>
				orderByComparator)
		throws NoSuchleaveException;

	/**
	 * Removes all the leaves where toDate = &#63; from the database.
	 *
	 * @param toDate the to date
	 */
	public void removeBytoDate(String toDate);

	/**
	 * Returns the number of leaves where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the number of matching leaves
	 */
	public int countBytoDate(String toDate);

	/**
	 * Caches the leave in the entity cache if it is enabled.
	 *
	 * @param leave the leave
	 */
	public void cacheResult(leave leave);

	/**
	 * Caches the leaves in the entity cache if it is enabled.
	 *
	 * @param leaves the leaves
	 */
	public void cacheResult(java.util.List<leave> leaves);

	/**
	 * Creates a new leave with the primary key. Does not add the leave to the database.
	 *
	 * @param leaveId the primary key for the new leave
	 * @return the new leave
	 */
	public leave create(long leaveId);

	/**
	 * Removes the leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave that was removed
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public leave remove(long leaveId) throws NoSuchleaveException;

	public leave updateImpl(leave leave);

	/**
	 * Returns the leave with the primary key or throws a <code>NoSuchleaveException</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	public leave findByPrimaryKey(long leaveId) throws NoSuchleaveException;

	/**
	 * Returns the leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave, or <code>null</code> if a leave with the primary key could not be found
	 */
	public leave fetchByPrimaryKey(long leaveId);

	/**
	 * Returns all the leaves.
	 *
	 * @return the leaves
	 */
	public java.util.List<leave> findAll();

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
	public java.util.List<leave> findAll(int start, int end);

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
	public java.util.List<leave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator);

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
	public java.util.List<leave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<leave>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leaves from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leaves.
	 *
	 * @return the number of leaves
	 */
	public int countAll();

}