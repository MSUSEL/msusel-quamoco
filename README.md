# MSUSEL Implementation of Quamoco

## Introduction
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
.\mvnw.cmd clean install -Dmaven.test.skip=true
```

## Generating the Site

This project's site can be generated using the following command:

```
./mvnw clean site -Dmaven.test.skip=true
```

## Project Goals
* Calculate quality using a Quamoco Quality Model.
* Evaluate the quality grade for any set of quality factors and attributes.
* Create and evaluate quality models for multiple languages:
* Extend the Quamoco Quality models to include Code Smells, Antipatterns, and other issues not yet already included to increase their functionality.
* Replace the existing SQALE implementation in SonarQube.
* Collect and analyze data for empirical software engineering research.

## MSUSEL Project dependencies
This project depends on the following other MSUSEL subprojects:
1. [msusel-parent](https://github.com/MSUSEL/msusel-parent/)
2. [msusel-codetree](https://github.com/MSUSEL/msusel-codetree/)
3. [msusel-metrics](https://github.com/MSUSEL/msusel-metrics/)

## Building
There are two options:

1. You can use your own version of Maven and run the following commands at the command line, from the project root directory:
   * Compiling:
      ```bash
        $ mvn clean compile -Dmaven.test.skip=true
      ```
   * Packaging into a Jar with dependencies
      ```bash
        $ mvn clean package -Dmaven.test.skip=true
      ```
   * Packaging into a Jar and deploying to the [maven repo](https://github.com/MSUSEL/msusel-maven-repo):
      ```bash
        $ mvn clean deploy -Dmaven.test.skip=true
      ```

2. You can use the Maven wrapper which comes with the project:
   * On Mac and Linux:
      - Compiling:
      ```bash
        $ ./mvnw clean compile -Dmaven.test.skip=true
      ```
      - Packaging into a Jar with Dependencies:
      ```bash
        $ ./mvnw clean package -Dmaven.test.skip=true
      ```
      - Packaging into a Jar and deploying to the [maven repo](https://github.com/MSUSEL/msusel-maven-repo):
      ```bash
        $ ./mvnw clean deploy -Dmaven.test.skip=true
      ```
   * Windows:
      - Compiling:
      ```bash
        $ .\mvnw.cmd clean compile -Dmaven.test.skip=true
      ```
      - Packaging into a Jar with Dependencies:
      ```bash
        $ .\mvnw.cmd clean package -Dmaven.test.skip=true
      ```
      - Packaging into a Jar and deploying to the [maven repo](https://github.com/MSUSEL/msusel-maven-repo):
      ```bash
        $ .\mvnw.cmd clean deploy -Dmaven.test.skip=true
      ```

## License
As will all projects from MSUSEL this project is licensed under the MIT open source license. All source files associated with this project should have a copy of the license at the top of the file.

If a build fails due to license header issues, this can be remedied using the following command sequence at the command line:

- With an independently installed Maven system:
    * Linux, Mac, Windows:
    ```bash
     $ mvn license:format
    ```
- Using the Maven Wrapper:
    * Linux and Mac:
    ```bash
     $ ./mvnw license:format
    ```
    * Windows:
    ```bash
     $ .\mvnw.cmd license:format
    ```
