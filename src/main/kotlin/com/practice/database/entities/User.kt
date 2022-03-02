package com.practice.database.entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

// 테이블 명명
object Users: IntIdTable(){
    val kakaoId = long("kakaoId").nullable().uniqueIndex()
}
// entity는 개체라고 생각하면 된다.
// Users안에 하나씩 있는 user인거지. 여러개
// object는 딱 하나있고 User은 그안에 여러개 있는 친구들

class User(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<User>(Users)
    var kakaoId by Users.kakaoId
}