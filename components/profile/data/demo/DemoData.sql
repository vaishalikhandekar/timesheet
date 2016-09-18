INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  emailAddress, 	phoneNumber,	dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 1001,	     'Mr',           'Jack',      'V',     'Don', 'jd',     'Male', 	'jack@gmail.com',	'1231231234', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'jd',      1001,      'jd',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              


INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 1002,	     'Mr',           'Gorje',      'M',     'Clinton', 'gc',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'gc',      1002,      'gc',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              


              
INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 1003,	     'Mr',           'Dave',      'P',     'White', 'dw',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'dw',      1003,      'dw',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              

              
INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 1004,	     'Mr',           'Hilary',      'R',     'Black', 'hb',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'hb',      1004,      'hb',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              

              
INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 1005,	     'Mr',           'Steave',      'R',     'Joseff', 'sj',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'sj',      1005,      'sj',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              