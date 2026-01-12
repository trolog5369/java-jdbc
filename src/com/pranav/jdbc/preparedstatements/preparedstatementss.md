Prepared Statements
Prepared Statement is a feature in database programming, commonly used in JDBC and other
data access libraries

They are used to execute SQL queries with placeholders for parameters
These placeholders are then filled with specific values when the query is executed

They offer several advantages-
1.Protection against sql injection.
2.Improved performance,
3.Code readability and Maintainability.
4.Automatic data type Handling
5.Portability etc

                    JDBC java.sql
                    (Interface)

    Statement                     PreparedStatements
    -executeQuery()                -executeQuery()
    -execute sql query             -execute sql query
   
Query:
SELECT * FROM EMPLOYEES WHERE AGE=17 AND NAME='Pranav';

When we're talking abt plain statements:
When we're executing writing query using regular statements

SELECT * FROM EMPLOYEES WHERE AGE=17 AND NAME='Pranav';
We have 2 way to get the input:
1.User input
2.Declare in java as a variable then concatenate with string

when we will concatenate the variables
Con string+variables= prone to security threats Anyone can breach the database security using injections

This is a single query when inserting multiple queries it gets more prone to security threats 
hence we use PreparedStatements

PreparedStatements:(Interface in java same as Statement but execute query in diff fashion)
-It has placeholder and values
-We will write first placeholders and then execute values afterward 
eg for this query:
SELECT * FROM EMPLOYEES WHERE AGE=17;
placeholder will be
SELECT * FROM EMPLOYEES WHERE AGE=?;

Prepared Statements are precompiled on database server
hence we don't need them to execute them again and again
Increases code readability and maintainability
Improve security,Performance
Portability vendor neutral ie run on all vendors ie on mysql,nosql,mongodb,PostgresSQL etc


