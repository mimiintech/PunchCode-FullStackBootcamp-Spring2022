--DATABASE: Stanford University Spring 2022 Classes******* SIGN UP NOW!*************************************************
--It's your freshman year at Stanford! Enroll in your classes!**********************************************************

BEGIN TRANSACTION;

---Removes Tables If They're Existent--*********************************************************************************
DROP TABLE IF EXISTS member_group;
DROP TABLE IF EXISTS interest_event;
DROP TABLE IF EXISTS member_info;
DROP TABLE IF EXISTS interest_group;
DROP TABLE IF EXISTS event_info;


---Create Table for Member--********************************************************************************************

CREATE TABLE member_info(
    member_id serial NOT NULL ,
    last_name varchar(40) NOT NULL,
    first_name varchar(40) NOT NULL,
    email   varchar(40)  NOT NULL,
    phone_number   varchar(15),
    birthday    date,
    reminder    boolean     NOT NULL,
    CONSTRAINT pk_member_id PRIMARY KEY (member_id)
    );

---Create Table for Interest Group--************************************************************************************

CREATE TABLE interest_group(
    group_id serial NOT NULL,
    group_name  varchar(40)   NOT NULL UNIQUE,
    member_count  int,
    CONSTRAINT pk_group_id PRIMARY KEY (group_id)
    );

---Create Table for Event--*********************************************************************************************

CREATE TABLE event_info(
    event_id serial NOT NULL,
    event_name  varchar(15)   NOT NULL UNIQUE,
    description varchar(100)   NOT NULL,
    start_date  date   NOT NULL,
    duration    int     NOT NULL,
    group_running_event varchar(30)   NOT NULL,
    member_count    int            NOT NULL,
	CHECK (duration >= 30),
    CONSTRAINT pk_event_id PRIMARY KEY (event_id)
    );


--Create Table for Member & Event***************************************************************************************

CREATE TABLE member_group(
   member_id serial NOT NULL ,
   group_id serial  NOT NULL,
    CONSTRAINT pk_member_group PRIMARY KEY (member_id, group_id),
    CONSTRAINT fk_member_group_member_id FOREIGN KEY (member_id) REFERENCES member_info(member_id),
	CONSTRAINT fk_member_group_group_id FOREIGN KEY (group_id) REFERENCES  interest_group(group_id)
);

--Create Table for Interest Group & Event*******************************************************************************

CREATE TABLE interest_event(
     group_id serial NOT NULL,
     event_id serial NOT NULL,
        CONSTRAINT pk_interest_event PRIMARY KEY (group_id, event_id),
		CONSTRAINT fk_interest_event_group_id FOREIGN KEY (group_id) REFERENCES interest_group(group_id),
        CONSTRAINT fk_interest_event_event_id FOREIGN KEY (event_id) REFERENCES event_info(event_id)
);


---Insert Values for Member--*******************************************************************************************

INSERT INTO member_info(last_name, first_name, email, phone_number, birthday, reminder) VALUES
   ('P', 'Der', 'wDer12@stanford.edu', '702-416-7756', '2004-02-15', TRUE),
   ('B', 'Justin', 'bJustin19@stanford.edu', '702-512-5509', '2004-05-18', FALSE),
   ('D', 'Sheila', 'dSheila11@stanford.edu', '702-333-999', '2004-07-19', FALSE),
   ('S', 'Ethan', 'sEthan10@stanford.edu', '702-437-567', '2004-06-22', TRUE),
   ('A', 'Nawal', 'aNawal17@stanford.edu', '702-467-897', '2004-08-12', FALSE),
   ('S', 'Michelle', 'sMichelle67@stanford.edu', '702-436-293', '2004-04-11', TRUE),
   ('N', 'Zachary', 'nZachary46@stanford.edu', '702-109-298', '2004-06-20', FALSE),
   ('V', 'Rodrigo', 'vRodrigo39@stanford.edu', '702-385-666', '2004-07-18', TRUE);

---Insert Values for Table Interest Group--*****************************************************************************

 INSERT INTO interest_group  (group_name, member_count) VALUES
    ('Computer Science 101 Students', 100),
    ('Calculus 101 Students', 200),
    ('Biology 101 Students', 300),
    ('Literature 101 Students', 400);

--Insert Values for Table Event*****************************************************************************************

 INSERT INTO event_info(event_name,  description, start_date, duration, group_running_event, member_count) VALUES
    ('Computer Class', 'Intro to Computer Science 101', '2022-01-01', 60, 'Stanford University', 100),
    ('Math Class', 'Intro to Calculus 101', '2022-01-01', 60, 'Stanford University', 200),
    ('ScienceClass', 'Intro to Biology 101', '2022-01-01', 60, 'Stanford University', 300),
    ('EnglishClass', 'Intro to Literature 101', '2022-01-01', 60, 'Stanford University', 400);

--Insert Values for Member & Event***************************************************************************************

 INSERT INTO member_group (member_id, group_id) VALUES (1,1);
 INSERT INTO member_group (member_id, group_id) VALUES (2,2);
 INSERT INTO member_group (member_id, group_id) VALUES (3,3);
 INSERT INTO member_group (member_id, group_id) VALUES (4,4);

--Insert Values for Interest Group & Event*******************************************************************************

 INSERT INTO interest_event (group_id, event_id)  VALUES (1,1);
 INSERT INTO interest_event (group_id, event_id)  VALUES (2,2);
 INSERT INTO interest_event (group_id, event_id)  VALUES (3,3);
 INSERT INTO interest_event (group_id, event_id)  VALUES (4,4);
 
-- ROLLBACK;
COMMIT;







