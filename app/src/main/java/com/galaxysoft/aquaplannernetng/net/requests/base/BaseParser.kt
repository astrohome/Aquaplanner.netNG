package com.galaxysoft.aquaplannernetng.net.requests.base

interface BaseParser<out O> {
    fun parse(data: ByteArray): List<O>
}