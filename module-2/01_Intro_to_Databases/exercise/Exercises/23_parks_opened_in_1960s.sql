-- 23. The name and date established of parks opened in the 1960s (6 rows)

--Park Main

SELECT park_name, date_established FROM park WHERE date_established >= '1/1/1960' AND date_established <= '12/31/1969';