-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'

--List the Number of Movies
--Include All Georges
--Also Georges NOT in any movies
--Order Alphabetical

SELECT person.person_name, COUNT(movie_actor.movie_id) AS num_of_movies

FROM person

LEFT JOIN movie_actor      ON movie_actor.actor_id = person.person_id

WHERE person.person_name LIKE 'George %'

GROUP BY person.person_name, person.person_id

ORDER BY person_name;



