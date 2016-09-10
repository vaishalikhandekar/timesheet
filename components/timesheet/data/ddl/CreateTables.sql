 

CREATE TABLE TimeSheetProcess (
	timeSheetProcessID NUMBER(19,0) NOT NULL,
	frequency VARCHAR2(30),
	startDay VARCHAR2(20),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE ProjectTimeSheetProcess (
	projectTimeSheetProcessID NUMBER(19,0) NOT NULL,
	projectID NUMBER(19,0),
	frequency VARCHAR2(30),
	startDay VARCHAR2(20),
	minimumApprovalLevelType VARCHAR2(20),
	regularDailyHours NUMBER(10),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE TimeSheetApprovalLevel (
	timeSheetApprovalLevelID NUMBER(19,0) NOT NULL,
	projectTimeSheetProcessID NUMBER(19,0),
	projectPersonLinkID NUMBER(19,0),
	approvalLevelType VARCHAR2(10),
	approvalCriteria VARCHAR2(10),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE TimeSheet (
	timeSheetID NUMBER(19,0) NOT NULL,
	projectTimeSheetProcessID NUMBER(19,0),
	projectPersonLinkID NUMBER(19,0),
	totalRegularHours NUMBER(10),
	totalNoOfHoursWorked NUMBER(10),
	createdDateTime TIMESTAMP,
	submittedDateTime TIMESTAMP,
	timeSheetStatus VARCHAR2(10),
	approvalLevelType VARCHAR2(10),	
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
	noOfHoursWorked NUMBER(10),
	comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE TimeSheetApproval (
	timeSheetApprovalID NUMBER(19,0) NOT NULL,
	timeSheetApprovalLevelID NUMBER(19,0),
	timeSheetID NUMBER(19,0),
	approvalStatus VARCHAR2(10), -- Requested, Approved, Rejected
	creationDateTime TIMESTAMP,
	approvalDateTime TIMESTAMP,
	rejectedDateTime TIMESTAMP,
    comments VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);