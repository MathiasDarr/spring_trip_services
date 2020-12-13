### Cassandra Time Series Spring Data Microservices ###
This repository contains a Spring Boot application which leverages Apache Cassandra to write time series data

### Data Model ###
* the trips_data table uses a composite primary partitioning key (user_id, trip_id) and a timestamp for the clustering key.

### Microservices ###
* trip_service
    - allow authenticated users to post new trips
        - endpoint for posting 


### Seeding the data ### 
* docker-compose -f cassandra-compose.yml up
* cd data_model
* python3 populate_trips_table.py

### Running the service ###
* cd microservices
* compile and run the service 
    * mvn clean package
    * java -jar trip_service/target/trip_service-0.0.1-SNAPSHOT.jar
* verify the service is returning the proper data by hitting the endpoint 
    * GET request to the endpoint with URL /trips/{userid}/{tripid} returns all data from the trip with tripid
    * curl http://localhost:8080/trips/041b1dc9-b569-4a21-92cb-62d30f0b2c3f/64fd983f-b139-4e64-a981-3c8686d28f71 | jq
