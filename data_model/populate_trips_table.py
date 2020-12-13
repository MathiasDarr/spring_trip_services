"""
This script creates & populates the users & the trips cassandra tables
"""
# !/usr/bin/env python3

import os
import csv
from utilities.cassandra_utilities import createCassandraConnection, createKeySpace


def populate_user_table():
    create_users_table = """Create table IF NOT EXISTS users(
        user_id text, 
        PRIMARY KEY(user_id)
    );"""
    dbsession.execute(create_users_table)

    insert_trip_data_point = """INSERT INTO users(user_id) VALUES(%s);"""

    PROVIDERS_CSV_FILE = 'data/users/users.csv'
    with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point, [row['user_id']])


def populate_trips_table():
    create_trip_data_point_table = """CREATE TABLE IF NOT EXISTS trip_data(
        user_id text,
        trip_id text, 
        time timestamp,
        latitude float,
        longitude float,
        PRIMARY KEY((user_id, trip_id), time));
    """
    dbsession.execute(create_trip_data_point_table)

    insert_trip_data_point = """INSERT INTO trip_data(user_id, trip_id, time, latitude, longitude) VALUES(%s,%s,%s,%s, %s);"""

    TRIP_DATA_CSV_FILE = 'data/trips/trips.csv'

    with open(TRIP_DATA_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point,
                              [row['user_id'], row['trip_id'], row['time'], float(row['latitude']),
                               float(row['longitude'])])


if __name__ == '__main__':
    dbsession = createCassandraConnection()
    createKeySpace("ks1", dbsession)
    try:
        dbsession.set_keyspace('ks1')
    except Exception as e:
        print(e)

    populate_user_table()
    populate_trips_table()
