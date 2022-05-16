package com.example.port.in;
import com.example.port.command.MemberCommand;
import com.example.port.out.query.QueryMember;

public interface MemberInPort {
    void memberJoin(MemberCommand.CreateMember createMember);
    QueryMember queryMemberOne(Long memberId);
}
