@ECHO OFF

:: Build the backend
cd backend
call mvn clean install
echo "################## Backend built ##################"
echo "####################################################"


:: Build the database docker image
cd ..\database
sh .\build_script.sh
echo "################## Postgres built ##################"
echo "####################################################"

:: Build the frontend
cd ..\frontend
call npm install -g pnpm
call pnpm install
echo "################## Frontend built ##################"
echo "####################################################"

:: Build the reverse proxy
cd ..\proxy
call pnpm install
echo "################## Proxy built ##################"
echo "####################################################"




