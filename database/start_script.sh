#!/bin/bash

# This script is used to build and run a docker container

# Build the docker container
docker build . -t postgres-group2

# Run the docker container
docker run -d -p 5432:5432 --name postgres-group2 postgres-group2