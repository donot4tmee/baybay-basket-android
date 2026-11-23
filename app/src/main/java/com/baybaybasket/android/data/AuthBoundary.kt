package com.baybaybasket.android.data

data class AuthSession(
    val accessToken: String,
    val accountUuid: String,
    val role: String,
)

interface AuthBoundary {
    suspend fun signInWithGoogle(): AuthSession
    fun signOut()
}
