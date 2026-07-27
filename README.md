# Java Projects

Java coursework from university, spanning object-oriented design, data
structures, GUI applications built on the Model-View-Controller pattern, and a
full-stack database web application.

## Projects

| Project | Area | Summary |
| --- | --- | --- |
| [MVC Projects](MVC%20Projects/) | GUI / OOP | Eight desktop applications — board and card games, a calculator — each built on the Model-View-Controller pattern |
| [Data Structure Project 2019](Data%20Structure%20Project%202019/) | Data structures | A movie database implemented over linked lists, hash tables and binary search trees, in phases |
| [Simple Java Exercises](Simple%20Java%20Exercises/) | Fundamentals | Introductory OOP exercises from two academic years |
| [CSS Project with android functionality](CSS%20Project%20with%20android%20functionality/) | Web | A Java servlet / JSP emergency-reporting app with a mobile-styled front end |
| [Small Project on Databases and Web Apps using intelij](Small%20Project%20on%20Databases%20and%20Web%20Apps%20using%20intelij/) | Full-stack | A hospital management system: Java + Maven backend with a JavaScript front end |

Each project directory has its own README.

## Building

These were written in Eclipse, NetBeans and IntelliJ, but they build from the
command line too:

- **MVC and data-structures projects** are plain Java. Compile the sources under
  a project's `src/` directory with `javac` and run the class that holds `main`
  (usually named `Main` or the project name). Each project README says which.
- **The hospital web app** is a Maven project — `mvn package` in its
  `implementation/Hospital` directory.
- **The servlet/JSP app** deploys to a servlet container such as Tomcat.

A JDK 8 or newer is enough for the desktop projects.

## A note on these projects

These are coursework projects, cleaned up for presentation: IDE metadata,
compiled `.class` files, NetBeans and Maven build output, a committed
`node_modules` directory, a dumped Android icon pack, and Windows `Thumbs.db`
files have all been removed. That took the repository from roughly 43 MB and
5,500 files down to under 900 files of actual source, assets and documentation.

Some inline comments and UI text are in Greek, kept as originally written.
