package com.fito.cases.brokenjson

import io.javalin.testtools.JavalinTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun `GET users-id responds with the application-json content type`() {
        JavalinTest.test(createApp()) { _, client ->
            val response = client.get("/users/1")
            assertEquals(200, response.code)
            val contentType = response.headers().get("Content-Type").orEmpty()
            assertTrue(
                contentType.any { it.contains("application/json") },
                "expected a Content-Type of application/json but was <$contentType>",
            )
        }
    }

    @Test
    fun `GET users-id returns the serialized user`() {
        JavalinTest.test(createApp()) { _, client ->
            val body = client.get("/users/1").body.string()
            assertTrue(body.contains("\"id\":1"), "expected id field in <$body>")
            assertTrue(body.contains("\"name\":\"Ada\""), "expected name field in <$body>")
        }
    }
}
