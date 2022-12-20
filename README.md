# Java-with-MySQL-CRUD

FIRST CREAT A DATABASE FILE :

crud.sql

CREATE DATABASE IF NOT EXISTS crud;
USE crud;
 
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  ID int(11) NOT NULL AUTO_INCREMENT,
  NAME varchar(50) DEFAULT NULL,
  AGE int(11) DEFAULT NULL,
  CITY varchar(50) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=4;
 
 
INSERT INTO users (ID,NAME,AGE,CITY) VALUES 
(1,'Santhosh M',21,'Tiruvannamali'),
(2,'Varun KD',23,'Thirunalveli'),
(3,'Dhatchina Moorthy P',22,'Thindivanam');

------------------------------------------
------------------------------------------

Output:

MySQL Java CRUD Operation
1. Insert
2. Update
3. Delete
4. Select
5. Exit
Enter a choice: 1
-----------------------------------------
1. Insert New Data
Enter Name : 
Sam
Enter Age : 
21
Enter City : 
Erode
Data Insert Success
-----------------------------------------
MySQL Java CRUD Operation
1. Insert
2. Update
3. Delete
4. Select
5. Exit
Enter a choice: 4
-----------------------------------------
4. Print all Records
1 siva 12 salem 
2 pooja 23 Hosur 
3 priya 23 chennai 
4 Sam 21 Erode 
-----------------------------------------
MySQL Java CRUD Operation
1. Insert
2. Update
3. Delete
4. Select
5. Exit
Enter a choice: 2
-----------------------------------------
2. Updating a Data
Enter ID : 
3
Enter Name : 
Priya
Enter Age : 
21
Enter City : 
Chennai
Data Update Success
-----------------------------------------
MySQL Java CRUD Operation
1. Insert
2. Update
3. Delete
4. Select
5. Exit
Enter a choice: 3
-----------------------------------------
3. Deleting a Data
Enter ID : 
2
Data Deleted Success
-----------------------------------------
MySQL Java CRUD Operation
1. Insert
2. Update
3. Delete
4. Select
5. Exit
Enter a choice: 4
-----------------------------------------
4. Print all Records
1 siva 12 salem 
3 Priya 21 Chennai 
4 Sam 21 Erode 
-----------------------------------------
MySQL Java CRUD Operation
1. Insert
2. Update
3. Delete
4. Select
5. Exit
Enter a choice: 5
-----------------------------------------
Thank You
