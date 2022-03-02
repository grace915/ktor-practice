package com.practice

import com.auth0.jwt.algorithms.Algorithm

// 안바뀌는 정보 작성

const val HOST = "0.0.0.0"
const val PORT = 8082

const val JWT_ISSUER = "httpL//$HOST:$PORT"
const val JWT_SECRET = "RSAECRET"
val JWT_ALGORITHM = Algorithm.HMAC256(JWT_SECRET)

const val AWS_RDS_BASEURL = "new-manito.c9srcex7gxvr.ap-northeast-2.rds.amazonaws.com"
const val AWS_RDS_PORT = 3306
const val AWS_RDS_USER = "admin"
const val AWS_RDS_PASSWORD = "tlsakslEh"
