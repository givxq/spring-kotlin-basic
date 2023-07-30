package com.spring.start

import com.spring.start.discount.DiscountPolicy
import com.spring.start.discount.FixDiscountPolicy
import com.spring.start.member.MemberRepository
import com.spring.start.member.MemberService
import com.spring.start.member.MemberServiceImpl
import com.spring.start.member.MemoryMemberRepository
import com.spring.start.order.OrderService
import com.spring.start.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun memberService(): MemberService =
        MemberServiceImpl(memberRepository())

    @Bean
    fun orderService(): OrderService =
        OrderServiceImpl(memberRepository(), discountPolicy())

    @Bean
    fun memberRepository(): MemberRepository =
        MemoryMemberRepository()

    @Bean
    fun discountPolicy(): DiscountPolicy =
        FixDiscountPolicy()
}