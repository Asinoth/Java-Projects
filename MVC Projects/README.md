# MVC Projects

A series of desktop applications, each built on the **Model-View-Controller**
pattern: the model holds the game state and rules, the view draws the interface
in Swing, and the controller wires user input to model updates and refreshes the
view. Keeping the three apart is the point of the exercise — the same model can
be driven by a different view, and the game logic can be tested without a UI.

Most are board or card games; the recurring themes are Greek history and
mythology.

| Project | What it is |
| --- | --- |
| MVC Project 2019 May | A Minoan-themed card game (the Phaistos Disc, jewels of Malia, the Snake Goddess) |
| MVC Project 2019 June | A music composition tool — atonal, free and algorithmic composition, built on the JFugue library |
| MVC Project 2020 May | A collection of card games (Mahjong, Full House and others) behind a shared graphical UI |
| MVC Project 2020 June | *Amphipolis*, an archaeology board game (amphorae, caryatids, sphinxes, mosaics), plus a standalone MVC calculator |
| MVC Project 2021 May | *Payday*, the board game — days, bills, mail and dice |
| MVC Project 2021 June | *Family Casino Night*, a property-and-dealing board game |
| MVC Project 2022 May | A revised take on the Minoan card game |
| MVC Project February 2022 | A Knossos labyrinth game — Ariadne, the Minotaur, frescoes and findings |

## Structure

Every project separates its code along the pattern, typically:

```
src/
  model/       game state and rules
  view/        Swing components and rendering
  controller/  input handling and the game loop
  resources/   card and tile images
```

Several also ship design documentation alongside the code — UML class diagrams
(`.ucls`, `.uml`), and PDF reports describing the design decisions.

## Building and running

Each project is self-contained. From inside one, compile everything under `src`
and run its entry point (usually `Main`):

```
javac -d out $(find src -name '*.java')
java -cp out:src Main        # keep src on the classpath for the image resources
```

JDK 8 or newer. The 2019 June music project additionally needs the JFugue
library on the classpath.

## Note

Some class names, comments and UI text are in Greek or transliterated Greek,
kept as originally written for the coursework.
