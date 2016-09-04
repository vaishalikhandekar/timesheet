CREATE TABLE Person ( 
	personID NUMBER(19,0) NOT NULL,
	title VARCHAR2(30),
	firstName VARCHAR2(15),
	middleName VARCHAR2(30),
	lastName VARCHAR2(15), 
	userName VARCHAR2(15), --NOT NULL,
	gender VARCHAR2(50),
	dateOfBirth DATE, 
	registrationDate DATE,
	startDate DATE,
  	endDate DATE,
	comments VARCHAR2(500),
	recordStatus VARCHAR2(30),	
	versionNo NUMBER(20)
   ); 
   
CREATE TABLE Users(
  userName VARCHAR2(15) NOT NULL,
  personID NUMBER(19,0),
  password VARCHAR2(80),
  accountEnabled VARCHAR2(30),
  loginFailureCount NUMBER(20),
  creationDate DATE,
  passwordExpiryDate DATE,
  userWorkspace VARCHAR2(30),
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  );

   
CREATE TABLE Project (
	projectID NUMBER(19,0) NOT NULL,
	projectName VARCHAR2(30),
	description VARCHAR2(200),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(500),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10)
);

CREATE TABLE ProjectPersonLink (
	projectPersonLinkID NUMBER(19,0) NOT NULL,
	projectID NUMBER(19,0),
	personID NUMBER(19,0),
	role VARCHAR2(10),
	startDate DATE,
    endDate DATE,
	comments VARCHAR2(30),
	recordStatus VARCHAR2(10),	
 	versionNo NUMBER(10)
);

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