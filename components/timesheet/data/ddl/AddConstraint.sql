ALTER TABLE TimeSheetProcess ADD CONSTRAINT TimeSheetProcess PRIMARY KEY(timeSheetProcessID);

ALTER TABLE TimeSheetApprovalLevel ADD CONSTRAINT TimeSheetApprovalLevel PRIMARY KEY(timeSheetApprovalLevelID);

ALTER TABLE ProjectTimeSheetProcess ADD CONSTRAINT ProjectTimeSheetProcess PRIMARY KEY(projectTimeSheetProcessID);

ALTER TABLE TimeSheet ADD CONSTRAINT TimeSheet PRIMARY KEY(timeSheetID);

ALTER TABLE TimeSheetLineItem ADD CONSTRAINT TimeSheetLineItem PRIMARY KEY(timeSheetLineItemID);

ALTER TABLE TimeSheetApproval ADD CONSTRAINT TimeSheetApproval PRIMARY KEY(timeSheetApprovalID);