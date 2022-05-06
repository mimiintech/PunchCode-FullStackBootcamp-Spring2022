-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'puppy_capstone';

DROP DATABASE puppy_capstone;

DROP USER puppy_capstone_owner;
DROP USER puppy_capstone_appuser;
