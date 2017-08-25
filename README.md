# MSUSEL Implementation of Quamoco

This project is an implementation of the Quamoco quality evaluation framework. Currently we have implemented quality models for the following languages/specifications:

* Java
* C#

Beyond the Java and C# models, we intend to develop several other models based on QMOOD, SIG, ColumbusQM, and SQALE quality models.
We have also included an extended quality model for both Java and C# (extending their models) which includes enhanced security analysis to
meet RMF compliance.

## Building
This project is completely implemented using Java and currently uses Maven for the build managment. Thus, the following command executed at the project root directory will collect the necessary dependencies and produce a JAR file in the target directory:

`mvn package`

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