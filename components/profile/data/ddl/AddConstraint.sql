ALTER TABLE Person ADD CONSTRAINT Person PRIMARY KEY(personID);

ALTER TABLE Project ADD CONSTRAINT Project PRIMARY KEY(projectID);

ALTER TABLE ProjectPersonLink ADD CONSTRAINT ProjectPersonLink PRIMARY KEY(projectPersonLinkID);

ALTER TABLE TimeSheetProcess ADD CONSTRAINT TimeSheetProcess PRIMARY KEY(timeSheetProcessID);

ALTER TABLE TimeSheet ADD CONSTRAINT TimeSheet PRIMARY KEY(timeSheetID);

ALTER TABLE TimeSheetLineItem ADD CONSTRAINT TimeSheetLineItem PRIMARY KEY(timeSheetLineItemID);

ALTER TABLE TimeSheetApprovalLevel ADD CONSTRAINT TimeSheetApprovalLevel PRIMARY KEY(timeSheetApprovalLevelID);

ALTER TABLE ProjectTimeSheetProcessLink ADD CONSTRAINT ProjectTimeSheetProcessLink PRIMARY KEY(projectTimeSheetProcessLinkID);