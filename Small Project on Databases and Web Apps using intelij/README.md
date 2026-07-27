# Hospital management system

A full-stack web application for running a hospital: appointments, doctors,
medical staff, prescriptions and certificates, with role-based access for
administrators, medical staff and patients.

## Stack

- **Backend** — Java servlets on Apache Tomcat, built with Maven
- **Database** — accessed through a JDBC connection layer, with an initialiser
  that creates and seeds the schema
- **Frontend** — HTML, CSS and vanilla JavaScript talking to the servlets over
  AJAX

## Layout

```
implementation/Hospital/
  pom.xml                       Maven build
  src/main/java/
    mainClasses/                domain model: Doctor, User, Randevouz (appointment), Dose, ...
    db/
      DB_Connection.java        JDBC connection
      init/InitDatabase.java    schema creation and seeding
      tables/                   one data-access class per table
    servlets/                   the HTTP endpoints: Login, addDoctor, getAppointment, ...
  src/main/webapp/
    *.html                      the pages
    js/ajax.js, js/main.js      client-side calls to the servlets
    css/                        styling
```

The design keeps three layers apart: `mainClasses` is the domain model,
`db/tables` is the data-access layer that reads and writes it, and `servlets`
is the HTTP layer that the frontend calls. A request flows page → AJAX →
servlet → table class → database and back.

## Building and running

```
cd implementation/Hospital
mvn package
```

Deploy the resulting WAR to Tomcat, point the JDBC settings in
`DB_Connection.java` at your database, and run `InitDatabase` once to create the
schema. Then open the app at the Tomcat context root.

The frontend has an npm manifest (`package.json`); its dependencies install with
`npm install` and are intentionally not committed.

A design report is in `report.pdf`.
