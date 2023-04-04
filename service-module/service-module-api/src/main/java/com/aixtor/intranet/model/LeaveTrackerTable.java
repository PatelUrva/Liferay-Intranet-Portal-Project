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
 * The table class for the &quot;INTRANET_LeaveTracker&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTracker
 * @generated
 */
public class LeaveTrackerTable extends BaseTable<LeaveTrackerTable> {

	public static final LeaveTrackerTable INSTANCE = new LeaveTrackerTable();

	public final Column<LeaveTrackerTable, Long> leaveTrackerId = createColumn(
		"leaveTrackerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LeaveTrackerTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> totalCompen = createColumn(
		"totalCompen", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> bookedCompen = createColumn(
		"bookedCompen", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> totalEarned = createColumn(
		"totalEarned", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> bookedEarned = createColumn(
		"bookedEarned", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> totalFloater = createColumn(
		"totalFloater", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> bookedFloater =
		createColumn(
			"bookedFloater", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> totalUnpaid = createColumn(
		"totalUnpaid", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Integer> bookedUnpaid = createColumn(
		"bookedUnpaid", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LeaveTrackerTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LeaveTrackerTable() {
		super("INTRANET_LeaveTracker", LeaveTrackerTable::new);
	}

}