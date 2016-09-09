
drop table if exists student_class_relationship; 
 drop table if exists major_class_relationship;
 drop table if exists assignment; 
 drop table if exists class;
 drop table if exists student; 
  drop table if exists instructor; 
 drop table if exists major; 
 
 
 
 
 
 CREATE TABLE major ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  major_description varchar(30) DEFAULT NULL, 
  min_SAT int(4) DEFAULT NULL, 
  PRIMARY KEY (id) ); 
 
 
 
 
 
 
 
 
 insert major (major_description, min_SAT) values('General Business', 800); 
 insert major (major_description, min_SAT) values('Accounting', 1000); 
 insert major (major_description, min_SAT) values('Finance', 1100); 
 insert major (major_description, min_SAT) values('Math', 1300); 
 insert major (major_description, min_SAT) values('Engineering', 1350); 
 insert major (major_description, min_SAT) values('Education', 900); 
 insert major (major_description, min_SAT) values('General Studies', 500); 
 
 
 
 
 
 
 CREATE TABLE instructor ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  first_name varchar(30) DEFAULT NULL, 
  last_name varchar(30) DEFAULT NULL,
  major_id int(11) not null, 
  yrs_exp int(11) DEFAULT NULL, 
  has_tenure tinyint(1) DEFAULT NULL,
  foreign key(major_id) references major(id), 
  PRIMARY KEY (id) 
  ); 
 
 
 
 
 
 
 INSERT instructor VALUES (10,'Joe','Downey',1,10,1); 
 INSERT instructor VALUES (20,'Jane','Jones',2,6,1); 
 INSERT instructor VALUES (30,'Bill','Tensi',3,3,0); 
 INSERT instructor VALUES (40,'Sherry','Nagy',5,14,1); 
 INSERT instructor VALUES (50,'Frank','Schell',7,23,1); 
 INSERT instructor VALUES (60,'Michelle','Bellman',6,35,1); 
 INSERT instructor VALUES (70,'George','Hunt',4,2,0); 
 INSERT instructor VALUES (80,'Amy','Brock',2,7,0); 
 INSERT instructor VALUES (90,'Larry','Seger',1,11,1); 
 INSERT instructor VALUES (100,'Kathy','Miller',5,21,1); 
 
 

 
 
 
 
 CREATE TABLE class ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  subject varchar(20) DEFAULT NULL, 
  section int DEFAULT NULL, 
  instructor_id int(11) DEFAULT NULL, 
  PRIMARY KEY (id), 
  KEY instructor_id (instructor_id), 
  CONSTRAINT FOREIGN KEY (instructor_id) REFERENCES instructor 
  (id) 
 ); 
 

 
 
 
 
 INSERT class (subject,section,instructor_id) VALUES('English',101,10); 
 INSERT class (subject,section,instructor_id) VALUES('English',102,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('English',103,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('English',201,10); 
 INSERT class (subject,section,instructor_id) VALUES('English',202,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('English',203,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('English',301,10); 
 INSERT class (subject,section,instructor_id) VALUES('English',302,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('English',303,NULL); 
 -- Math 
 INSERT class (subject,section,instructor_id) VALUES('Math',201,50); 
 INSERT class (subject,section,instructor_id) VALUES('Math',202,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('Math',203,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('Math',204,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('Math',401,50); 
 INSERT class (subject,section,instructor_id) VALUES('Math',402,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('Math',403,NULL); 
 INSERT class (subject,section,instructor_id) VALUES('Math',404,NULL); 
 -- History 
 INSERT class (subject,section,instructor_id) VALUES('History',101,80); 
 INSERT class (subject,section,instructor_id) VALUES('History',201,80); 
 INSERT class (subject,section,instructor_id) VALUES('History',301,80); 
 -- Computer Science 
 INSERT class (subject,section,instructor_id) VALUES('Computer Science',311,40); 
 INSERT class (subject,section,instructor_id) VALUES('Computer Science',312,40); 
 INSERT class (subject,section,instructor_id) VALUES('Computer Science',313,40); 
 INSERT class (subject,section,instructor_id) VALUES('Computer Science',441,40); 
 INSERT class (subject,section,instructor_id) VALUES('Computer Science',442,40); 
 INSERT class (subject,section,instructor_id) VALUES('Computer Science',443,40); 
 -- Psychology 
 INSERT class (subject,section,instructor_id) VALUES('Psychology',101,20); 
 INSERT class (subject,section,instructor_id) VALUES('Psychology',102,20); 
 INSERT class (subject,section,instructor_id) VALUES('Psychology',231,20); 
 INSERT class (subject,section,instructor_id) VALUES('Psychology',232,20); 
 -- Education 
 INSERT class (subject,section,instructor_id) VALUES('Education',221,60); 
 INSERT class (subject,section,instructor_id) VALUES('Education',222,60); 
 INSERT class (subject,section,instructor_id) VALUES('Education',223,60); 
 INSERT class (subject,section,instructor_id) VALUES('Education',351,70); 
 INSERT class (subject,section,instructor_id) VALUES('Education',352,70); 
 INSERT class (subject,section,instructor_id) VALUES('Education',353,70); 
 

 
 
 CREATE TABLE major_class_relationship ( 
 id int(11) NOT NULL AUTO_INCREMENT, 
 major_id int(11) NOT NULL, 
 class_id int(11) NOT NULL, 
 PRIMARY KEY (id), 
 KEY major_id (major_id), 
 KEY class_id (class_id), 
 CONSTRAINT major_class_relationship_ibfk_1 FOREIGN KEY (major_id) 
 REFERENCES major (id), 
 CONSTRAINT major_class_relationship_ibfk_2 FOREIGN KEY (class_id) 
 REFERENCES class (id) 
 ); 
 
 
 
 
 create table student ( 
 id int primary key, 
 

 first_name varchar(30) not null, 
 
 
 last_name varchar(30) not null, 
 

 years_of_experience int not null 
 ); 
 
 
 insert student values(100,'Eric','Ephram',2); 
 
 
 insert student values(110,'Greg','Gould',6); 
 

 insert student values(120,'Adam','Ant',5); 
 

 insert student values(130,'Howard','Hess',1); 
 
 
 insert student values(140,'Charles','Caldwell',7); 
 
 
 insert student values(150,'James','Joyce',9); 
 
 insert student values(160,'Doug','Dumas',13); 
 
 
 insert student values(170,'Kevin','Kraft',3); 

 
 insert student values(180,'Frank','Fountain',8); 
 
 
 insert student values(190,'Brian','Biggs',4); 
 
 
 
 
 CREATE TABLE student_class_relationship ( 
 id int(11) NOT NULL AUTO_INCREMENT, 
student_id int(11) NOT NULL, 
 class_id int(11) NOT NULL, 
 PRIMARY KEY (id), 
 CONSTRAINT student_class_relationship_ibfk_1 FOREIGN KEY (student_id) 
 REFERENCES student (id), 
 CONSTRAINT student_class_relationship_ibfk_2 FOREIGN KEY (class_id) 
 REFERENCES class (id)); 
 
 
 
 
 insert student_class_relationship (student_id,class_id) values(100,36); 
 insert student_class_relationship (student_id,class_id) values(120,35); 
 insert student_class_relationship (student_id,class_id) values(120,34); 
 insert student_class_relationship (student_id,class_id) values(130,17); 
 insert student_class_relationship (student_id,class_id) values(140,26); 
 insert student_class_relationship (student_id,class_id) values(150,3); 
 insert student_class_relationship (student_id,class_id) values(190,4); 
 insert student_class_relationship (student_id,class_id) values(180,16); 
 insert student_class_relationship (student_id,class_id) values(140,1); 
 insert student_class_relationship (student_id,class_id) values(150,3); 
 insert student_class_relationship (student_id,class_id) values(170,4); 
 
 
 
 
 
 
 
 alter table student add column gpa decimal(5,2) not null; 
 alter table student add sat int(11); 
 alter table student add column major_id int; 
 alter table student add foreign key (major_id) references major(id); 
alter table student drop column years_of_experience; 
 
 
 
 
 
 
 update student set gpa=4.0 where id = 100; 
 update student set gpa=3.3 where id = 110; 
 update student set gpa=2.0 where id = 120; 
 update student set gpa=4.0 where id = 130; 
 update student set gpa=3.4 where id = 140; 
 update student set gpa=4.0 where id = 150; 
 update student set gpa=4.0 where id = 160; 
 update student set gpa=3.5 where id = 170; 
 update student set gpa=2.7 where id = 180; 
 update student set gpa=4.0 where id = 190; 
 
 
 update student set sat=1400 where id = 100; 
 update student set sat=1300 where id = 110; 
 update student set sat=1200 where id = 120; 
 update student set sat=1190 where id = 130; 
 update student set sat=1090 where id = 140; 
update student set sat=1000 where id = 150; 
 update student set sat=700 where id = 160; 
 update student set sat=900 where id = 170; 
 update student set sat=1450 where id = 180; 
 update student set sat=1600 where id = 190; 
 
 
 update student set major_id=1 where id = 100; 
 update student set major_id=2 where id = 110; 
 update student set major_id=3 where id = 120; 
 update student set major_id=4 where id = 130; 
 update student set major_id=5 where id = 140; 
 update student set major_id=6 where id = 150; 
 update student set major_id=7 where id = 160; 
 update student set major_id=1 where id = 170; 
 update student set major_id=2 where id = 180; 
 update student set major_id=3 where id = 190; 
 
 
 
 
 CREATE TABLE assignment ( 
   id int(11) NOT NULL auto_increment, 
   student_id int(11) NOT NULL, 
   assignment_nbr int(11) NOT NULL, 
   grade_id int(11) DEFAULT NULL, 
   class_id int(11) DEFAULT NULL, 
   PRIMARY KEY (id), 
   KEY student_id_idx (student_id), 
   KEY grade_id (grade_id), 
   KEY class_id (class_id), 
   CONSTRAINT assignment_ibfk_1 FOREIGN KEY (student_id) 
   REFERENCES student (id), 
   CONSTRAINT assignment_ibfk_3 FOREIGN KEY (class_id) 
   REFERENCES class (id)); 
 
 
 
 

 
 insert assignment values (1,100,1000,2,12); 
 insert assignment values (2,110,1000,3,12); 
 insert assignment values (3,170,2000,4,4); 
 insert assignment values (4,140,2000,1,4); 
 insert assignment values (5,120,3000,4,7); 
 
 
