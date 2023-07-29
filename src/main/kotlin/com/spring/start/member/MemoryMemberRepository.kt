package com.spring.start.member

import java.util.concurrent.ConcurrentHashMap

class MemoryMemberRepository: MemberRepository {
    private val store: MutableMap<Long, Member> = ConcurrentHashMap()

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member? {
        return store[memberId]
    }
}