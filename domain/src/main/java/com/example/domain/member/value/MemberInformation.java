package com.example.domain.member.value;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberInformation {
    String nickName;
    String password;
}
