## Why this solution

The endpoint built its JSON by hand and sent it with `ctx.result(...)`, which leaves the
response `Content-Type` at Javalin's default `text/plain`. The fix is to serialize through
the Context: `ctx.json(User(id, "Ada"))`. One call serializes the object via the configured
`JsonMapper`, stages it as the result, and sets `Content-Type: application/json`.

## What the student should have noticed

The failing test asserts the *content type*, not the body — the body already looked correct.
The signal is that a JSON-shaped string is not the same as a JSON *response*: the content
type is part of the contract, and `ctx.json` owns both the body and the header.

## Common mistakes

- Hand-setting `ctx.header("Content-Type", "application/json")` while keeping the manual
  string. This passes the test but duplicates what `ctx.json` does and keeps the hand-rolled
  serialization — worth at most a partial score.
- Assuming `ctx.result()` infers the content type from the body. It does not; it defaults to
  `text/plain`.

## Assessment guidance

Full marks when the handler uses `ctx.json(...)` and the PR note explains that the single
call replaces both the manual result and the content-type header. A strong answer also notes
that the response is staged (not sent) until the handler chain completes, so the after-handler
can still decorate it.
