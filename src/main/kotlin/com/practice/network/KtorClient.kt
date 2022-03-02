package com.practice.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


val client = HttpClient(CIO) {
    install(ContentNegotiation){
        json(Json{
            //isLenient = true
            ignoreUnknownKeys = true

        })
    }
}
