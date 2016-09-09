CREATE TABLE Person ( 
	personID NUMBER(19,0) NOT NULL,
	title VARCHAR2(30),
	firstName VARCHAR2(15),
	middleName VARCHAR2(30),
	lastName VARCHAR2(15), 
	userName VARCHAR2(15), 
	gender VARCHAR2(50),
	emailAddress VARCHAR2(20),
	phoneNumber NUMBER(20),
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
  recordStatus VARCHAR2(30),
  versionNo NUMBER(20)
  );

   
