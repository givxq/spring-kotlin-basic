package com.spring.start.order

import com.spring.start.discount.FixDiscountPolicy
import com.spring.start.member.MemoryMemberRepository

class OrderServiceImpl : OrderService{
    private val memberRepository = MemoryMemberRepository()
    private val discountPolicy = FixDiscountPolicy()
    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}