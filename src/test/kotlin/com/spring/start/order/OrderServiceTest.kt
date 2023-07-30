package com.spring.start.order

import com.spring.start.AppConfig
import com.spring.start.member.Grade
import com.spring.start.member.Member
import com.spring.start.member.MemberService
import com.spring.start.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private lateinit var memberService: MemberService
    private lateinit var orderService: OrderService

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }

    @Test
    fun createOrder() {
        val memberId = 1L
        val member = Member(memberId, "MemberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "ItemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }
}