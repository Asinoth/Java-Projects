# Simple Java Exercises

Introductory object-oriented programming exercises from two academic years,
the first steps before the larger MVC projects.

| Directory | Year |
| --- | --- |
| `Exercises 2019-2020/` | First-year assignments A1 and A2, with the Eclipse project templates they were built from |
| `Exercises 2021/` | A later assignment template |

The `*_Template` and `Eclipse_Template_*` directories are the starting skeletons
handed out with each assignment; the `A1`, `A2` directories are the completed
work.

## Building

Each exercise is a standard Eclipse Java project. From an exercise's `src`:

```
javac -d out $(find src -name '*.java')
java -cp out <MainClass>
```

JDK 8 or newer.
