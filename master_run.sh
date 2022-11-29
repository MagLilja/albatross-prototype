#!/bin/bash
@ECHO OFF
# This script is used to run the complete application in development mode

# Start the database

start cmd.exe @cmd /k "cd /d .\database"

# Start the backend
start cmd /C "cd backend && mvn spring-boot:run"

# Start the frontend
start cmd /C "cd frontend && npm start"

# Start the reverse proxy
start cmd /C "cd proxy && npm start"
