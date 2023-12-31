package com.spring.start.member

class MemberServiceImpl(
    private val memberRepository: MemberRepository
) : MemberService {
//    private val memberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
       return memberRepository.findById(memberId)
    }
}