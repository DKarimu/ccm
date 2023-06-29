@echo off
REM "host=localhost port=5432 dbname=postgres user=postgres
REM Logs Path "C:\Program Files\PostgreSQL\15\data\log\"
set PGDATA=C:\Program Files\PostgreSQL\15\data
set PGPORT=5432
set PGUSER=postgres
set PGPASSWORD=ccm1

REM Start the PostgreSQL server
echo Starting PostgreSQL...
"C:\Program Files\PostgreSQL\15\bin\pg_ctl.exe" stop -D "%PGDATA%" -o -p"%PGPORT%" -U "%PGUSER%"
echo PostgreSQL is stoped...
