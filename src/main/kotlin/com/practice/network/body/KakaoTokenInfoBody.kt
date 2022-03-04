package com.practice.network.body

@kotlinx.serialization.Serializable
data class KakaoTokenInfoBody(
    val id: Long? = null,
    val expiresInMillis: Long? = null,
    val appId:Int? = null,
    val msg: String? = null
)
