package com.practice.routing.v1

import com.practice.routing.v1.auth.kakaoRouting
import io.ktor.server.routing.*

fun Route.authRouting(){
    route("kakao"){
        kakaoRouting()
    }
}