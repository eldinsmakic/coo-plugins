# Plugin Project
	
The Objective here is the progressive creation of an GUI application which adapt itself in functions of Plugins installed in a directory.

This project is the occasion to build observable/observers design-pattern and use some aspect of reflection.

plugins will transform a text, Capitalize it, encoding it, etc.




## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
 * For testing, creating/getting jar,javadoc
 	* [Maven](https://maven.apache.org/) - Dependency Management
 
### Installing

A step by step series of examples that tell you have to get a development env running

To launch the game (need to be in the directory /project_plugins/)
```
mvn compile
cd target
java -classpath classes:extensions fil.coo.App

```


## Running the tests

to run the test (need to be in the directory .../Projet_Piscine)
```
mvn test
```

### Creating javadoc

Again using mvn

```
mvn javadoc:javadoc
```


## Built With


* [Maven](https://maven.apache.org/) - Dependency Management

* Java



## Authors

* **PERROT Antoine** - *Co-developper* - [perrot](https://gitlab-etu.fil.univ-lille1.fr/perrot)
* **SMAKIC Eldin**  - *developper* - [eldinsmakic](https://github.com/eldinsmakic/)


