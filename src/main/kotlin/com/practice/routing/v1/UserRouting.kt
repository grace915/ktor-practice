package com.practice.routing.v1

import com.practice.database.Database
import com.practice.plugins.getUserId
import com.practice.plugins.receive
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting(){
    patch("nickname"){
        Database.changeUserNickname(getUserId(), receive()!!)
        println(getUserId())
        call.respond(HttpStatusCode.OK, "Changed")
    }
}