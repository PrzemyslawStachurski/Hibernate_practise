This Repository contains series of basic projects using mainly SPRING BOOT and HIBERNATE. 
The purpose of these projects was to familiarize myself with these technolgies. 

The most notable project in this repository cointains fully functional REST API.
It allows logged in users to retrieve list of employees, create, delete and update them.

### **By creating these projects I learned the following aspects, skills and technolgies.**
-REST API architecture concept
-Service design pattern
-Connecting Java application to Database
-Serialization and deserialization 
-Using Path Variables in urls
-Creating custom queries while retrieving from database
-Restricting users access based on their role


### **Each Employee cointains:**
  -first name
  -last name
  -email


### **Endpints:**
GET:
  - /employees
  - /employees/employeeId
POST:
  - /employees
PUT:
  - /employees
DELETE:
  - /employees/employeeId


### **Functionalities:**
- To access API users must be logged in, ceredntials are retrieved from the database.
- Requiring users to log in before accesing endpoints
- Only users with appropriate roles can acces specific endpints eg. user with role employeee may use GET endpoint, user with manager role may use DELETE enpoint.
- Employees are stored in the database
