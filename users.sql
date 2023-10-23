CREATE TABLE users (
  uId int NOT NULL AUTO_INCREMENT,
  fName varchar(100) DEFAULT NULL,
  lName varchar(100) DEFAULT NULL,
  uGen varchar(10) DEFAULT NULL,
  uDOB varchar(20) DEFAULT NULL,
  uEmail varchar(100) DEFAULT NULL,
  uMember varchar(100) DEFAULT NULL,
  uName varchar(100) DEFAULT NULL,
  uPass varchar(20) DEFAULT NULL,
  uCountry varchar(100) DEFAULT NULL,
  uCity varchar(100) DEFAULT NULL,
  PRIMARY KEY (uId)
);