package com.fito.cases.brokenjson

import io.javalin.Javalin
import io.javalin.http.Context

/** The resource this endpoint exposes. With the default Jackson mapper it serializes as-is. */
data class User(val id: Int, val name: String)

/**
 * Handler for `GET /users/{id}`.
 *
 * The endpoint is supposed to return the user as a JSON document with
 * `Content-Type: application/json`. A failing test in `AppTest` proves it does not yet —
 * diagnosing why is the case.
 */
fun getUser(ctx: Context) {
    val id = ctx.pathParamAsClass("id", Int::class.java).get()
    val user = User(id, "Ada")
    ctx.result("""{"id":${user.id},"name":"${user.name}"}""")
}

/** Builds the (unstarted) Javalin app so tests can drive it without binding a port. */
fun createApp(): Javalin =
    Javalin.create { config ->
        config.routes.get("/users/{id}", ::getUser)
        // An after-handler runs after the endpoint on the same Context — the request flows
        // through a handler chain, so this stage can read and decorate the staged response.
        config.routes.after { ctx -> ctx.header("X-Served-By", "fito-broken-json-case") }
    }

fun main() {
    createApp().start(7070)
}
