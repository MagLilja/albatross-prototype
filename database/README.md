# Postgres

## Project setup

To setup the project, you need to have a postgres database running.
You can use docker to run a postgres database.

To run a postgres database using docker, use the following script:

```bash
./start_script.sh
```

This script will create a docker container with a postgres database
running on port 5432.

With the following credentials:

- username: user
- password: postgres
- database: spgroup2

To stop the database, use the following script:

```bash
./stop_script.sh
```

The backend application will be available at http://localhost:8080

