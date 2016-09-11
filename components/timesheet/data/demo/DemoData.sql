
INSERT INTO ProjectTimeSheetProcess(projectTimeSheetProcessID ,	projectID , frequency,    startDay,     minimumApprovalLevelType,   regularDailyHours,  startDate,                         endDate,                           comments, recordStatus, versionNo)
                             VALUES( 4001,	                     2001,       'Monthly',      '1stDay',     'Level1',                 8,                 to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);

                             
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
               