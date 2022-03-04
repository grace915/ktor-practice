package com.practice.plugins

import com.auth0.jwt.JWT
import com.practice.routing.v1Routing
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

fun Application.configureRouting() {

    routing {
        route("v1") {
            v1Routing()
        }
    }
    /*
    get("/") {
        call.respondText("Hello World!")
    }
    post("/login"){
        //println(call.parameters) 보통 파라미터로 안준다
       val user = call.receive<User>()
        println(user)
        call.respond(User("${user.id}${user.id}", "${user.password}${user.password}"))


        // xposed랑 db랑 연결?
        // jwt 다루는거
        // 카톡 로그인 구현 -> 앱 연동

    }
    route("user"){
        get("/login"){

        }
        post("/edit"){

        }
    }
}

     */
}

suspend inline fun <reified T : Any> PipelineContext<*, ApplicationCall>.receive(): T? {
    return try {
        call.receive()
    } catch (e: BadRequestException) {
        call.respondText("${e.message}", status = HttpStatusCode.BadRequest)
        null
    }
}
//end point에서만 getuserid를 사용가능
fun PipelineContext<*, ApplicationCall>.getUserId(): Int =
    call.principal<JWTPrincipal>()!!.payload.getClaim("userId").asInt()