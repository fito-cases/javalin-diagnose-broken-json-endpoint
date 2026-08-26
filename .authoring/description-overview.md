## Overview

An internal users API built on Javalin returns `GET /users/{id}` responses that a downstream JSON client rejects: the body looks like JSON, but the `Content-Type` is wrong. Your job is to find and fix the defect.

## What you'll practice

- Applying the fact that `ctx.json()` serializes the object, stages the result, and sets `Content-Type: application/json` in a single call.
- Reading how the response is staged on the Javalin `Context` and flows through the handler chain.

## Getting started

Open the case on its starter branch, run `./gradlew test`, and read the failing content-type test. Fix the `GET /users/{id}` handler in `App.kt` so the suite passes, then open a pull request.