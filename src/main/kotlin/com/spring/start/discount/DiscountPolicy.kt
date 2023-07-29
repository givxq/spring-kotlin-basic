package com.spring.start.discount

import com.spring.start.member.Member

interface DiscountPolicy {
    fun discount(member: Member, price: Int): Int
}