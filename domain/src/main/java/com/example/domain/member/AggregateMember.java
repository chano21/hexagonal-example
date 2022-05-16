package com.example.domain.member;

import com.example.domain.member.value.MemberInformation;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AggregateMember {
    MemberInformation memberInformation;
}
