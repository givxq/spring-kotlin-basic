package com.spring.start.discount

import com.spring.start.member.Grade
import com.spring.start.member.Member

class RateDiscountPolicy : DiscountPolicy {
    private val discountPercent: Int = 10
    override fun discount(member: Member, price: Int): Int =
        when (member.grade) {
            Grade.VIP -> price * discountPercent / 100
            else -> 0
        }
}