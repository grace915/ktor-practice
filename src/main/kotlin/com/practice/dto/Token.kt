package com.practice.dto

@kotlinx.serialization.Serializable
data class Token(
    val kakaoAccessToken: String? = null,
    val serverAccessToken: String? = null,
)
