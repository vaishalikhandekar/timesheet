 
CREATE TABLE Project (
	projectID NUMBER(19,0) NOT NULL,
	projectName VARCHAR2(30),
	acronym VARCHAR2(30),
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





