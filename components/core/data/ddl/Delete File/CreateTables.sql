CREATE TABLE Employee ( 
	employeeID NUMBER(19,0) NOT NULL,
	title VARCHAR2(30),
	firstName VARCHAR2(15),
	middleName VARCHAR2(30),
	lastName VARCHAR2(15), 
	userName VARCHAR2(15), --NOT NULL,
	gender VARCHAR2(50),
	dateOfBirth DATE, 
	comments VARCHAR2(500),
	registrationDate DATE,
	recordStatus VARCHAR2(30),	
	versionNo NUMBER(20),
	startDate DATE,
  	endDate DATE
   ); 
   
   CREATE TABLE Users(
  userName VARCHAR2(15) NOT NULL,
  employeeID NUMBER(19,0),
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
	name VARCHAR2(30),
	description VARCHAR2(200),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);

CREATE TABLE ProjectEmployeeLink (
	projectEmployeeLinkID NUMBER(19,0) NOT NULL,
	projectID NUMBER(19,0),
	employeeID NUMBER(19,0),
	comment VARCHAR2(30),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);

CREATE TABLE TimeSheetProcess (
	timeSheetProcessID NUMBER(19,0) NOT NULL,
	bilable NUMBER(10),
	frequency VARCHAR2(30),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);

CREATE TABLE TimeSheet (
	timeSheetID NUMBER(19,0) NOT NULL,
	employeeID NUMBER(19,0),
	projectTimeSheetProcessLinkID NUMBER(19,0),
	maximumTotalHours NUMBER(10),
	actualTotalHours NUMBER(10),
	submittedDate DATE,
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);

CREATE TABLE TimeSheetLineItem (
	timeSheetLineItemID NUMBER(19,0) NOT NULL,
	timeSheetID NUMBER(19,0),
	category VARCHAR2(20),
	attendenceDate DATE,
	actualRegularHourWorked NUMBER(10),
	actualOvertimeHourWorked NUMBER(10),
	comment VARCHAR2(20),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);
CREATE TABLE TimeSheetApprovalLevel (
	timeSheetApprovalLevelID NUMBER(19,0) NOT NULL,
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);

CREATE TABLE ProjectTimeSheetProcessLink (
	projectTimeSheetProcessLinkID NUMBER(19,0) NOT NULL,
	timeSheetProcessID NUMBER(19,0),
	projectID NUMBER(19,0),
	recordStatus VARCHAR2(10),	
	versionNo NUMBER(10),
	startDate DATE,
    endDate DATE
);