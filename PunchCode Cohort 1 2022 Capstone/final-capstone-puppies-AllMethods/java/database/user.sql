-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER puppy_capstone_owner
WITH PASSWORD 'puppycapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO puppy_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO puppy_capstone_owner;

CREATE USER puppy_capstone_appuser
WITH PASSWORD 'puppycapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO puppy_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO puppy_capstone_appuser;
