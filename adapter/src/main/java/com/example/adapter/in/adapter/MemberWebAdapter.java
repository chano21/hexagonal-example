package com.example.adapter.in.adapter;

import com.example.port.command.MemberCommand;
import com.example.port.in.MemberInPort;
import com.example.port.out.query.QueryMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberWebAdapter {

    MemberInPort memberInPort;

    @PostMapping(value = "/")
    public ResponseEntity<Void> memberJoin(MemberCommand.CreateMember createMember){
        memberInPort.memberJoin(createMember);
      return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/{memberId}")
    public ResponseEntity<QueryMember> memberJoin(@PathVariable Long memberId){
        memberInPort.queryMemberOne(memberId);
        return new ResponseEntity<QueryMember>(HttpStatus.CREATED);
    }

}
