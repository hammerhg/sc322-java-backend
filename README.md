# Spring Boot application template

## Purpose

The purpose of this application is to speed up the creation of new Spring applications. If you need to create a new app, you can
simply use this one as a starting point and build on top of it.

## What's inside

The template is a working application with a minimal setup. It contains:
 * application skeleton
 * common plugins and libraries
 * swagger configuration for api documentation ([see how to publish your api documentation to shared repository](https://github.com/hmcts/reform-api-docs#publish-swagger-docs))

## Plugins

The template contains the following plugins:

  * checkstyle (TO BE ADDED)

    https://maven.apache.org/plugins/maven-checkstyle-plugin/
    https://maven.apache.org/plugins/maven-checkstyle-plugin/usage.html

    Performs code style checks on Java source files using Checkstyle and generates reports from these checks.
    The checks are included in Maven's *check* task (you can run them by executing `./mvn checkstyle::check` command).

  * pmd (TO BE ADDED)

    https://maven.apache.org/plugins/maven-pmd-plugin/

    Performs static code analysis to finds common programming flaws. Included in Maven `check` task.


## Notes

JUnit 5 is now enabled by default in the project. Please refrain from using JUnit4 and use the next generation

## Building and deploying the application

### Building the application

The project uses [Maven](http://maven.apache.org/) as a build tool. It already contains
`./mvnw` wrapper script, so there's no need to install Maven.

To build the project execute the following command:

```bash
  ./mvnw clean package
```

### Running the application

Create the image of the application by executing the following command:

```bash
  ./mvnw package
```

### Running the tests

Run all tests of the application by executing the following command:

```bash
  ./mvnw test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
