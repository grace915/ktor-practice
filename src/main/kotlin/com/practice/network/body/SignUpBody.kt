package com.possiblee.kakaologin.network.body

@kotlinx.serialization.Serializable
data class SignUpBody(
    val kakaoAccessToken: String? = null,
    val serverAccessToken: String? = null,
    val nickname: String? = null,
)
