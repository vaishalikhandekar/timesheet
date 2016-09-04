 

CREATE TABLE TimeSheetProcess (
	timeSheetProcessID NUMBER(19,0) NOT NULL,
	bilable NUMBER(10),
	frequency VARCHAR2(30),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE TimeSheet (
	timeSheetID NUMBER(19,0) NOT NULL,
	projectTimeSheetProcessLinkID NUMBER(19,0),
	totalRegularHours NUMBER(10),
	totalActualHours NUMBER(10),
	submittedDate DATE,
	timeSheetStatus VARCHAR2(10),
	startDate DATE,
    endDate DATE,
    comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE TimeSheetLineItem (
	timeSheetLineItemID NUMBER(19,0) NOT NULL,
	timeSheetID NUMBER(19,0),
	category VARCHAR2(20),
	attendenceDate DATE,
	actualRegularHoursWorked NUMBER(10),
	actualOvertimeHoursWorked NUMBER(10),
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);
CREATE TABLE TimeSheetApprovalLevel (
	timeSheetApprovalLevelID NUMBER(19,0) NOT NULL,
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE ProjectTimeSheetProcessLink (
	projectTimeSheetProcessLinkID NUMBER(19,0) NOT NULL,
	timeSheetProcessID NUMBER(19,0),
	projectID NUMBER(19,0),
	regularHours NUMBER(10),
	startDay VARCHAR2(20),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);