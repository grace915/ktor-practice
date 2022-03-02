package com.practice.routing

import com.practice.routing.v1.authRouting
import io.ktor.server.routing.*

fun Route.v1Routing() {
    route("auth"){
        authRouting()
    }
}