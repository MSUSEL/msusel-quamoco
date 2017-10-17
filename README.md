# MSUSEL Implementation of Quamoco

This project is an implementation of the Quamoco quality evaluation framework. Currently we have implemented quality models for the following languages/specifications:

* Java
* C#

Beyond the Java and C# models, we intend to develop several other models based on QMOOD, SIG, ColumbusQM, and SQALE quality models.
We have also included an extended quality model for both Java and C# (extending their models) which includes enhanced security analysis to
meet RMF compliance.

## Installing Maven

This project uses the Maven wrapper so that you do not need to install maven manually.
The first time you go to build this project, simply execute the following command:

```
./mvnw clean install -Dmaven.test.skip=true
```
or for windows:
```
.\mvnw.cmd clean package -Dmaven.test.skip=true
```

## Building

This project can be built using the following command:

```
./mvnw clean package -Dmaven.test.skip=true
```

This project can be compile, tested, or packaged with the following commands:

```
./mvnw clean compile
./mvnw clean test
./mvnw clean package
```

## Project Goals
* Calculate quality using a Quamoco Quality Model.
* Evaluate the quality grade for any set of quality factors and attributes.
* Create and evalute quality models for the following languages:
 - ABAP
 - C/C++
 - C#
 - Clojure
 - COBOL
 - CSS
 - D
 - Erlang
 - Flex/Action Script
 - Fortran
 - F#
 - Go
 - Groovy
 - Haskell
 - Io
 - Java
 - JavaScript
 - Lisp
 - lua
 - ML
 - Objective-C
 - PHP
 - PL/1
 - PL/SQL
 - Python
 - R
 - RPG
 - Ruby
 - Scala
 - Scheme
 - Swift
 - VB.NET
 - Web/HTML
 - XML
* Extend the Quamoco Quality models to include Code Smells, Antipatterns, and other issues not yet already included to increase their functionality.
* Replace the existing SQALE implementation in SonarQube.
* Collect and analyze data for empirical software engineering research.