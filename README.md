

<table>
<tr>
    <td>
        <a href="http://bit.ly/2D9pxjW" target="_blank">
        <img src="https://github.com/kayartaya-vinod/2018_11_Unisys_TypeORM/raw/master/angular7.jpeg">
        </a>
    </td>
    <td>
        <a href="https://www.udemy.com/mongodb-fundamentals/?couponCode=FIRST500" target="_blank">
        <img src="https://github.com/kayartaya-vinod/2018_11_Unisys_TypeORM/raw/master/mongodb.jpeg">
        </a>
    </td>
</tr>
</table>



### Download h2 database from here:

<a href="http://www.h2database.com/h2-2018-03-18.zip">h2 database</a>

### How to use h2 database?

* Unzip the downloaded file `h2-2018-03-18.zip`
* Go to *h2-2018-03-18/bin* folder
* Windows - double click the *h2.bat* file
* MacOS/Linux - run the *h2.sh* in a terminal

This will start a RDBMS server and also opens a client application in a browser.


If the server doesn't start due to port issues, create/update the *.h2.server.properties* file in the home directory with the following (change the webPort to some other unused port): 

```
0=Generic H2 (Server)|org.h2.Driver|jdbc\:h2\:tcp\://localhost/~/2019_01_HIBERNATE_SPRING_HPE|sa
webAllowOthers=false
webPort=8082
webSSL=false
```

<img src="https://github.com/kayartaya-vinod/2019_01_HIBERNATE_SPRING_HPE/raw/master/assets/images/h2-client-1.png" width="90%">

* Select **Generic H2 (Server)** from the *Saved settings* dropdown
* Driver class - **org.h2.Driver** 
* URL - jdbc:h2:tcp://localhost/~/2019_01_HIBERNATE_SPRING_HPE
* Username - sa (you may change if you want)
* Password - (empty by default, you may change if you want)

Click the **Connect** button.

<img src="https://github.com/kayartaya-vinod/2019_01_HIBERNATE_SPRING_HPE/raw/master/assets/images/h2-client-2.png" width="90%">


### Download the database script from here:

<a href="http://vinod.co/resources/dbscript.zip">DB Script (zip file)</a>


### Command to import tables and data from the script file in h2 database:

```sql
runscript from 'ABSOULTE_PATH_TO_THE_DBSCRIPT.SQL_FILE'
```

FOR EXAMPLE:

```sql
runscript from '/Users/vinodkumar/Desktop/dbscript.sql'
```

### For MySQL download the script from here:

<a href="http://kelutral.com/vinod_co_backup/hibernate/Resources/DB%20Scripts/MySQL_Northwind.sql" target="_blank">MySQL_Northwind.sql (SQL file)</a>


The tables and relationships among the same is explained here:

<img src="http://kelutral.com/vinod_co_backup/hibernate/Resources/DB%20Scripts/NORTHWIND_DB_DIAGRAM.png" width="100%">
