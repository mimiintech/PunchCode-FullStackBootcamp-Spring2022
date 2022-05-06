--  create a puppy table
-- puppy_id, puppy_name, weight, gender, breed, paper_trained

DROP TABLE IF EXISTS puppy;

CREATE TABLE puppy (
    puppy_id SERIAL PRIMARY KEY,
    puppy_name varchar(30),
    weight int,
    sex varchar(10),
    breed varchar(50),
    paper_trained boolean,
    dog_fact varchar(1000)
);

INSERT INTO puppy (puppy_name, weight, sex, breed, paper_trained) VALUES ('Snoopy', 25, 'male', 'Beagle', true);
INSERT INTO puppy (puppy_name, weight, sex, breed, paper_trained) VALUES ('Clifford', 2500, 'male', 'Red Labrador', true);
INSERT INTO puppy (puppy_name, weight, sex, breed, paper_trained) VALUES ('Katy', 45, 'female', 'Pit Mix', false);
INSERT INTO puppy (puppy_name, weight, sex, breed, paper_trained) VALUES ('Proton', 35, 'male', 'Corgi', true);
INSERT INTO puppy (puppy_name, weight, sex, breed, paper_trained) VALUES ('Webster', 102, 'male', 'Yellow Labrador', false);

SELECT * FROM puppy;