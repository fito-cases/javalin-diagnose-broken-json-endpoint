The project is a minimal Javalin 7 service with a single endpoint, `GET /users/{id}`.
It builds and starts, but one test fails: the endpoint returns a JSON-looking body with
the wrong `Content-Type`. The handler currently writes the response from a hand-built
string instead of serializing through the Context.
