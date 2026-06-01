# helloWorld

Personal Java learning repository — design patterns, basics, and small algorithm demos.

Originally an Eclipse project from 2016–2017; now a Maven project with JDK 17.

## Requirements

- JDK 17+
- Maven 3.9+

## Build & test

```bash
mvn compile
mvn test
```

## Project layout

| Path | Description |
|------|-------------|
| `src/main/java/com/lip/hello/patterns/` | Design pattern examples |
| `src/main/java/com/lip/hello/basics/` | Java basics and utilities |
| `src/main/java/com/lip/hello/regex/` | Regular expression helpers |
| `src/main/java/com/lip/hello/algorithms/` | Small algorithm demos |
| `src/test/java/` | JUnit 5 tests |

## Patterns index

| Pattern | Package |
|---------|---------|
| Singleton | `patterns.singleton` |
| Factory (simple / static / multiple) | `patterns.factory.*` |
| Abstract factory | `patterns.abstractfactory` |
| Adapter (class / object / interface) | `patterns.adapter.*` |
| Bridge | `patterns.bridge` |
| Decorator | `patterns.decorator` |
| Observer | `patterns.observer` |
| Proxy (dynamic / static) | `patterns.proxy.*` |

## Run a single test

```bash
mvn -Dtest=HungryTypeTest test
```

## Notes

- Work-related scratch code, front-end snippets, and study notes were removed during cleanup.
- Some pattern packages only contain `package-info.java` placeholders (facade, multimode) — implementations can be added later.
