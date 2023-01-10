#!/usr/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=school_comm_db
psql -h localhost -p 15432 -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -h localhost -p 15432 -U postgres $DATABASE &&
psql -h localhost -p 15432 -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -h localhost -p 15432 -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -h localhost -p 15432 -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
