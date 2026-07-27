# Data Structure Project 2019

A movie database built up in phases, each phase re-implementing the same system
on a different data structure so their trade-offs can be compared directly.

The domain is movies and the users who watch them: the program parses an event
file, maintains lists of movies and users, and answers queries about them.

## Phases

| Phase | Structure | Directory |
| --- | --- | --- |
| 1 | Linked lists (sorted, unsorted, self-adjusting) | `phase1/` |
| 2 | Hash tables backed by linked lists | `phase2/` |
| 3 | Hash tables backed by binary search trees | `phase3/` |

Building the same movie and user lists three ways is the point: phase 1 shows
what a plain list costs on lookups, phase 2 speeds those up with hashing, and
phase 3 swaps the per-bucket lists for trees to keep the worst case bounded.

## Layout

| Directory | Contents |
| --- | --- |
| `parser/` | Reads the event file into movie and user records |
| `comparators/` | Orderings by id, year and rank |
| `phase1`–`phase3/` | The three implementations |
| `_main/`, `src/` | Drivers that run each phase |

## Building and running

```
javac -d out $(find src -name '*.java')
java -cp out <MainClass>
```

The `_main/` directory has a separate driver per phase (`listMain`, `hashListMain`,
`HashTreeMain`, …); pick the one for the phase you want to exercise.

JDK 8 or newer.
