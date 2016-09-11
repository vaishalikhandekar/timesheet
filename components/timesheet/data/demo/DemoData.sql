
INSERT INTO ProjectTimeSheetProcess(projectTimeSheetProcessID ,	projectID , frequency,    startDay,     minimumApprovalLevelType,   regularDailyHours,  startDate,                         endDate,                           comments, recordStatus, versionNo)
                             VALUES( 4001,	                     2001,       'Monthly',      '1stDay',     'Level1',                 8,                 to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);

                             
INSERT INTO ProjectTimeSheetProcess(projectTimeSheetProcessID ,	projectID , frequency,    startDay,     minimumApprovalLevelType,   regularDailyHours,  startDate,                         endDate,                           comments, recordStatus, versionNo)
                             VALUES( 4002,	                     2003,       'Weekly',    'Monday',     'Level2',                 8,                 to_date('26-Jun-90', 'DD-MON-RR'),  to_date('26-Jun-16', 'DD-MON-RR'), null,    'Active',		1);