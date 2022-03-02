package com.practice.plugins

import com.practice.routing.v1Routing
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        route("v1"){
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
