package com.spring.start.member

interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: Long): Member?
}