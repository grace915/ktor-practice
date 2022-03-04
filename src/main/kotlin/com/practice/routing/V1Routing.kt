package com.practice.routing

import com.practice.routing.v1.authRouting
import com.practice.routing.v1.userRouting
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Route.v1Routing() {
    route("auth"){
        authRouting()
    }
    // 로그인이 되어야만 할수있는거지

    authenticate("auth-jwt") {
        route("user"){
            userRouting()
        }
    }



}