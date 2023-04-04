create index IX_D59E3B21 on INTRANET_LeaveTracker (userId);

create index IX_A10FEE4A on INTRANET_leave (employeeName[$COLUMN_LENGTH:75$]);
create index IX_5828229 on INTRANET_leave (fromDate[$COLUMN_LENGTH:75$]);
create index IX_24C56BFA on INTRANET_leave (toDate[$COLUMN_LENGTH:75$]);
create index IX_AA2203B1 on INTRANET_leave (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7F09C273 on INTRANET_leave (uuid_[$COLUMN_LENGTH:75$], groupId);