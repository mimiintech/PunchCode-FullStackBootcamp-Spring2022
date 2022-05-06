-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)


--`INSERT` statement adds rows of data (records) to a database table


INSERT INTO movie_actor (actor_id, movie_id)

VALUES ((SELECT person_id  FROM  person WHERE person_name = 'Eric Stoltz'),
		(SELECT movie_id FROM movie WHERE title = 'Back to the Future'));

