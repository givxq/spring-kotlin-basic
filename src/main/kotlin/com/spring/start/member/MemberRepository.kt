package com.spring.start.member

interface MemberRepository {
    fun save(member: Member)
    fun findById(memberId: Long): Member?
}