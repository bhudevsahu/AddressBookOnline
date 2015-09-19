# AddressBookOnline

An online address book service which lets multiple users to manage their address and other genral details online by making their profile on the service. Using this service users can put their information online and keep it intact. Also in case they want to edit their details or remove their account they can do it any time. Also if a user wants to look for other users and their details, they can do it.
Apart from user the service gives all the privilege of creating, modifying and deleting of user accounts to the “Administrator”.

How to run?

-	First use the AddressBook.sql file to create a database and fill the database with some dummy data. The .sql file already have details of 100 dummy users.

-	To create a database use the command in MySQL:

mysql> source “full path of the file”

for ex: mysql> source C:\Users\ABC_PC\Desktop\AddressBook.sql
This is the way a sql file can be imported into MySQL, in other databases also it can be done in different ways.
-	Import the whole project into eclipse. The project is ready to use after few changes.

-	Navigate to project “src” folder, go to Connections package and then open the BookConnection.java file. Make sure that the connection user and password matches your database credentials.

-	The application server and database connection need to be configured manually.

-	Once everything is set, navigate to WebContent >JSP >LoginPage.jsp – right click > Run As > Run on Server.
