package com.practice.routing.v1

import com.possiblee.kakaologin.network.body.SignUpBody
import com.practice.database.Database
import com.practice.database.entities.User
import com.practice.database.entities.Users.nickname
import com.practice.dto.Token
import com.practice.network.body.KakaoTokenInfoBody
import com.practice.network.client
import com.practice.plugins.makeServerAccessToken
import com.practice.plugins.receive
import com.practice.routing.v1.auth.kakaoRouting
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authRouting(){
    route("kakao"){
        kakaoRouting()
    }
    post("signup"){
        val signUpBody = receive<SignUpBody>() ?: return@post
        val kakaoTokenInfo: KakaoTokenInfoBody = client.get("https://kapi.kakao.com/v1/user/access_token_info") {
            headers {
                append(HttpHeaders.Authorization, "Bearer ${signUpBody.kakaoAccessToken}")
            }

        }.body()
        //?:는 앞이 null이면 실행되는것 엘비스널

        // 요청 잘못됨
        kakaoTokenInfo.msg?.let {
            return@post call.respond(status = HttpStatusCode.BadRequest, message = it)
        }

        println(signUpBody)

        // db에 넣기
        // todo 닉네임 유효성 검사 -> 한번에 하는게 나음(규칙 정해서)
        val user = Database.createUserByNickname(kakaoTokenInfo.id!!, signUpBody.nickname!!)
        call.respond(SignUpBody(serverAccessToken = makeServerAccessToken(user.id.value)))
    }
}