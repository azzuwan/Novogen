Tempoyak AppGen
==================

Description
------------------
A database application generator that scaffolds a fully functioning application with CRUD pages and JSON API end points.

This is a database first development approach. The generator is supposed to figure out the database structure and create all the necessary user interface for it plus a rich set of JSON APis.

Tools used:

- Java 8
- [Apache MetaModel](http://metamodel.apache.org/ "http://metamodel.apache.org/")
- [Pebble Template Engine](http://www.mitchellbosecke.com/pebble/home "http://www.mitchellbosecke.com/pebble/home") 


Goals
------------------
- To be able to generate a full fledge web application the following frameworks 
    -Go (net/http)
    -ExpressJS
    -Laravel
    -SparkJava
- Generic enough to allow generation for more frameworks in other languages in the future.

Usage
------------------
- The Maven project will generate a gen.jar file in the target directory
- The gen.jar needs to be fed with a json file describing the project
- Example Usage: java -jar gen.jar project.json


Generated Files
------------------
- The generated files will be in the path specified in project json file.
