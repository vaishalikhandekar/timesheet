INSERT INTO Project(projectID ,	projectName, 		acronym, 	description,           startDate,                          endDate,                            comments, recordStatus, versionNo)
              VALUES( 2001,	     'HTML Project',    'HTMLP',	'HTML Project Desc',   to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);

              
INSERT INTO ProjectPersonLink(projectPersonLinkID ,	projectID ,  personID,    role,          startDate,                          endDate,                            comments, recordStatus, versionNo)
             		   VALUES( 3001,	                2001,                1001,  'Developer',    to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);
              


INSERT INTO Project(projectID ,	projectName , 		acronym, 	description,           startDate,                          endDate,                            comments, recordStatus, versionNo)
              VALUES( 2002,	     'JAVA Project',    'JAVAP',	'JAVA Project Desc',   to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);

              
INSERT INTO ProjectPersonLink(projectPersonLinkID ,	projectID ,  personID,    role,          startDate,                          endDate,                            comments, recordStatus, versionNo)
             		   VALUES( 3002,	                2002,                1001,  'Developer',    to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);
              

INSERT INTO Project(projectID ,	projectName , 		acronym, 	description,           startDate,                          endDate,                            comments, recordStatus, versionNo)
              VALUES( 2003,	     'Demo Project',    'DEMOP',	'Demo Project Desc',   to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);

              
INSERT INTO ProjectPersonLink(projectPersonLinkID ,	projectID ,  personID,    role,          startDate,                          endDate,                            comments, recordStatus, versionNo)
 		   				VALUES( 3003,	           	2003,           1002,  'Developer',    to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);
              
INSERT INTO ProjectPersonLink(projectPersonLinkID ,	projectID ,  personID,    role,          startDate,                          endDate,                            comments, recordStatus, versionNo)
             		   VALUES( 3007,	            2003,        	1003,  'Developer',    to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);
              

             		   
INSERT INTO Project(projectID ,	projectName , 		acronym, 	description,           startDate,                          endDate,                            comments, recordStatus, versionNo)
              VALUES( 2004,	     'House Project',   'HOUSEP',	'House Project Desc',   to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);

              
INSERT INTO ProjectPersonLink(projectPersonLinkID ,	projectID ,  personID,    role,          startDate,                          endDate,                            comments, recordStatus, versionNo)
             		   VALUES( 3004,	                2004,                1003,  'Developer',    to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);
              
INSERT INTO ProjectPersonLink(projectPersonLinkID ,	projectID ,  personID,    role,          startDate,                          endDate,                            comments, recordStatus, versionNo)
             		   VALUES( 3005,	                2004,                1005,  'Developer',    to_date('26-Jun-90', 'DD-MON-RR'),   to_date('26-Jun-16', 'DD-MON-RR'),  null,     'Active',		1);
              