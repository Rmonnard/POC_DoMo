

Technical Proof-of-Concept project
==================================

How can we optimize the serialisation in REST APIs with Jackson.
----------------------------------------------------------------

We have build a simple REST API in java ee with glassfish as server. This REST API has a list of users as resource. This ressource is stored in a MYSQL database. There is 2 tables, one for the firstname, lastname , email, ... and an other table for the postal address of the user. The two table are joined by a one to one rule.

For the mesurements, the git contains some plans wich can be runned with Apache JMeter. We have set defaults values for the testing. There is two group of testing plans, one for the insertion in the database (POST) and one for the reading (GET).

With the server, there is 5 différents implementations for comparing performances:
Each implementation is in a different servlet.

1) 	Servlet: PersonServletNew
No optimisation, there are always new object created in the Jackson serialization & deserialization.

2)	Servlet: PersonServletNewEJB
Utilisation of EJB, there are always new object created in the Jackson serialization & deserialization.

3)	Servlet: PersonsServlet
Utilisation of EJB, optimize the code for the objects intanciations in the Jackson serialization & deserialization

4)	Servlet: Afterburner
Addon which can be found on the internet. It optimize the objects instnaciations and limit the overhead

5)	Servlet: ObjectWriting
Object of Jackson optimized for parsing JSON. Faster than ObjectMapper


INSTALLATION:
-------------

Clone the git on your computer.
Install Netbeans and Glassfish.
Download Apache JMeter.
Download Apache JMeter addon and copy the .jar file into /.../.../ in the JMeter folder.

COMPUTE:
--------

You can now run the glassfish server and launch the JMeter mesurements.
You can play with all of the servlet, read the code, modify, pr try to optimize. You can create your own servlets too.

TEAM:
-----

Luis Domingues
Matteo Tagliabue
Romain Monnard