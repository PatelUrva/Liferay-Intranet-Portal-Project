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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;INTRANET_leave&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see leave
 * @generated
 */
public class leaveTable extends BaseTable<leaveTable> {

	public static final leaveTable INSTANCE = new leaveTable();

	public final Column<leaveTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, Long> leaveId = createColumn(
		"leaveId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<leaveTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<leaveTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<leaveTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<leaveTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> employeeName = createColumn(
		"employeeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> leaveType = createColumn(
		"leaveType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> fromDate = createColumn(
		"fromDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> toDate = createColumn(
		"toDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> dayType = createColumn(
		"dayType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> halfType = createColumn(
		"halfType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> teamEmail = createColumn(
		"teamEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> reason = createColumn(
		"reason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<leaveTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private leaveTable() {
		super("INTRANET_leave", leaveTable::new);
	}

}