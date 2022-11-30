@ECHO OFF

:: make sure the ports are free

call npx kill-port 8080
call npx kill-port 8282
call npx kill-port 5173

docker run -d -p 5432:5432 --name postgres-group2 postgres-group2

:: start powershell with all the commands
wt -p PowerShell -d ./database cmd /k "docker start postgres-group2 && docker ps"; split-pane -p PowerShell -d ./backend -H cmd /k mvn spring-boot:run; move-focus up; split-pane -p PowerShell -V -d ./frontend cmd /k pnpm run dev ; move-focus down; split-pane -V -p PowerShell -d ./proxy cmd /k node index.js



