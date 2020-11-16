package com.example.snail.SnailCore


class Greeting {
    fun greeting(): String {
        return Platform().userAgentHeader
    }
}
