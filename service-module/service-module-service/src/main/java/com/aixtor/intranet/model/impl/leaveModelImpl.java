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

import com.aixtor.intranet.model.leave;
import com.aixtor.intranet.model.leaveModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the leave service. Represents a row in the &quot;INTRANET_leave&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>leaveModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link leaveImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see leaveImpl
 * @generated
 */
@JSON(strict = true)
public class leaveModelImpl extends BaseModelImpl<leave> implements leaveModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a leave model instance should use the <code>leave</code> interface instead.
	 */
	public static final String TABLE_NAME = "INTRANET_leave";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"leaveId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"employeeName", Types.VARCHAR}, {"leaveType", Types.VARCHAR},
		{"fromDate", Types.VARCHAR}, {"toDate", Types.VARCHAR},
		{"dayType", Types.VARCHAR}, {"halfType", Types.VARCHAR},
		{"teamEmail", Types.VARCHAR}, {"reason", Types.VARCHAR},
		{"status", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("leaveId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("leaveType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fromDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("toDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dayType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("halfType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("teamEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("reason", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table INTRANET_leave (uuid_ VARCHAR(75) null,leaveId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeName VARCHAR(75) null,leaveType VARCHAR(75) null,fromDate VARCHAR(75) null,toDate VARCHAR(75) null,dayType VARCHAR(75) null,halfType VARCHAR(75) null,teamEmail VARCHAR(75) null,reason VARCHAR(75) null,status VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table INTRANET_leave";

	public static final String ORDER_BY_JPQL = " ORDER BY leave_.leaveId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY INTRANET_leave.leaveId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEENAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FROMDATE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TODATE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LEAVEID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public leaveModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _leaveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLeaveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return leave.class;
	}

	@Override
	public String getModelClassName() {
		return leave.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<leave, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<leave, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<leave, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((leave)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<leave, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<leave, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((leave)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<leave, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<leave, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<leave, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<leave, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<leave, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<leave, Object>>();
		Map<String, BiConsumer<leave, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<leave, ?>>();

		attributeGetterFunctions.put("uuid", leave::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<leave, String>)leave::setUuid);
		attributeGetterFunctions.put("leaveId", leave::getLeaveId);
		attributeSetterBiConsumers.put(
			"leaveId", (BiConsumer<leave, Long>)leave::setLeaveId);
		attributeGetterFunctions.put("groupId", leave::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<leave, Long>)leave::setGroupId);
		attributeGetterFunctions.put("companyId", leave::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<leave, Long>)leave::setCompanyId);
		attributeGetterFunctions.put("userId", leave::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<leave, Long>)leave::setUserId);
		attributeGetterFunctions.put("userName", leave::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<leave, String>)leave::setUserName);
		attributeGetterFunctions.put("createDate", leave::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<leave, Date>)leave::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", leave::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<leave, Date>)leave::setModifiedDate);
		attributeGetterFunctions.put("employeeName", leave::getEmployeeName);
		attributeSetterBiConsumers.put(
			"employeeName", (BiConsumer<leave, String>)leave::setEmployeeName);
		attributeGetterFunctions.put("leaveType", leave::getLeaveType);
		attributeSetterBiConsumers.put(
			"leaveType", (BiConsumer<leave, String>)leave::setLeaveType);
		attributeGetterFunctions.put("fromDate", leave::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate", (BiConsumer<leave, String>)leave::setFromDate);
		attributeGetterFunctions.put("toDate", leave::getToDate);
		attributeSetterBiConsumers.put(
			"toDate", (BiConsumer<leave, String>)leave::setToDate);
		attributeGetterFunctions.put("dayType", leave::getDayType);
		attributeSetterBiConsumers.put(
			"dayType", (BiConsumer<leave, String>)leave::setDayType);
		attributeGetterFunctions.put("halfType", leave::getHalfType);
		attributeSetterBiConsumers.put(
			"halfType", (BiConsumer<leave, String>)leave::setHalfType);
		attributeGetterFunctions.put("teamEmail", leave::getTeamEmail);
		attributeSetterBiConsumers.put(
			"teamEmail", (BiConsumer<leave, String>)leave::setTeamEmail);
		attributeGetterFunctions.put("reason", leave::getReason);
		attributeSetterBiConsumers.put(
			"reason", (BiConsumer<leave, String>)leave::setReason);
		attributeGetterFunctions.put("status", leave::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<leave, String>)leave::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getLeaveId() {
		return _leaveId;
	}

	@Override
	public void setLeaveId(long leaveId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_leaveId = leaveId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getEmployeeName() {
		if (_employeeName == null) {
			return "";
		}
		else {
			return _employeeName;
		}
	}

	@Override
	public void setEmployeeName(String employeeName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeName = employeeName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmployeeName() {
		return getColumnOriginalValue("employeeName");
	}

	@JSON
	@Override
	public String getLeaveType() {
		if (_leaveType == null) {
			return "";
		}
		else {
			return _leaveType;
		}
	}

	@Override
	public void setLeaveType(String leaveType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_leaveType = leaveType;
	}

	@JSON
	@Override
	public String getFromDate() {
		if (_fromDate == null) {
			return "";
		}
		else {
			return _fromDate;
		}
	}

	@Override
	public void setFromDate(String fromDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fromDate = fromDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFromDate() {
		return getColumnOriginalValue("fromDate");
	}

	@JSON
	@Override
	public String getToDate() {
		if (_toDate == null) {
			return "";
		}
		else {
			return _toDate;
		}
	}

	@Override
	public void setToDate(String toDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_toDate = toDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalToDate() {
		return getColumnOriginalValue("toDate");
	}

	@JSON
	@Override
	public String getDayType() {
		if (_dayType == null) {
			return "";
		}
		else {
			return _dayType;
		}
	}

	@Override
	public void setDayType(String dayType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dayType = dayType;
	}

	@JSON
	@Override
	public String getHalfType() {
		if (_halfType == null) {
			return "";
		}
		else {
			return _halfType;
		}
	}

	@Override
	public void setHalfType(String halfType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_halfType = halfType;
	}

	@JSON
	@Override
	public String getTeamEmail() {
		if (_teamEmail == null) {
			return "";
		}
		else {
			return _teamEmail;
		}
	}

	@Override
	public void setTeamEmail(String teamEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_teamEmail = teamEmail;
	}

	@JSON
	@Override
	public String getReason() {
		if (_reason == null) {
			return "";
		}
		else {
			return _reason;
		}
	}

	@Override
	public void setReason(String reason) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reason = reason;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(leave.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), leave.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public leave toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, leave>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		leaveImpl leaveImpl = new leaveImpl();

		leaveImpl.setUuid(getUuid());
		leaveImpl.setLeaveId(getLeaveId());
		leaveImpl.setGroupId(getGroupId());
		leaveImpl.setCompanyId(getCompanyId());
		leaveImpl.setUserId(getUserId());
		leaveImpl.setUserName(getUserName());
		leaveImpl.setCreateDate(getCreateDate());
		leaveImpl.setModifiedDate(getModifiedDate());
		leaveImpl.setEmployeeName(getEmployeeName());
		leaveImpl.setLeaveType(getLeaveType());
		leaveImpl.setFromDate(getFromDate());
		leaveImpl.setToDate(getToDate());
		leaveImpl.setDayType(getDayType());
		leaveImpl.setHalfType(getHalfType());
		leaveImpl.setTeamEmail(getTeamEmail());
		leaveImpl.setReason(getReason());
		leaveImpl.setStatus(getStatus());

		leaveImpl.resetOriginalValues();

		return leaveImpl;
	}

	@Override
	public leave cloneWithOriginalValues() {
		leaveImpl leaveImpl = new leaveImpl();

		leaveImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		leaveImpl.setLeaveId(this.<Long>getColumnOriginalValue("leaveId"));
		leaveImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		leaveImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		leaveImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		leaveImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		leaveImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		leaveImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		leaveImpl.setEmployeeName(
			this.<String>getColumnOriginalValue("employeeName"));
		leaveImpl.setLeaveType(
			this.<String>getColumnOriginalValue("leaveType"));
		leaveImpl.setFromDate(this.<String>getColumnOriginalValue("fromDate"));
		leaveImpl.setToDate(this.<String>getColumnOriginalValue("toDate"));
		leaveImpl.setDayType(this.<String>getColumnOriginalValue("dayType"));
		leaveImpl.setHalfType(this.<String>getColumnOriginalValue("halfType"));
		leaveImpl.setTeamEmail(
			this.<String>getColumnOriginalValue("teamEmail"));
		leaveImpl.setReason(this.<String>getColumnOriginalValue("reason"));
		leaveImpl.setStatus(this.<String>getColumnOriginalValue("status"));

		return leaveImpl;
	}

	@Override
	public int compareTo(leave leave) {
		int value = 0;

		if (getLeaveId() < leave.getLeaveId()) {
			value = -1;
		}
		else if (getLeaveId() > leave.getLeaveId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof leave)) {
			return false;
		}

		leave leave = (leave)object;

		long primaryKey = leave.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<leave> toCacheModel() {
		leaveCacheModel leaveCacheModel = new leaveCacheModel();

		leaveCacheModel.uuid = getUuid();

		String uuid = leaveCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			leaveCacheModel.uuid = null;
		}

		leaveCacheModel.leaveId = getLeaveId();

		leaveCacheModel.groupId = getGroupId();

		leaveCacheModel.companyId = getCompanyId();

		leaveCacheModel.userId = getUserId();

		leaveCacheModel.userName = getUserName();

		String userName = leaveCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			leaveCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			leaveCacheModel.createDate = createDate.getTime();
		}
		else {
			leaveCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			leaveCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			leaveCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		leaveCacheModel.employeeName = getEmployeeName();

		String employeeName = leaveCacheModel.employeeName;

		if ((employeeName != null) && (employeeName.length() == 0)) {
			leaveCacheModel.employeeName = null;
		}

		leaveCacheModel.leaveType = getLeaveType();

		String leaveType = leaveCacheModel.leaveType;

		if ((leaveType != null) && (leaveType.length() == 0)) {
			leaveCacheModel.leaveType = null;
		}

		leaveCacheModel.fromDate = getFromDate();

		String fromDate = leaveCacheModel.fromDate;

		if ((fromDate != null) && (fromDate.length() == 0)) {
			leaveCacheModel.fromDate = null;
		}

		leaveCacheModel.toDate = getToDate();

		String toDate = leaveCacheModel.toDate;

		if ((toDate != null) && (toDate.length() == 0)) {
			leaveCacheModel.toDate = null;
		}

		leaveCacheModel.dayType = getDayType();

		String dayType = leaveCacheModel.dayType;

		if ((dayType != null) && (dayType.length() == 0)) {
			leaveCacheModel.dayType = null;
		}

		leaveCacheModel.halfType = getHalfType();

		String halfType = leaveCacheModel.halfType;

		if ((halfType != null) && (halfType.length() == 0)) {
			leaveCacheModel.halfType = null;
		}

		leaveCacheModel.teamEmail = getTeamEmail();

		String teamEmail = leaveCacheModel.teamEmail;

		if ((teamEmail != null) && (teamEmail.length() == 0)) {
			leaveCacheModel.teamEmail = null;
		}

		leaveCacheModel.reason = getReason();

		String reason = leaveCacheModel.reason;

		if ((reason != null) && (reason.length() == 0)) {
			leaveCacheModel.reason = null;
		}

		leaveCacheModel.status = getStatus();

		String status = leaveCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			leaveCacheModel.status = null;
		}

		return leaveCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<leave, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<leave, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<leave, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((leave)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, leave>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					leave.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _leaveId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _employeeName;
	private String _leaveType;
	private String _fromDate;
	private String _toDate;
	private String _dayType;
	private String _halfType;
	private String _teamEmail;
	private String _reason;
	private String _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<leave, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((leave)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("leaveId", _leaveId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("employeeName", _employeeName);
		_columnOriginalValues.put("leaveType", _leaveType);
		_columnOriginalValues.put("fromDate", _fromDate);
		_columnOriginalValues.put("toDate", _toDate);
		_columnOriginalValues.put("dayType", _dayType);
		_columnOriginalValues.put("halfType", _halfType);
		_columnOriginalValues.put("teamEmail", _teamEmail);
		_columnOriginalValues.put("reason", _reason);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("leaveId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("employeeName", 256L);

		columnBitmasks.put("leaveType", 512L);

		columnBitmasks.put("fromDate", 1024L);

		columnBitmasks.put("toDate", 2048L);

		columnBitmasks.put("dayType", 4096L);

		columnBitmasks.put("halfType", 8192L);

		columnBitmasks.put("teamEmail", 16384L);

		columnBitmasks.put("reason", 32768L);

		columnBitmasks.put("status", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private leave _escapedModel;

}