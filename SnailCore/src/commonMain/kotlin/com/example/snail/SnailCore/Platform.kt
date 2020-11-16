package com.example.snail.SnailCore

expect class Platform() {
    val platform: String
    val userAgentHeader: String
    fun request()
}