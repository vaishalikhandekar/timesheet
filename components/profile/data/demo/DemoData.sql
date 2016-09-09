INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 101,	     'Mr',           'Jack',      'V',     'Don', 'jd',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'jd',      101,      'jd',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              


INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 102,	     'Mr',           'Gorje',      'M',     'Clinton', 'gc',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'gc',      102,      'gc',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              


              
INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 103,	     'Mr',           'Dave',      'P',     'White', 'dw',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'dw',      103,      'dw',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              

              
INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 104,	     'Mr',           'Hilary',      'R',     'Black', 'hb',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'hb',      104,      'hb',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              

              
INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 105,	     'Mr',           'Steave',      'R',     'Joseff', 'sj',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'sj',      105,      'sj',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              