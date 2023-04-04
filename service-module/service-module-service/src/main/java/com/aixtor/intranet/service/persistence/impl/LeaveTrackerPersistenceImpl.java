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

import com.aixtor.intranet.exception.NoSuchLeaveTrackerException;
import com.aixtor.intranet.model.LeaveTracker;
import com.aixtor.intranet.model.LeaveTrackerTable;
import com.aixtor.intranet.model.impl.LeaveTrackerImpl;
import com.aixtor.intranet.model.impl.LeaveTrackerModelImpl;
import com.aixtor.intranet.service.persistence.LeaveTrackerPersistence;
import com.aixtor.intranet.service.persistence.LeaveTrackerUtil;
import com.aixtor.intranet.service.persistence.impl.constants.INTRANETPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the leave tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {LeaveTrackerPersistence.class, BasePersistence.class})
public class LeaveTrackerPersistenceImpl
	extends BasePersistenceImpl<LeaveTracker>
	implements LeaveTrackerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveTrackerUtil</code> to access the leave tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveTrackerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the leave tracker where userId = &#63; or throws a <code>NoSuchLeaveTrackerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching leave tracker
	 * @throws NoSuchLeaveTrackerException if a matching leave tracker could not be found
	 */
	@Override
	public LeaveTracker findByUserId(long userId)
		throws NoSuchLeaveTrackerException {

		LeaveTracker leaveTracker = fetchByUserId(userId);

		if (leaveTracker == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveTrackerException(sb.toString());
		}

		return leaveTracker;
	}

	/**
	 * Returns the leave tracker where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching leave tracker, or <code>null</code> if a matching leave tracker could not be found
	 */
	@Override
	public LeaveTracker fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the leave tracker where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave tracker, or <code>null</code> if a matching leave tracker could not be found
	 */
	@Override
	public LeaveTracker fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs, this);
		}

		if (result instanceof LeaveTracker) {
			LeaveTracker leaveTracker = (LeaveTracker)result;

			if (userId != leaveTracker.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVETRACKER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<LeaveTracker> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"LeaveTrackerPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveTracker leaveTracker = list.get(0);

					result = leaveTracker;

					cacheResult(leaveTracker);
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
			return (LeaveTracker)result;
		}
	}

	/**
	 * Removes the leave tracker where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the leave tracker that was removed
	 */
	@Override
	public LeaveTracker removeByUserId(long userId)
		throws NoSuchLeaveTrackerException {

		LeaveTracker leaveTracker = findByUserId(userId);

		return remove(leaveTracker);
	}

	/**
	 * Returns the number of leave trackers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching leave trackers
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVETRACKER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"leaveTracker.userId = ?";

	public LeaveTrackerPersistenceImpl() {
		setModelClass(LeaveTracker.class);

		setModelImplClass(LeaveTrackerImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveTrackerTable.INSTANCE);
	}

	/**
	 * Caches the leave tracker in the entity cache if it is enabled.
	 *
	 * @param leaveTracker the leave tracker
	 */
	@Override
	public void cacheResult(LeaveTracker leaveTracker) {
		entityCache.putResult(
			LeaveTrackerImpl.class, leaveTracker.getPrimaryKey(), leaveTracker);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {leaveTracker.getUserId()},
			leaveTracker);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave trackers in the entity cache if it is enabled.
	 *
	 * @param leaveTrackers the leave trackers
	 */
	@Override
	public void cacheResult(List<LeaveTracker> leaveTrackers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveTrackers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveTracker leaveTracker : leaveTrackers) {
			if (entityCache.getResult(
					LeaveTrackerImpl.class, leaveTracker.getPrimaryKey()) ==
						null) {

				cacheResult(leaveTracker);
			}
		}
	}

	/**
	 * Clears the cache for all leave trackers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveTrackerImpl.class);

		finderCache.clearCache(LeaveTrackerImpl.class);
	}

	/**
	 * Clears the cache for the leave tracker.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveTracker leaveTracker) {
		entityCache.removeResult(LeaveTrackerImpl.class, leaveTracker);
	}

	@Override
	public void clearCache(List<LeaveTracker> leaveTrackers) {
		for (LeaveTracker leaveTracker : leaveTrackers) {
			entityCache.removeResult(LeaveTrackerImpl.class, leaveTracker);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveTrackerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveTrackerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveTrackerModelImpl leaveTrackerModelImpl) {

		Object[] args = new Object[] {leaveTrackerModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUserId, args, leaveTrackerModelImpl);
	}

	/**
	 * Creates a new leave tracker with the primary key. Does not add the leave tracker to the database.
	 *
	 * @param leaveTrackerId the primary key for the new leave tracker
	 * @return the new leave tracker
	 */
	@Override
	public LeaveTracker create(long leaveTrackerId) {
		LeaveTracker leaveTracker = new LeaveTrackerImpl();

		leaveTracker.setNew(true);
		leaveTracker.setPrimaryKey(leaveTrackerId);

		leaveTracker.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveTracker;
	}

	/**
	 * Removes the leave tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker that was removed
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	@Override
	public LeaveTracker remove(long leaveTrackerId)
		throws NoSuchLeaveTrackerException {

		return remove((Serializable)leaveTrackerId);
	}

	/**
	 * Removes the leave tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave tracker
	 * @return the leave tracker that was removed
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	@Override
	public LeaveTracker remove(Serializable primaryKey)
		throws NoSuchLeaveTrackerException {

		Session session = null;

		try {
			session = openSession();

			LeaveTracker leaveTracker = (LeaveTracker)session.get(
				LeaveTrackerImpl.class, primaryKey);

			if (leaveTracker == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTrackerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveTracker);
		}
		catch (NoSuchLeaveTrackerException noSuchEntityException) {
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
	protected LeaveTracker removeImpl(LeaveTracker leaveTracker) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveTracker)) {
				leaveTracker = (LeaveTracker)session.get(
					LeaveTrackerImpl.class, leaveTracker.getPrimaryKeyObj());
			}

			if (leaveTracker != null) {
				session.delete(leaveTracker);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveTracker != null) {
			clearCache(leaveTracker);
		}

		return leaveTracker;
	}

	@Override
	public LeaveTracker updateImpl(LeaveTracker leaveTracker) {
		boolean isNew = leaveTracker.isNew();

		if (!(leaveTracker instanceof LeaveTrackerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveTracker.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveTracker);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveTracker proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveTracker implementation " +
					leaveTracker.getClass());
		}

		LeaveTrackerModelImpl leaveTrackerModelImpl =
			(LeaveTrackerModelImpl)leaveTracker;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveTracker.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveTracker.setCreateDate(date);
			}
			else {
				leaveTracker.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leaveTrackerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveTracker.setModifiedDate(date);
			}
			else {
				leaveTracker.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveTracker);
			}
			else {
				leaveTracker = (LeaveTracker)session.merge(leaveTracker);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveTrackerImpl.class, leaveTrackerModelImpl, false, true);

		cacheUniqueFindersCache(leaveTrackerModelImpl);

		if (isNew) {
			leaveTracker.setNew(false);
		}

		leaveTracker.resetOriginalValues();

		return leaveTracker;
	}

	/**
	 * Returns the leave tracker with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave tracker
	 * @return the leave tracker
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	@Override
	public LeaveTracker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTrackerException {

		LeaveTracker leaveTracker = fetchByPrimaryKey(primaryKey);

		if (leaveTracker == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTrackerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveTracker;
	}

	/**
	 * Returns the leave tracker with the primary key or throws a <code>NoSuchLeaveTrackerException</code> if it could not be found.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker
	 * @throws NoSuchLeaveTrackerException if a leave tracker with the primary key could not be found
	 */
	@Override
	public LeaveTracker findByPrimaryKey(long leaveTrackerId)
		throws NoSuchLeaveTrackerException {

		return findByPrimaryKey((Serializable)leaveTrackerId);
	}

	/**
	 * Returns the leave tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTrackerId the primary key of the leave tracker
	 * @return the leave tracker, or <code>null</code> if a leave tracker with the primary key could not be found
	 */
	@Override
	public LeaveTracker fetchByPrimaryKey(long leaveTrackerId) {
		return fetchByPrimaryKey((Serializable)leaveTrackerId);
	}

	/**
	 * Returns all the leave trackers.
	 *
	 * @return the leave trackers
	 */
	@Override
	public List<LeaveTracker> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LeaveTracker> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LeaveTracker> findAll(
		int start, int end, OrderByComparator<LeaveTracker> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LeaveTracker> findAll(
		int start, int end, OrderByComparator<LeaveTracker> orderByComparator,
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

		List<LeaveTracker> list = null;

		if (useFinderCache) {
			list = (List<LeaveTracker>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVETRACKER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETRACKER;

				sql = sql.concat(LeaveTrackerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveTracker>)QueryUtil.list(
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
	 * Removes all the leave trackers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveTracker leaveTracker : findAll()) {
			remove(leaveTracker);
		}
	}

	/**
	 * Returns the number of leave trackers.
	 *
	 * @return the number of leave trackers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVETRACKER);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "leaveTrackerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVETRACKER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveTrackerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave tracker persistence.
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

		_finderPathFetchByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setLeaveTrackerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLeaveTrackerUtilPersistence(null);

		entityCache.removeCache(LeaveTrackerImpl.class.getName());
	}

	private void _setLeaveTrackerUtilPersistence(
		LeaveTrackerPersistence leaveTrackerPersistence) {

		try {
			Field field = LeaveTrackerUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, leaveTrackerPersistence);
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

	private static final String _SQL_SELECT_LEAVETRACKER =
		"SELECT leaveTracker FROM LeaveTracker leaveTracker";

	private static final String _SQL_SELECT_LEAVETRACKER_WHERE =
		"SELECT leaveTracker FROM LeaveTracker leaveTracker WHERE ";

	private static final String _SQL_COUNT_LEAVETRACKER =
		"SELECT COUNT(leaveTracker) FROM LeaveTracker leaveTracker";

	private static final String _SQL_COUNT_LEAVETRACKER_WHERE =
		"SELECT COUNT(leaveTracker) FROM LeaveTracker leaveTracker WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveTracker.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveTracker exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveTracker exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveTrackerPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}