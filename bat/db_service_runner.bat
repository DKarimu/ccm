@echo off
REM "host=localhost port=5432 dbname=postgres user=postgres
REM Logs Path "C:\Program Files\PostgreSQL\15\data\log\"
REM Set the necessary environment variables

set PGDATA=C:\Program Files\PostgreSQL\15\data
set PGPORT=5432
set PGUSER=postgres
set PGPASSWORD=ccm1

REM Start the PostgreSQL server
echo Starting PostgreSQL...
"C:\Program Files\PostgreSQL\15\bin\pg_ctl.exe" start -D "%PGDATA%" -o -p"%PGPORT%" -U "%PGUSER%"
REM "C:\Program Files\PostgreSQL\15\bin\pg_ctl.exe" start -D "C:\Program Files\PostgreSQL\15\data" -o -p"5432" -U "postgres" -l "C:\Users\AIBOU\Desktop\Projects\CCM\logfile.txt"

REM Wait for the server to start
timeout /t 5 /nobreak >nul

REM Check if the server is running
"C:\Program Files\PostgreSQL\15\bin\pg_isready" -h localhost -p %PGPORT%
if %errorlevel% neq 0 (
  echo Failed to start PostgreSQL.
  exit /b
)
echo PostgreSQL is running...

REM stop "C:\Program Files\PostgreSQL\15\bin\pg_ctl.exe" stop -D "C:\Program Files\PostgreSQL\15\data\"
REM To check if a PostgreSQL database server is running "C:\Program Files\PostgreSQL\15\bin\pg_isready" -h localhost -p 5432
REM Pause the script (optional)

