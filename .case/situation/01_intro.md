You've joined a small team maintaining an internal **users API** built on Javalin.
A downstream service that consumes `GET /users/{id}` started rejecting the responses:
its JSON client refuses to parse a body whose `Content-Type` is not
`application/json`.

The confusing part is that the endpoint returns something that *looks* like JSON —
the body has the right fields and values — yet the consumer still fails. The team
needs `GET /users/{id}` to advertise the correct content type so the integration
works again.
