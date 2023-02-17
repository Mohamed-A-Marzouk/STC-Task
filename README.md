# STC-Task

prerequisite
#java 8 installed 
#mysql
#clean and build project to download maven dependencies for spring 

we need to create database schema 

CREATE SCHEMA `clinic` ;

after that if we nedd to update following 3 props in application.properties file 

spring.datasource.url=jdbc:mysql://localhost:3306/clinic
spring.datasource.username=root
spring.datasource.password=root

after that you don't need to create database table hibernate will create it

//////////////////////////////////////////////////
DDL if you want to create it manually

CREATE TABLE `appointments` (
  `id` int(11) NOT NULL,
  `appointment_date` datetime NOT NULL,
  `cancellation_reason` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8
////////////////////////////////////////////////


run project

you can run it from ide as spring boot project 
 
or

run project as stand alone app on windows using generated jar in target path after bulding the project
1-you need to open cmd and cd to project path
2-run mvnw package
3-run cd target
4-run java -jar appointment-0.0.1-SNAPSHOT.jar

you can find project logs in folder stclogs in project path


test project 
you can use swagger using following link after runnin app

http://localhost:8080/swagger-ui/index.html

