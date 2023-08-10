package com.spring.start.lifecycle

class NetworkClient(private val url : String = "") {
    init {
        println("생성자 호출, url = + $url")
        connect()
        call("초기화 연결 메세지")

    }

    fun connect() = println("connect : $url")
    fun call(message: String) = println("call: $url message = $message")
    fun disconect() = println("close: $url")
}