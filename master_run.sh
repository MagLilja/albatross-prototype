#!/bin/bash

#:: make sure the ports are free
#$(for /f "tokens=5" %%a in ('netstat -aon ^| find ":8080" ^| find "LISTENING"') do taskkill /f /pid %%a)
#for /f "tokens=5" %%a in ('netstat -aon ^| find ":8282" ^| find "LISTENING"') do taskkill /f /pid %%a
#for /f "tokens=5" %%a in ('netstat -aon ^| find ":5173" ^| find "LISTENING"') do taskkill /f /pid %%a
cmd.exe /c "wt.exe" -p "Command Prompt" \; split-pane -p "Windows PowerShell" \; split-pane -H wsl.exe

#cmd /c "wt.exe" --title pane1 \; split-pane -p "Command Prompt" --title pane2
#:: start powershell with all the commands
#cmd.exe /c "wt.exe" -p PowerShell -d ./database cmd /k "docker start postgres-group2 && docker ps"\; split-pane -p PowerShell -d ./backend -H cmd /k mvn spring-boot:run\; move-focus up\; split-pane -p PowerShell -V -d ./frontend cmd /k pnpm run dev \; move-focus down\; split-pane -V -p PowerShell -d ./proxy cmd /k node index.js



