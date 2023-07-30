package com.spring.start

import com.spring.start.member.Grade
import com.spring.start.member.Member
import org.junit.jupiter.api.Test

class AppConfigTest {
    @Test
    fun test() {
        val appConfig = AppConfig()
        val memberService = appConfig.memberService()
        val member = Member(1L, "memberA", Grade.VIP)
        memberService.join(member)

        val findMember = memberService.findMember(1L)
        println("new member = ${member.name}")
        println("find member = ${findMember!!.name}")
    }
}