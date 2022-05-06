BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, forum, feedback CASCADE;

CREATE TABLE users (
	user_id serial NOT NULL,
	username varchar(500) NOT NULL,
    password_hash varchar(500) NOT NULL,
    role varchar(500) NOT NULL,
	CONSTRAINT PK_users PRIMARY KEY (user_id)
);

INSERT INTO users(username, password_hash, role) VALUES
       ('stephyyylove', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_ADMIN');

INSERT INTO users(username, password_hash, role) VALUES
       ('michellesilva', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');

INSERT INTO users(username, password_hash, role) VALUES
       ('silvahectorh', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');

	   INSERT INTO users(username, password_hash, role)
	   VALUES
	   ('bobm74458', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');


 --Be able to read, create, update & remove users
CREATE TABLE forum (
	forum_id serial,
	user_id int NOT NULL,
	question varchar(500),
 	CONSTRAINT PK_forum PRIMARY KEY (forum_id),
	CONSTRAINT FK_forum_users FOREIGN KEY (user_id ) REFERENCES users(user_id )
);

 INSERT INTO forum(user_id, question) VALUES
   	    (2, 'What is the difference between Symmetric and Asymmetric encryption?');

 INSERT INTO forum(user_id, question) VALUES
     	(3, 'What is Cryptography?');

 INSERT INTO forum(user_id, question) VALUES
     	(4, 'What is the difference between IDS and IPS?');


 --Be able to read, create, update & remove questions

CREATE TABLE feedback (
    feedback_id serial,
    forum_id int NOT NULL,
    user_id  int NOT NULL,
    answer varchar(500),
    CONSTRAINT PK_feedback PRIMARY KEY (feedback_id),
    CONSTRAINT FK_feedback_forum FOREIGN KEY (forum_id) REFERENCES forum(forum_id),
    CONSTRAINT FK_feedback_users FOREIGN KEY (user_id ) REFERENCES users(user_id )
);


 INSERT INTO feedback(forum_id, user_id , answer) VALUES
	(1, 2, 'Symmetric means it has the same key for encryption and decryption, while Asymmetric has different keys.');


  INSERT INTO feedback(forum_id, user_id , answer) VALUES
	(2, 3, 'Cryptography is the practice and study of techniques for securing information and communication mainly to protect the data from third parties that the data is not intended for.');


  INSERT INTO feedback(forum_id, user_id , answer) VALUES
    (3, 4, 'Intrusion Detection System detects intrusions and Intrusion Prevention System takes the action to prevent the intrusion.');

 --Be able to read, create, update & remove answers


COMMIT;








































