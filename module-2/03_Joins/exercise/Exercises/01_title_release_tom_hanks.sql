-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)

SELECT movie.title, movie.release_date

FROM movie

JOIN movie_actor        on movie_actor.movie_id = movie.movie_id

JOIN person             on movie_actor.actor_id = person.person_id

WHERE person.person_name = 'Tom Hanks';
