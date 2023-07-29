package com.spring.start.order

data class Order(
    var memberId: Long,
    var itemName: String,
    var itemPrice: Int,
    var discountPrice: Int,
) {
    fun calculatePrice() = itemPrice - discountPrice
}