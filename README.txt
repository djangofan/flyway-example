flyway-example
----------------

This project was created using IntelliJ IDEA 13.1 .  Will also work with Eclipse.

execution-steps
------------------

1. Install PostgreSQL with default options, and root password "monster1234".
2. Create new admin superuser in Postgres named "monster" with password "monster1234"
3. Create new database called "flyway" with owner being the user "monster".
4. Open this project with IntellijIDEA or Eclipse.
5. Run project with Maven goal ```compile flyway:migrate```





