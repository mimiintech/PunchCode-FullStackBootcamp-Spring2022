-- 13. The name, abbreviation, and population of all records in the state table with no official nickname (NULL) (5 rows)


--State Main

SELECT state_name, state_abbreviation, population FROM state WHERE state_nickname IS NULL;