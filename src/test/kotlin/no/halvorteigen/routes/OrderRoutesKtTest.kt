package no.halvorteigen.routes

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import no.halvorteigen.models.OrderItem
import no.halvorteigen.models.orderStorage
import kotlin.test.Test
import kotlin.test.assertEquals

class OrderRoutesKtTests {

    @Test
    fun shouldReturnOrderNotFound() = testApplication {

        // Act
        val response = client.get("/order/2020-04-06-01")

        // Assert
        assertEquals(
            "Not Found",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.NotFound, response.status)
    }


    @Test
    fun shouldReturnOrderWhenExists() = testApplication {
        // Arrange
        orderStorage.add(
            no.halvorteigen.models.Order(
                "2020-04-06-01",
                listOf(
                    OrderItem("item1", 1, 10.0)
                )
            )
        )

        // Act
        val response = client.get("/order/2020-04-06-01")

        // Assert
        assertEquals(
            """{"number":"2020-04-06-01","contents":[{"item":"item1","amount":1,"price":10.0}]}""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)

        // Cleanup
        orderStorage.clear()
    }
}