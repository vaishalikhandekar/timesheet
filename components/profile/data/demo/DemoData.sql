INSERT INTO Person(personID ,	title , 		firstName,  middleName, lastName,   userName, gender,  dateOfBirth,                       registrationDate,               startDate,   endDate, comments, recordStatus, versionNo)
              VALUES( 701,	     'Mr',           'Rahul',      'V',     'Khandekar', 'rk',     'Male', to_date('26-Jun-90', 'DD-MON-RR'), to_date('26-Jun-16', 'DD-MON-RR'), null,       null,           null, 	    'Active',		1);
              
              
INSERT INTO Users(userName ,	personID , password,  accountEnabled, loginFailureCount,   creationDate,               passwordExpiryDate, recordStatus, versionNo)
              VALUES( 'rk',      701,      'rk',            1,             0,  	        to_date('26-Jun-16', 'DD-MON-RR'),  null,              'Active',		1 );              

