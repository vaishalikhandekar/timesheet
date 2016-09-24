
INSERT INTO ProjectTimeSheetProcess(projectTimeSheetProcessID ,	projectID , frequency,    startDay,     minimumApprovalLevelType,   regularDailyHours,  startDate,                         endDate,                           comments, recordStatus, versionNo)
                             VALUES( 4001,	                     2001,       'Weekly',      '1stDay',     'Level2',                 8,                 to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);

                             
INSERT INTO ProjectTimeSheetProcess(projectTimeSheetProcessID ,	projectID , frequency,    startDay,     minimumApprovalLevelType,   regularDailyHours,  startDate,                         endDate,                           comments, recordStatus, versionNo)
                             VALUES( 4002,	                     2003,       'Weekly',    'Monday',     'Level2',                 8,                 to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);

--Timesheet
                             
INSERT INTO TimeSheet(timeSheetID, projectTimeSheetProcessID ,	projectPersonLinkID , totalRegularHours,    totalNoOfHoursWorked,     createdDateTime,                     submittedDateTime,                  timeSheetStatus, approvalLevelType,  startDate,                          endDate, comments, recordStatus, versionNo)
               VALUES( 5001,	             4001,                  3001,                8,                  8,                        to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-90', 'DD-MON-RR'),   'Created',        'Level2',         to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);

               
INSERT INTO TimeSheet(timeSheetID, projectTimeSheetProcessID ,	projectPersonLinkID , totalRegularHours,    totalNoOfHoursWorked,     createdDateTime,                     submittedDateTime,                  timeSheetStatus, approvalLevelType,  startDate,                          endDate, comments, recordStatus, versionNo)
               VALUES( 5002,	             4001,                  3002,                8,                  8,                        to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-90', 'DD-MON-RR'),   'Created',        'Level2',         to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);
               
-- projectTimeSheetProcessID 4002
               
INSERT INTO TimeSheet(timeSheetID, projectTimeSheetProcessID ,	projectPersonLinkID , totalRegularHours,    totalNoOfHoursWorked,     createdDateTime,                     submittedDateTime,                  timeSheetStatus, approvalLevelType,  startDate,                          endDate, comments, recordStatus, versionNo)
               VALUES( 5011,	             4002,                  3003,                8,                  8,                        to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-90', 'DD-MON-RR'),   'Created',        'Level2',         to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);
               
INSERT INTO TimeSheet(timeSheetID, projectTimeSheetProcessID ,	projectPersonLinkID , totalRegularHours,    totalNoOfHoursWorked,     createdDateTime,                     submittedDateTime,                  timeSheetStatus, approvalLevelType,  startDate,                          endDate, comments, recordStatus, versionNo)
               VALUES( 5012,	             4002,                  3007,                8,                  8,                        to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-90', 'DD-MON-RR'),   'Created',        'Level2',         to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);
      
        
--TimeSheetApprovalLevel

INSERT INTO TimeSheetApprovalLevel(timeSheetApprovalLevelID, projectTimeSheetProcessID ,   projectPersonLinkID , approvalLevelType,    approvalCriteria,     		startDate,                          endDate,	comments, recordStatus, versionNo)
                            VALUES( 6001,                    4001,                         3001,                   'Level1',           'EqualtoReg',	to_date('01-Jan-16', 'DD-MON-RR'),  	null,  		null,    'Active',       1);
 
INSERT INTO TimeSheetApprovalLevel(timeSheetApprovalLevelID, projectTimeSheetProcessID ,   projectPersonLinkID , approvalLevelType,    approvalCriteria,     		startDate,                          endDate,	comments, recordStatus, versionNo)
                            VALUES( 6002,                    4001,                         3001,                   'Level2',           'EqualtoReg',    to_date('01-Jan-16', 'DD-MON-RR'),  	null,  		null,    'Active',       1);
  
INSERT INTO TimeSheetApprovalLevel(timeSheetApprovalLevelID, projectTimeSheetProcessID ,   projectPersonLinkID , approvalLevelType,    approvalCriteria,     		startDate,                          endDate,	comments, recordStatus, versionNo)
                            VALUES( 6003,                    4001,                         3001,                   'Level3',           'EqualtoReg',    to_date('01-Jan-16', 'DD-MON-RR'),  	null,  		null,    'Active',       1);
  
INSERT INTO TimeSheetApprovalLevel(timeSheetApprovalLevelID, projectTimeSheetProcessID ,   projectPersonLinkID , approvalLevelType,    approvalCriteria,     		startDate,                          endDate,   comments, recordStatus, versionNo)
                            VALUES( 6004,                    4001,                         3001,                   'Level4',           'EqualtoReg',    to_date('01-Jan-16', 'DD-MON-RR'),  	null,  		null,    'Active',       1);
  
                            
--TimesheetLineItem
                            
INSERT INTO TimeSheetLineItem(timeSheetLineItemID, timeSheetID ,   category,    attendenceDate,                     noOfHoursWorked,      comments,   recordStatus, versionNo)
                            VALUES( 7002,             5001,        null,        to_date('26-Jun-90', 'DD-MON-RR'),  8,                     null,    'Active',       1);
  
                                                        