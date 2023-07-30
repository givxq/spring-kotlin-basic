package com.spring.start.member

import com.spring.start.AppConfig
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext


class MemberServiceTest {

    private lateinit var memberService: MemberService

    @BeforeEach
    fun beforeEach() {
        // 1. Java Code
//        val appConfig = AppConfig()
//        memberService = appConfig.memberService()

        // 2. Spring Code
        val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
        memberService = applicationContext.getBean("memberService", MemberService::class.java)
    }

    @Test
    fun join() {
        // given
        val member = Member(1L, "memberA", Grade.VIP)

        // when
        memberService.join(member)
        val findMember = memberService.findMember(1L)

        // then
        Assertions.assertThat(member).isEqualTo(findMember)
    }
}