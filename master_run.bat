@ECHO OFF

start cmd.exe @cmd /k "cd /d .\database"

# Start the backend
start cmd /k "cd backend && mvn spring-boot:run"

# Start the frontend
start cmd /k "cd frontend && npm run dev"

# Start the database
start cmd /k "cd database && docker start postgres-group2"

# Start the reverse proxy
start cmd /k "cd proxy && node index.js"
