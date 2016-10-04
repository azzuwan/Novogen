Tempoyak AppGen
==================

Description
------------------
A database application generator that scaffolds a fully functioning application with CRUD pages and JSON API end points.

This is a database first development approach. The generator is supposed to figure out the database structure and create all the necessary user interface for it plus a rich set of JSON APis.

Tools used:

- Java 8
- Apache MetaModel - An excellent all persistent type meta query interface [http://metamodel.apache.org/](http://metamodel.apache.org/ "http://metamodel.apache.org/")
- JTwig [http://jtwig.org/](http://www.jtwig.org "http://www.jtwig.org") 


Goals
------------------
- To be able to generate a full fledge web application framework like Spark Java, Laravel, ExpressJS etc.
- Generic enough to allow generation for more frameworks in other languages.

Usage
------------------
- The Maven project will generate a gen.jar file in the target directory
- The gen.jar needs to have:  1) the templates folder and 2) project.json in the same directory
- Usage: java -jar gen.jar project.json

Templates
------------------
- Example framework templates is included in the root directory of the repository
- The data to be passed to the template will be standardized soon
- The directory needs to be present in the same dir as the gen.jar executable file. 


Generated Files
------------------
- The generated files is specified in the path key of the project.json
- The generated files will be in /[path in json]/projects/[language]/project_name