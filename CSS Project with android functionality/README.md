# Emergency reporting web app

A web application for reporting civil emergencies — accidents, incidents and
their locations — with a front end styled to look and behave like a mobile app.

## Stack

- **Backend** — Java servlets and JSP, packaged with Ant (`build.xml`)
- **Frontend** — HTML, CSS and JavaScript, laid out as a phone-style interface
  with screens for capturing photos, video, voice and location
- **Model** — a small domain layer (`ecivil.core`) with a `Member` type and
  `BloodType`/`Gender` enums, over a JDBC `DBConnection`

## Layout

```
Project/ecivil/
  build.xml                     Ant build
  src/java/
    RegisterServlet.java        handles sign-up
    Upload.java                 handles media upload
    ecivil/core/                domain model and DB connection
  web/
    *.html, *.jsp               the mobile-styled screens
    icons/                      the interface icons
```

The `web/` screens (`main`, `menu`, `message_edit`, `photo_shot`,
`voice_record`, …) are the phone-style UI; the servlets behind them handle
registration and media upload, and `ecivil.core` is the data model they read and
write.

## Building and running

Built with Ant and deployed to a servlet container such as Tomcat:

```
cd Project/ecivil
ant
```

Deploy the resulting WAR and point `DBConnection` at your database.

## Note

Some UI text and comments are in Greek, kept as originally written.
