# Student Management System

Checklist
- [x] Add project overview and tech stack
- [x] Add prerequisites and setup steps
- [x] Add run, build and test instructions
- [x] Document available HTTP endpoints and UI pages
- [x] Provide notes about database configuration and common troubleshooting

## Project overview

A simple CRUD Student Management System built with Spring Boot, Spring Data JPA and Thymeleaf. The app demonstrates:

- Listing students
- Creating a new student
- Editing an existing student
- Deleting a student

This repository contains the source for a small web application that renders server-side HTML pages (Thymeleaf) and persists data into a MySQL database via JPA.

## Tech stack

- Java 21
- Spring Boot 4 (spring-boot-starter-parent)
- Spring Data JPA
- Thymeleaf
- MySQL (mysql-connector-j)
- Maven (wrapper included)

## Prerequisites

- Java 21 installed and JAVA_HOME configured
- Git (optional, for cloning)
- MySQL server (or modify `src/main/resources/application.properties` to use your preferred DB)

## Database setup

The project expects a MySQL database. The default connection is set in `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/sms?useSSL=false&serverTimezone=UTC&useLegacyDateTimeCode=false
spring.datasource.username=root
spring.datasource.password=springstudent
```

Create the database (example):

```sql
CREATE DATABASE sms;
-- grant privileges or update the username/password in application.properties
```

Alternatively, update the username/password or the JDBC URL in `application.properties` to match your environment.

Hibernate DDL auto is configured as `update`, so tables will be created/updated automatically on startup:

```
spring.jpa.hibernate.ddl-auto=update
```

Security note: Do not commit production credentials. Use environment variables or an external configuration for production deployments.

## Build & Run

Use the included Maven wrapper to build and run the application.

From the project root (this repository):

Build the JAR:

```bash
./mvnw -v
./mvnw clean package
```

Run with the wrapper (development):

```bash
./mvnw spring-boot:run
```

Or run the packaged jar:

```bash
java -jar target/student-management-system-0.0.1-SNAPSHOT.jar
```

On Windows (cmd) use `mvnw.cmd` instead of `./mvnw`.

## Tests

Run tests with:

```bash
./mvnw test
```

## Web UI and Endpoints

The application serves a small server-side rendered UI (Thymeleaf). After starting the app, open:

- List students (home): http://localhost:8080/students
- Create student form: http://localhost:8080/students/new

Controller endpoints (as implemented in `StudentController`):

- GET  /students            — list all students (renders `students.html`)
- GET  /students/new        — show create student form (`create_student.html`)
- POST /students            — submit new student form
- GET  /students/edit/{id}  — show edit form for student id (`edit_student.html`)
- POST /students/{id}       — update student with id
- GET  /students/{id}       — delete student with id (redirects back to `/students`)

Note: Delete is implemented as a GET request to `/students/{id}` in this project; this is convenient for the demo but not RESTful or recommended for production (use HTTP DELETE or a POST with CSRF protection in real apps).

## Project structure

- `src/main/java` — Java source (entity, repository, service, controller)
- `src/main/resources/templates` — Thymeleaf HTML templates (`students.html`, `create_student.html`, `edit_student.html`)
- `src/main/resources/application.properties` — runtime configuration

## Troubleshooting

- Port conflicts: change `server.port` in `application.properties` or free port 8080
- Database connection errors: verify MySQL is running, correct URL/credentials, and the `sms` database exists
- If Hibernate doesn't create tables, check `spring.jpa.hibernate.ddl-auto` and application logs for errors

---

