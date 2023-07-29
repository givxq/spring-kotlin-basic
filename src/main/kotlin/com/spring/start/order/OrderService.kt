package com.spring.start.order

interface OrderService {
    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}