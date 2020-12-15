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
        PRIMARY KEY(user_id, request_time)
    );"""
    dbsession.execute(create_users_table)

    insert_trip_data_point = """INSERT INTO ride_requests(user_id, request_time,location_lat, location_lng, destination_lat, destination_lng, riders)
        VALUES(%s, %s,%s,%s,%s,%s, %s);"""

    PROVIDERS_CSV_FILE = 'data/ride_requests/ride_requests.csv'
    with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_trip_data_point, [row['user_id'], row['request_time'], float(row['location_lat']) ,
                                                       float(row['location_lng']) , float(row['destination_lat']), float(row['destination_lng']), int(row['riders'])])



if __name__ == '__main__':
    dbsession = createCassandraConnection()
    createKeySpace("ks1", dbsession)
    try:
        dbsession.set_keyspace('ks1')
    except Exception as e:
        print(e)

    populate_ride_requests_table()
