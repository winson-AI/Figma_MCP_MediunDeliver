package com.example.mediundeliver

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform