package no.halvorteigen.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import no.halvorteigen.routes.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        listOrdersRoute()
        getOrderRoute()
        createOrderRoute()
        totalizeOrderRoute()
    }
}
