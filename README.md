# Soundgood Database CLI
This is a solution to task 4 using `JOOQ` which can:
1. `List Instruments` and filter by instrument type
1. `Rent Instrument` while abiding by the business rules
1. `Terminate Rental` without losing any information

## How to run
1. Clone this git repository
1. Setup the database using the SQL files found in the repository
1. Build the project using `mvn install`
1. Execute the project using `mvn exec:java`

## Commands for the CLI
1. `LIST_INST` Lists all rentable instruments, and can be filtered by instrument type
1. `RENT` Rents an instrument given a valid student and instrument ID
1. `LIST_LEASE` Lists all active leases, and can be filtered by student ID
1. `TERMINATE` Terminates an active rental given a valid lease ID
1. `HELP` Shows a help menu
1. `QUIT` Quits the program
