package com.example.port.command;
import lombok.Getter;

public abstract class MemberCommand {

    @Getter
    public static class CreateMember{
        String nickName;
        String password;
    }
}
