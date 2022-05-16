package com.example.domain.member.service;

import com.example.port.command.MemberCommand;
import com.example.port.in.MemberInPort;
import com.example.port.out.MemberOutPort;
import com.example.port.out.query.QueryMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberInPort {

    MemberOutPort memberOutPort;

    @Override
    public void memberJoin(MemberCommand.CreateMember createMember) {
        memberOutPort.saveMember(createMember);
    }

    @Override
    public QueryMember queryMemberOne(Long memberId) {
         return  memberOutPort.findMemberOne(memberId);
    }
}
