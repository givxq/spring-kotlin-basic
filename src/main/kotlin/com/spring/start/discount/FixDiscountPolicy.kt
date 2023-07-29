package com.spring.start.discount

import com.spring.start.member.Grade
import com.spring.start.member.Member

class FixDiscountPolicy : DiscountPolicy {
    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int =
        when (member.grade) {
            Grade.VIP -> discountFixAmount
            else -> 0
        }
}