package com.spring.start.order

import com.spring.start.discount.DiscountPolicy
import com.spring.start.discount.FixDiscountPolicy
import com.spring.start.member.MemberRepository
import com.spring.start.member.MemoryMemberRepository

class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy
) : OrderService{
    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}