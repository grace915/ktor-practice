package com.practice


import com.practice.database.configureDatabase
import io.ktor.server.netty.*
import com.practice.plugins.*
import io.ktor.server.engine.*

fun main() {

    embeddedServer(Netty, port = PORT, host = HOST) {

        configureDatabase() // database 설정
        configureSecurity()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
