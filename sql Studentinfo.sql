create database Studentinfo;
use Studentinfo;
create table Login(username varchar(20),pass varchar(20));
insert into Login(username,pass)values("Manosri","Manosri@21");
use Studentinfo;
create table Details(studentid int,studentname varchar(25),course varchar(20),fees int);
insert into Details(studentid,studentname,course,fees) values(001,"XYZ","cse",1000);