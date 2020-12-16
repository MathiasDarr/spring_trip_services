"""
This script creates & populates the trip request cassandra tables
"""
# !/usr/bin/env python3

import os
import csv
from utilities.cassandra_utilities import createCassandraConnection, createKeySpace


def populate_ride_requests_table():
    create_users_table = """Create table IF NOT EXISTS ride_requests(
        user_id text,
        request_time timestamp,
        location_lat float, 
        location_lng float,
        destination_lat float, 
        destination_lng float,
        riders int,
        status text,
        PRIMARY KEY(user_id, request_time)
    );"""
    dbsession.execute(create_users_table)

    insert_trip_data_point = """INSERT INTO ride_requests(user_id, request_time,location_lat, location_lng, destination_lat, destination_lng, riders, status)
        VALUES(%s, %s,%s,%s,%s,%s, %s, %s);"""

    PROVIDERS_CSV_FILE = 'data/ride_requests/ride_requests.csv'
    with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point, [row['user_id'], row['request_time'], float(row['location_lat']), float(row['location_lng']),
                                                       float(row['destination_lat']), float(row['destination_lng']), int(row['riders']), row['status']])


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


def populate_drivers_table():

    create_trips_table = """CREATE TABLE IF NOT EXISTS drivers(
            driver_id text, 
            first_name text,
            last_name text,
            PRIMARY KEY(driver_id));
        """
    dbsession.execute(create_trips_table)

    insert_trip_data_point = """INSERT INTO drivers(driver_id, first_name, last_name) VALUES(%s, %s,%s);"""

    TRIP_DATA_CSV_FILE = 'data/drivers/drivers.csv'

    with open(TRIP_DATA_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point, [row['driver_id'], row['first_name'], row['last_name']])


def populate_trips_table():
    create_trips_table = """CREATE TABLE IF NOT EXISTS trips(
            trip_id text, 
            user_id text,
            distance float, 
            length float,
            PRIMARY KEY(trip_id));
        """
    dbsession.execute(create_trips_table)

    insert_trip_data_point = """INSERT INTO trips(trip_id, user_id, length, distance) VALUES(%s,%s, %s, %s);"""

    TRIP_DATA_CSV_FILE = 'data/trips/trips.csv'

    with open(TRIP_DATA_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point, [row['trip_id'], row['user_id'], 0.0, 0.0])



def populate_user_trips_table():
    create_trip_data_point_table = """CREATE TABLE IF NOT EXISTS trip_data(
        trip_id text, 
        time timestamp,
        latitude float,
        longitude float,
        PRIMARY KEY((trip_id), time));
    """
    dbsession.execute(create_trip_data_point_table)

    insert_trip_data_point = """INSERT INTO trip_data(trip_id, time, latitude, longitude) VALUES(%s,%s,%s,%s);"""

    TRIP_DATA_CSV_FILE = 'data/trips/trips.csv'

    with open(TRIP_DATA_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point,[row['trip_id'], row['time'], float(row['latitude']),float(row['longitude'])])



if __name__ == '__main__':
    dbsession = createCassandraConnection()
    createKeySpace("ks1", dbsession)
    try:
        dbsession.set_keyspace('ks1')
    except Exception as e:
        print(e)

    populate_drivers_table()
    populate_ride_requests_table()
    populate_trips_table()
    populate_user_table()
    populate_user_trips_table()

