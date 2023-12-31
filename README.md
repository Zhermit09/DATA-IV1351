# Soundgood Database CLI
This is a solution to task 4 using `JOOQ` which can:
1. `List Instruments` and filter by instrument type
2. `Rent Instrument` while abiding by the business rules
3. `Terminate Rental` without losing any information

## How to run
1. Clone this git repository
2. Set up the database using the SQL files found in the repository
3. Update postgres url, username and password in `src > test > resources > jooq-conf.xml` 
and in `src > main > storage > SoundgoodDAO` if needed
   1. Running the `src > test > JooqGenereator` will regenerate `JOOQ`'s classes by accessing the database
      (the database must be online and accessible)
4. Build the project using `mvn install`
5. Execute the project using `mvn exec:java`

## Commands for the CLI
1. `LIST_INST` Lists all rentable instruments, and can be filtered by instrument type
2. `RENT` Rents an instrument given a valid student and instrument ID
3. `LIST_LEASE` Lists all active leases, and can be filtered by student ID
4. `TERMINATE` Terminates an active rental given a valid lease ID
5. `HELP` Shows a help menu
6. `QUIT` Quits the program
