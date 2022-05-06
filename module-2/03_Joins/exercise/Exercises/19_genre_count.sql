-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).


--Genre Name
--Number of Movies in Each Genre


SELECT  genre.genre_name, COUNT(movie_genre.movie_id) AS num_of_movies

FROM    movie_genre

JOIN    genre       ON genre.genre_id = movie_genre.genre_id

JOIN    movie    ON movie.movie_id = movie_genre.movie_id

GROUP BY genre.genre_name;

