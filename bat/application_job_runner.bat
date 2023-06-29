@echo off
set "app_path=C:\path\to\your\application.exe"

echo Running Application Job Runner...

if exist "%app_path%" (
    echo Starting application...
    start "" "%app_path%"
) else (
    echo Application not found at %app_path%. Please check the path.
)

echo Application Job Runner completed.
