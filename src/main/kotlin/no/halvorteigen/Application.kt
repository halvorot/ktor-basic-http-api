package no.halvorteigen

import io.ktor.server.application.*
import no.halvorteigen.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
