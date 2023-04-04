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

package com.aixtor.intranet.service.persistence.impl;

import com.aixtor.intranet.exception.NoSuchleaveException;
import com.aixtor.intranet.model.impl.leaveImpl;
import com.aixtor.intranet.model.impl.leaveModelImpl;
import com.aixtor.intranet.model.leave;
import com.aixtor.intranet.model.leaveTable;
import com.aixtor.intranet.service.persistence.impl.constants.INTRANETPersistenceConstants;
import com.aixtor.intranet.service.persistence.leavePersistence;
import com.aixtor.intranet.service.persistence.leaveUtil;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {leavePersistence.class, BasePersistence.class})
public class leavePersistenceImpl
	extends BasePersistenceImpl<leave> implements leavePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>leaveUtil</code> to access the leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		leaveImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the leaves where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leaves
	 */
	@Override
	public List<leave> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<leave> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<leave> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<leave> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<leave> list = null;

		if (useFinderCache) {
			list = (List<leave>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leave leave : list) {
					if (!uuid.equals(leave.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LEAVE__WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(leaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<leave>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByUuid_First(
			String uuid, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByUuid_First(uuid, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByUuid_First(
		String uuid, OrderByComparator<leave> orderByComparator) {

		List<leave> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByUuid_Last(
			String uuid, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByUuid_Last(uuid, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByUuid_Last(
		String uuid, OrderByComparator<leave> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<leave> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public leave[] findByUuid_PrevAndNext(
			long leaveId, String uuid,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		uuid = Objects.toString(uuid, "");

		leave leave = findByPrimaryKey(leaveId);

		Session session = null;

		try {
			session = openSession();

			leave[] array = new leaveImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leave, uuid, orderByComparator, true);

			array[1] = leave;

			array[2] = getByUuid_PrevAndNext(
				session, leave, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected leave getByUuid_PrevAndNext(
		Session session, leave leave, String uuid,
		OrderByComparator<leave> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVE__WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(leaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leave)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<leave> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leaves where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (leave leave :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leave);
		}
	}

	/**
	 * Returns the number of leaves where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leaves
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVE__WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "leave_.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leave_.uuid IS NULL OR leave_.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchleaveException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByUUID_G(String uuid, long groupId)
		throws NoSuchleaveException {

		leave leave = fetchByUUID_G(uuid, groupId);

		if (leave == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchleaveException(sb.toString());
		}

		return leave;
	}

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof leave) {
			leave leave = (leave)result;

			if (!Objects.equals(uuid, leave.getUuid()) ||
				(groupId != leave.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVE__WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<leave> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					leave leave = list.get(0);

					result = leave;

					cacheResult(leave);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (leave)result;
		}
	}

	/**
	 * Removes the leave where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave that was removed
	 */
	@Override
	public leave removeByUUID_G(String uuid, long groupId)
		throws NoSuchleaveException {

		leave leave = findByUUID_G(uuid, groupId);

		return remove(leave);
	}

	/**
	 * Returns the number of leaves where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leaves
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVE__WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"leave_.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leave_.uuid IS NULL OR leave_.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leave_.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leaves
	 */
	@Override
	public List<leave> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<leave> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<leave> list = null;

		if (useFinderCache) {
			list = (List<leave>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leave leave : list) {
					if (!uuid.equals(leave.getUuid()) ||
						(companyId != leave.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LEAVE__WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(leaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<leave>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public leave findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the first leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<leave> orderByComparator) {

		List<leave> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public leave findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the last leave in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<leave> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<leave> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public leave[] findByUuid_C_PrevAndNext(
			long leaveId, String uuid, long companyId,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		uuid = Objects.toString(uuid, "");

		leave leave = findByPrimaryKey(leaveId);

		Session session = null;

		try {
			session = openSession();

			leave[] array = new leaveImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leave, uuid, companyId, orderByComparator, true);

			array[1] = leave;

			array[2] = getByUuid_C_PrevAndNext(
				session, leave, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected leave getByUuid_C_PrevAndNext(
		Session session, leave leave, String uuid, long companyId,
		OrderByComparator<leave> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVE__WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(leaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leave)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<leave> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leaves where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (leave leave :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leave);
		}
	}

	/**
	 * Returns the number of leaves where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leaves
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVE__WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"leave_.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leave_.uuid IS NULL OR leave_.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leave_.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByemployeeName;
	private FinderPath _finderPathWithoutPaginationFindByemployeeName;
	private FinderPath _finderPathCountByemployeeName;

	/**
	 * Returns all the leaves where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @return the matching leaves
	 */
	@Override
	public List<leave> findByemployeeName(String employeeName) {
		return findByemployeeName(
			employeeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<leave> findByemployeeName(
		String employeeName, int start, int end) {

		return findByemployeeName(employeeName, start, end, null);
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
	@Override
	public List<leave> findByemployeeName(
		String employeeName, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return findByemployeeName(
			employeeName, start, end, orderByComparator, true);
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
	@Override
	public List<leave> findByemployeeName(
		String employeeName, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		employeeName = Objects.toString(employeeName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemployeeName;
				finderArgs = new Object[] {employeeName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemployeeName;
			finderArgs = new Object[] {
				employeeName, start, end, orderByComparator
			};
		}

		List<leave> list = null;

		if (useFinderCache) {
			list = (List<leave>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leave leave : list) {
					if (!employeeName.equals(leave.getEmployeeName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LEAVE__WHERE);

			boolean bindEmployeeName = false;

			if (employeeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
			}
			else {
				bindEmployeeName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(leaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmployeeName) {
					queryPos.add(employeeName);
				}

				list = (List<leave>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByemployeeName_First(
			String employeeName, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByemployeeName_First(
			employeeName, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeName=");
		sb.append(employeeName);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the first leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByemployeeName_First(
		String employeeName, OrderByComparator<leave> orderByComparator) {

		List<leave> list = findByemployeeName(
			employeeName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByemployeeName_Last(
			String employeeName, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByemployeeName_Last(employeeName, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeName=");
		sb.append(employeeName);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the last leave in the ordered set where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByemployeeName_Last(
		String employeeName, OrderByComparator<leave> orderByComparator) {

		int count = countByemployeeName(employeeName);

		if (count == 0) {
			return null;
		}

		List<leave> list = findByemployeeName(
			employeeName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public leave[] findByemployeeName_PrevAndNext(
			long leaveId, String employeeName,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		employeeName = Objects.toString(employeeName, "");

		leave leave = findByPrimaryKey(leaveId);

		Session session = null;

		try {
			session = openSession();

			leave[] array = new leaveImpl[3];

			array[0] = getByemployeeName_PrevAndNext(
				session, leave, employeeName, orderByComparator, true);

			array[1] = leave;

			array[2] = getByemployeeName_PrevAndNext(
				session, leave, employeeName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected leave getByemployeeName_PrevAndNext(
		Session session, leave leave, String employeeName,
		OrderByComparator<leave> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVE__WHERE);

		boolean bindEmployeeName = false;

		if (employeeName.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
		}
		else {
			bindEmployeeName = true;

			sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(leaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmployeeName) {
			queryPos.add(employeeName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leave)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<leave> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leaves where employeeName = &#63; from the database.
	 *
	 * @param employeeName the employee name
	 */
	@Override
	public void removeByemployeeName(String employeeName) {
		for (leave leave :
				findByemployeeName(
					employeeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leave);
		}
	}

	/**
	 * Returns the number of leaves where employeeName = &#63;.
	 *
	 * @param employeeName the employee name
	 * @return the number of matching leaves
	 */
	@Override
	public int countByemployeeName(String employeeName) {
		employeeName = Objects.toString(employeeName, "");

		FinderPath finderPath = _finderPathCountByemployeeName;

		Object[] finderArgs = new Object[] {employeeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVE__WHERE);

			boolean bindEmployeeName = false;

			if (employeeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
			}
			else {
				bindEmployeeName = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmployeeName) {
					queryPos.add(employeeName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2 =
		"leave_.employeeName = ?";

	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3 =
		"(leave_.employeeName IS NULL OR leave_.employeeName = '')";

	private FinderPath _finderPathWithPaginationFindByfromDate;
	private FinderPath _finderPathWithoutPaginationFindByfromDate;
	private FinderPath _finderPathCountByfromDate;

	/**
	 * Returns all the leaves where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @return the matching leaves
	 */
	@Override
	public List<leave> findByfromDate(String fromDate) {
		return findByfromDate(
			fromDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<leave> findByfromDate(String fromDate, int start, int end) {
		return findByfromDate(fromDate, start, end, null);
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
	@Override
	public List<leave> findByfromDate(
		String fromDate, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return findByfromDate(fromDate, start, end, orderByComparator, true);
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
	@Override
	public List<leave> findByfromDate(
		String fromDate, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		fromDate = Objects.toString(fromDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfromDate;
				finderArgs = new Object[] {fromDate};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfromDate;
			finderArgs = new Object[] {fromDate, start, end, orderByComparator};
		}

		List<leave> list = null;

		if (useFinderCache) {
			list = (List<leave>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leave leave : list) {
					if (!fromDate.equals(leave.getFromDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LEAVE__WHERE);

			boolean bindFromDate = false;

			if (fromDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_FROMDATE_FROMDATE_3);
			}
			else {
				bindFromDate = true;

				sb.append(_FINDER_COLUMN_FROMDATE_FROMDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(leaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFromDate) {
					queryPos.add(fromDate);
				}

				list = (List<leave>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByfromDate_First(
			String fromDate, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByfromDate_First(fromDate, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fromDate=");
		sb.append(fromDate);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the first leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByfromDate_First(
		String fromDate, OrderByComparator<leave> orderByComparator) {

		List<leave> list = findByfromDate(fromDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findByfromDate_Last(
			String fromDate, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchByfromDate_Last(fromDate, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fromDate=");
		sb.append(fromDate);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the last leave in the ordered set where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchByfromDate_Last(
		String fromDate, OrderByComparator<leave> orderByComparator) {

		int count = countByfromDate(fromDate);

		if (count == 0) {
			return null;
		}

		List<leave> list = findByfromDate(
			fromDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public leave[] findByfromDate_PrevAndNext(
			long leaveId, String fromDate,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		fromDate = Objects.toString(fromDate, "");

		leave leave = findByPrimaryKey(leaveId);

		Session session = null;

		try {
			session = openSession();

			leave[] array = new leaveImpl[3];

			array[0] = getByfromDate_PrevAndNext(
				session, leave, fromDate, orderByComparator, true);

			array[1] = leave;

			array[2] = getByfromDate_PrevAndNext(
				session, leave, fromDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected leave getByfromDate_PrevAndNext(
		Session session, leave leave, String fromDate,
		OrderByComparator<leave> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVE__WHERE);

		boolean bindFromDate = false;

		if (fromDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_FROMDATE_FROMDATE_3);
		}
		else {
			bindFromDate = true;

			sb.append(_FINDER_COLUMN_FROMDATE_FROMDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(leaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFromDate) {
			queryPos.add(fromDate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leave)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<leave> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leaves where fromDate = &#63; from the database.
	 *
	 * @param fromDate the from date
	 */
	@Override
	public void removeByfromDate(String fromDate) {
		for (leave leave :
				findByfromDate(
					fromDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leave);
		}
	}

	/**
	 * Returns the number of leaves where fromDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @return the number of matching leaves
	 */
	@Override
	public int countByfromDate(String fromDate) {
		fromDate = Objects.toString(fromDate, "");

		FinderPath finderPath = _finderPathCountByfromDate;

		Object[] finderArgs = new Object[] {fromDate};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVE__WHERE);

			boolean bindFromDate = false;

			if (fromDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_FROMDATE_FROMDATE_3);
			}
			else {
				bindFromDate = true;

				sb.append(_FINDER_COLUMN_FROMDATE_FROMDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFromDate) {
					queryPos.add(fromDate);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FROMDATE_FROMDATE_2 =
		"leave_.fromDate = ?";

	private static final String _FINDER_COLUMN_FROMDATE_FROMDATE_3 =
		"(leave_.fromDate IS NULL OR leave_.fromDate = '')";

	private FinderPath _finderPathWithPaginationFindBytoDate;
	private FinderPath _finderPathWithoutPaginationFindBytoDate;
	private FinderPath _finderPathCountBytoDate;

	/**
	 * Returns all the leaves where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the matching leaves
	 */
	@Override
	public List<leave> findBytoDate(String toDate) {
		return findBytoDate(toDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<leave> findBytoDate(String toDate, int start, int end) {
		return findBytoDate(toDate, start, end, null);
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
	@Override
	public List<leave> findBytoDate(
		String toDate, int start, int end,
		OrderByComparator<leave> orderByComparator) {

		return findBytoDate(toDate, start, end, orderByComparator, true);
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
	@Override
	public List<leave> findBytoDate(
		String toDate, int start, int end,
		OrderByComparator<leave> orderByComparator, boolean useFinderCache) {

		toDate = Objects.toString(toDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytoDate;
				finderArgs = new Object[] {toDate};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytoDate;
			finderArgs = new Object[] {toDate, start, end, orderByComparator};
		}

		List<leave> list = null;

		if (useFinderCache) {
			list = (List<leave>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (leave leave : list) {
					if (!toDate.equals(leave.getToDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LEAVE__WHERE);

			boolean bindToDate = false;

			if (toDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_TODATE_TODATE_3);
			}
			else {
				bindToDate = true;

				sb.append(_FINDER_COLUMN_TODATE_TODATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(leaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToDate) {
					queryPos.add(toDate);
				}

				list = (List<leave>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findBytoDate_First(
			String toDate, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchBytoDate_First(toDate, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toDate=");
		sb.append(toDate);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the first leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchBytoDate_First(
		String toDate, OrderByComparator<leave> orderByComparator) {

		List<leave> list = findBytoDate(toDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave
	 * @throws NoSuchleaveException if a matching leave could not be found
	 */
	@Override
	public leave findBytoDate_Last(
			String toDate, OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		leave leave = fetchBytoDate_Last(toDate, orderByComparator);

		if (leave != null) {
			return leave;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toDate=");
		sb.append(toDate);

		sb.append("}");

		throw new NoSuchleaveException(sb.toString());
	}

	/**
	 * Returns the last leave in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave, or <code>null</code> if a matching leave could not be found
	 */
	@Override
	public leave fetchBytoDate_Last(
		String toDate, OrderByComparator<leave> orderByComparator) {

		int count = countBytoDate(toDate);

		if (count == 0) {
			return null;
		}

		List<leave> list = findBytoDate(
			toDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public leave[] findBytoDate_PrevAndNext(
			long leaveId, String toDate,
			OrderByComparator<leave> orderByComparator)
		throws NoSuchleaveException {

		toDate = Objects.toString(toDate, "");

		leave leave = findByPrimaryKey(leaveId);

		Session session = null;

		try {
			session = openSession();

			leave[] array = new leaveImpl[3];

			array[0] = getBytoDate_PrevAndNext(
				session, leave, toDate, orderByComparator, true);

			array[1] = leave;

			array[2] = getBytoDate_PrevAndNext(
				session, leave, toDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected leave getBytoDate_PrevAndNext(
		Session session, leave leave, String toDate,
		OrderByComparator<leave> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVE__WHERE);

		boolean bindToDate = false;

		if (toDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_TODATE_TODATE_3);
		}
		else {
			bindToDate = true;

			sb.append(_FINDER_COLUMN_TODATE_TODATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(leaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindToDate) {
			queryPos.add(toDate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leave)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<leave> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leaves where toDate = &#63; from the database.
	 *
	 * @param toDate the to date
	 */
	@Override
	public void removeBytoDate(String toDate) {
		for (leave leave :
				findBytoDate(
					toDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leave);
		}
	}

	/**
	 * Returns the number of leaves where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the number of matching leaves
	 */
	@Override
	public int countBytoDate(String toDate) {
		toDate = Objects.toString(toDate, "");

		FinderPath finderPath = _finderPathCountBytoDate;

		Object[] finderArgs = new Object[] {toDate};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVE__WHERE);

			boolean bindToDate = false;

			if (toDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_TODATE_TODATE_3);
			}
			else {
				bindToDate = true;

				sb.append(_FINDER_COLUMN_TODATE_TODATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToDate) {
					queryPos.add(toDate);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TODATE_TODATE_2 =
		"leave_.toDate = ?";

	private static final String _FINDER_COLUMN_TODATE_TODATE_3 =
		"(leave_.toDate IS NULL OR leave_.toDate = '')";

	public leavePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(leave.class);

		setModelImplClass(leaveImpl.class);
		setModelPKClass(long.class);

		setTable(leaveTable.INSTANCE);
	}

	/**
	 * Caches the leave in the entity cache if it is enabled.
	 *
	 * @param leave the leave
	 */
	@Override
	public void cacheResult(leave leave) {
		entityCache.putResult(leaveImpl.class, leave.getPrimaryKey(), leave);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {leave.getUuid(), leave.getGroupId()}, leave);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leaves in the entity cache if it is enabled.
	 *
	 * @param leaves the leaves
	 */
	@Override
	public void cacheResult(List<leave> leaves) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaves.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (leave leave : leaves) {
			if (entityCache.getResult(leaveImpl.class, leave.getPrimaryKey()) ==
					null) {

				cacheResult(leave);
			}
		}
	}

	/**
	 * Clears the cache for all leaves.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(leaveImpl.class);

		finderCache.clearCache(leaveImpl.class);
	}

	/**
	 * Clears the cache for the leave.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(leave leave) {
		entityCache.removeResult(leaveImpl.class, leave);
	}

	@Override
	public void clearCache(List<leave> leaves) {
		for (leave leave : leaves) {
			entityCache.removeResult(leaveImpl.class, leave);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(leaveImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(leaveImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(leaveModelImpl leaveModelImpl) {
		Object[] args = new Object[] {
			leaveModelImpl.getUuid(), leaveModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, leaveModelImpl);
	}

	/**
	 * Creates a new leave with the primary key. Does not add the leave to the database.
	 *
	 * @param leaveId the primary key for the new leave
	 * @return the new leave
	 */
	@Override
	public leave create(long leaveId) {
		leave leave = new leaveImpl();

		leave.setNew(true);
		leave.setPrimaryKey(leaveId);

		String uuid = _portalUUID.generate();

		leave.setUuid(uuid);

		leave.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leave;
	}

	/**
	 * Removes the leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave that was removed
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	@Override
	public leave remove(long leaveId) throws NoSuchleaveException {
		return remove((Serializable)leaveId);
	}

	/**
	 * Removes the leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave
	 * @return the leave that was removed
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	@Override
	public leave remove(Serializable primaryKey) throws NoSuchleaveException {
		Session session = null;

		try {
			session = openSession();

			leave leave = (leave)session.get(leaveImpl.class, primaryKey);

			if (leave == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchleaveException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leave);
		}
		catch (NoSuchleaveException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected leave removeImpl(leave leave) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leave)) {
				leave = (leave)session.get(
					leaveImpl.class, leave.getPrimaryKeyObj());
			}

			if (leave != null) {
				session.delete(leave);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leave != null) {
			clearCache(leave);
		}

		return leave;
	}

	@Override
	public leave updateImpl(leave leave) {
		boolean isNew = leave.isNew();

		if (!(leave instanceof leaveModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leave.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leave);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leave proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom leave implementation " +
					leave.getClass());
		}

		leaveModelImpl leaveModelImpl = (leaveModelImpl)leave;

		if (Validator.isNull(leave.getUuid())) {
			String uuid = _portalUUID.generate();

			leave.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leave.getCreateDate() == null)) {
			if (serviceContext == null) {
				leave.setCreateDate(date);
			}
			else {
				leave.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leaveModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leave.setModifiedDate(date);
			}
			else {
				leave.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leave);
			}
			else {
				leave = (leave)session.merge(leave);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(leaveImpl.class, leaveModelImpl, false, true);

		cacheUniqueFindersCache(leaveModelImpl);

		if (isNew) {
			leave.setNew(false);
		}

		leave.resetOriginalValues();

		return leave;
	}

	/**
	 * Returns the leave with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave
	 * @return the leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	@Override
	public leave findByPrimaryKey(Serializable primaryKey)
		throws NoSuchleaveException {

		leave leave = fetchByPrimaryKey(primaryKey);

		if (leave == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchleaveException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leave;
	}

	/**
	 * Returns the leave with the primary key or throws a <code>NoSuchleaveException</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave
	 * @throws NoSuchleaveException if a leave with the primary key could not be found
	 */
	@Override
	public leave findByPrimaryKey(long leaveId) throws NoSuchleaveException {
		return findByPrimaryKey((Serializable)leaveId);
	}

	/**
	 * Returns the leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave
	 * @return the leave, or <code>null</code> if a leave with the primary key could not be found
	 */
	@Override
	public leave fetchByPrimaryKey(long leaveId) {
		return fetchByPrimaryKey((Serializable)leaveId);
	}

	/**
	 * Returns all the leaves.
	 *
	 * @return the leaves
	 */
	@Override
	public List<leave> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<leave> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<leave> findAll(
		int start, int end, OrderByComparator<leave> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<leave> findAll(
		int start, int end, OrderByComparator<leave> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<leave> list = null;

		if (useFinderCache) {
			list = (List<leave>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVE_);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVE_;

				sql = sql.concat(leaveModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<leave>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the leaves from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (leave leave : findAll()) {
			remove(leave);
		}
	}

	/**
	 * Returns the number of leaves.
	 *
	 * @return the number of leaves
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVE_);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "leaveId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVE_;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return leaveModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByemployeeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeName"}, true);

		_finderPathWithoutPaginationFindByemployeeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeName",
			new String[] {String.class.getName()},
			new String[] {"employeeName"}, true);

		_finderPathCountByemployeeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeName",
			new String[] {String.class.getName()},
			new String[] {"employeeName"}, false);

		_finderPathWithPaginationFindByfromDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfromDate",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fromDate"}, true);

		_finderPathWithoutPaginationFindByfromDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfromDate",
			new String[] {String.class.getName()}, new String[] {"fromDate"},
			true);

		_finderPathCountByfromDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfromDate",
			new String[] {String.class.getName()}, new String[] {"fromDate"},
			false);

		_finderPathWithPaginationFindBytoDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytoDate",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"toDate"}, true);

		_finderPathWithoutPaginationFindBytoDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytoDate",
			new String[] {String.class.getName()}, new String[] {"toDate"},
			true);

		_finderPathCountBytoDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytoDate",
			new String[] {String.class.getName()}, new String[] {"toDate"},
			false);

		_setleaveUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setleaveUtilPersistence(null);

		entityCache.removeCache(leaveImpl.class.getName());
	}

	private void _setleaveUtilPersistence(leavePersistence leavePersistence) {
		try {
			Field field = leaveUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, leavePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LEAVE_ =
		"SELECT leave_ FROM leave leave_";

	private static final String _SQL_SELECT_LEAVE__WHERE =
		"SELECT leave_ FROM leave leave_ WHERE ";

	private static final String _SQL_COUNT_LEAVE_ =
		"SELECT COUNT(leave_) FROM leave leave_";

	private static final String _SQL_COUNT_LEAVE__WHERE =
		"SELECT COUNT(leave_) FROM leave leave_ WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leave_.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No leave exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No leave exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		leavePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}