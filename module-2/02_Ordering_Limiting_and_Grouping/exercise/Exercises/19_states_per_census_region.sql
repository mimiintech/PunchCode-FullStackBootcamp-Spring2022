-- 19. The census region and the number of records in the state table (name column 'num_states') for each census region. Exclude ones that don't have a census region.
-- Order the results from highest to lowest.
-- (Note: DC is in a census region, but the territories aren't, so the sum of the counts will equal 51).
-- (4 rows)

--State Main

SELECT census_region, count(census_region) as num_states
FROM state
WHERE census_region IS NOT NULL
GROUP BY state.census_region
ORDER BY num_states DESC;

