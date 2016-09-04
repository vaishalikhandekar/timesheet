ALTER TABLE TimeSheetProcess ADD CONSTRAINT TimeSheetProcess PRIMARY KEY(timeSheetProcessID);

ALTER TABLE TimeSheet ADD CONSTRAINT TimeSheet PRIMARY KEY(timeSheetID);

ALTER TABLE TimeSheetLineItem ADD CONSTRAINT TimeSheetLineItem PRIMARY KEY(timeSheetLineItemID);

ALTER TABLE TimeSheetApprovalLevel ADD CONSTRAINT TimeSheetApprovalLevel PRIMARY KEY(timeSheetApprovalLevelID);

ALTER TABLE ProjectTimeSheetProcessLink ADD CONSTRAINT ProjectTimeSheetProcessLink PRIMARY KEY(projectTimeSheetProcessLinkID);