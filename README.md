# Diagnosing a broken Javalin JSON endpoint

A Fito **diagnostic** case. A minimal Javalin 7 service exposes `GET /users/{id}`, but the
endpoint returns a JSON-shaped body with the wrong `Content-Type`. Find and fix the defect
so the response is served as `application/json`.

The learning artifacts live in [`.case/`](.case/). Prefer opening the case in the Fito TUI
over reading ahead:

```
pi run /fito-case-open <case-uuid>
```

## Layout

- `.case/` — the Fito case definition (situation, task, rubric, competencies, solution notes)
- `src/main/kotlin/com/fito/cases/brokenjson/App.kt` — the Javalin app (the defect lives here)
- `src/test/kotlin/com/fito/cases/brokenjson/AppTest.kt` — the failing test that demonstrates the bug

## Branches

- `v1.0.0` — the starter state students fork (one failing test)
- `case/solution-v1.0.0` — the reference solution

## Run the tests

```
./gradlew test
```
