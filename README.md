# REST and SOAP E-Commerce Web Service

>An E-Commerce RESTful and SOAP web service built using JAX-RS and JAX-WS.

#  Documentation
[Postman RESTful API Docs](https://documenter.getpostman.com/view/15335375/UyxdL9Xm)

#  Technologies 
* JAX-RS (Jersey)
* JAX-WS (Metro)
* JSON-B
* JAX-B
* Maven
* Tomcat
* Intellij IDEA Ultimate
* Postman


#Resources
```
Product  
Order 
Categories
Users
```
#Endpoints

```
/api/v1/products
/api/v1/products/{id}
/api/v1/products/{id}/categories
/api/v1/categories
/api/v1/categories/{id}
/api/v1/categories/{id}/products
/api/v1/users
/api/v1/users/{id}
/api/v1/users/{id}/orders

```


#  Run with Maven
**Maven**

* Change the configuration of Tomcat in `pom.xml`.
* Deploy the application using the following maven command:
```
mvn clean compile tomcat7:redeploy
```
* REST: change the `{{host}}` variable in the Postman collection environment variables to match the port you chose for your Tomcat deployment
* SOAP: import the project into SOAP UI

**DataBase**
* Create a database schema and provide the username and password in the persistence.xml

