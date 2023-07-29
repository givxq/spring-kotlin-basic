package com.spring.start.order

import com.spring.start.member.Grade
import com.spring.start.member.Member
import com.spring.start.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private val memberService = MemberServiceImpl()
    private val orderService = OrderServiceImpl()

    @Test
    fun createOrder() {
        val memberId = 1L
        val member = Member(memberId, "MemberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "ItemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }
}