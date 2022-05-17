package com.example.port.out;


import com.example.port.command.MemberCommand;
import com.example.port.out.query.QueryMember;

public interface MemberOutPort {
    void saveMember (MemberCommand.CreateMember createMember);
    QueryMember findMemberOne (Long memberId);
}
