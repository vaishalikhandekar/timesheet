
CREATE TABLE AuditTrail(	
	tableName  VARCHAR2(30) NOT NULL,
	operationType VARCHAR2(35),
	userName VARCHAR2(35),
	timeEntered timestamp(6),
	relatedID NUMBER(19,0) NOT NULL,
	transactionType VARCHAR2(35)
);
