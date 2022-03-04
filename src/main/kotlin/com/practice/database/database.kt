package com.practice.database

import com.practice.AWS_RDS_BASEURL
import com.practice.AWS_RDS_PASSWORD
import com.practice.AWS_RDS_PORT
import com.practice.AWS_RDS_USER
import com.practice.database.entities.User
import com.practice.database.entities.Users
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    //Database.connet("주소", "드라이버")
    Database.connect(
        "jdbc:mysql://$AWS_RDS_BASEURL:$AWS_RDS_PORT/unithon",
        driver = "com.mysql.cj.jdbc.Driver",
        user = AWS_RDS_USER,
        password = AWS_RDS_PASSWORD
    )
    // database 작업은 transaction안에서 해줘야한다.
    transaction{
        //SchemaUtils.create(Users) // object 넣어준다 -> table 생성(users가 없다면)
        // 있는지 없는지 찾아야해 kakaoId를 사용해서 -> pk아니여도 유니크지
        // USER가 수정되어도 바뀌지 않는다. create는

        SchemaUtils.createMissingTablesAndColumns(Users)

    }
}
object Database {
    fun findUserByKakaoId(kakaoId: Long) = transaction{
        User.find{ // USERS가 object라서 아마 함수를 클래스에 넣으려 여기 만들어진거 아닐까?
            Users.kakaoId eq kakaoId // 테이블에 있는 카카오 아이디와 내 아이디를 비교해서 찾는다
        }.firstOrNull()
    }
    fun createUserByNickname(kakaoId: Long, nickname: String) = transaction{
        User.new {
            this.kakaoId = kakaoId
            this.nickname = nickname
        }
    }

    fun changeUserNickname(userId: Int, nickname: String) = transaction {
        User.find {
            Users.id eq userId
        }.firstOrNull()?.nickname = nickname
    }
}