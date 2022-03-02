package com.practice.network.body

@kotlinx.serialization.Serializable
data class KakaoTokenInfoBody(
    val id: Long,
    val expiresInMillis: Long,
    val appId:Int,
    val msg: String? = null
)
