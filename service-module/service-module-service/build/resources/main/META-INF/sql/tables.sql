create table INTRANET_LeaveTracker (
	leaveTrackerId LONG not null primary key,
	userId LONG,
	totalCompen INTEGER,
	bookedCompen INTEGER,
	totalEarned INTEGER,
	bookedEarned INTEGER,
	totalFloater INTEGER,
	bookedFloater INTEGER,
	totalUnpaid INTEGER,
	bookedUnpaid INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG,
	groupId LONG,
	companyId LONG
);

create table INTRANET_leave (
	uuid_ VARCHAR(75) null,
	leaveId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	employeeName VARCHAR(75) null,
	leaveType VARCHAR(75) null,
	fromDate VARCHAR(75) null,
	toDate VARCHAR(75) null,
	dayType VARCHAR(75) null,
	halfType VARCHAR(75) null,
	teamEmail VARCHAR(75) null,
	reason VARCHAR(75) null,
	status VARCHAR(75) null
);