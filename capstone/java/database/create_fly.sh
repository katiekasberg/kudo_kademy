#!/usr/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=school_comm_db
psql -p 15432 -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -p 15432 -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -p 15432 -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -p 15432 -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
