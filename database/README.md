# SmartCampus Databases 

There are two databases in SmartCampus system:

- **SensorsData**, PostgreSQL Database to store values of sensors depending on time ;
- **SensorsConfig**, PostgreSQL Database to store configurations of sensors ;

## SensorsData

Before running the modules (data API and data processor), you have to initialize the database by running the script `SensorsData.sql` in psql shell, thanks to the command `\i path-to-file/SensorsData.sql`.

This script :

1. **Clear** all roles, databases and tables;
2. **Create 3 roles** : *smartcampus* who is the superuser, *dataaccessor* who is able to select only and *dataprocessor* who can select, insert, update and delete values in the database;
3. **Create the database** *SensorsData*;
4. **Create the table** *SensorsData*, owned by *smartcampus*;
5. **Grant users** depending on theirs privileges.

The *SensorsData* table is composed by three columns : *sensor_id*, *sensor_date* and *sensor_value*, to store values of sensors depending on time. The primary key is the pair *id-date*, and the *sensor_value* can not be null.

## Database access command

'''
sudo -u postgres psql postgres
//On se connecte pas à la base par défaut
\connect SensorsData
//Pour voir si la table SensorsData existe bien
\dt
//On affiche la table
select * from "SensorsData";
'''

## Database Project

DAO to read/write on the database