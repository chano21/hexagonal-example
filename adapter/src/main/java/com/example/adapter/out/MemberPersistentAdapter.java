package com.example.adapter.out;


import com.example.adapter.out.entity.MemberEntity;
import com.example.adapter.out.repository.MemberRepository;
import com.example.common.exception.ErrorCode;
import com.example.common.exception.HexagonException;
import com.example.port.command.MemberCommand;
import com.example.port.out.MemberOutPort;
import com.example.port.out.query.QueryMember;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class MemberPersistentAdapter implements  MemberOutPort{

   private final EntityManager entityManager;
   private final MemberRepository memberRepository;

   @Transactional
   public void saveMember(MemberCommand.CreateMember createMember){
      memberRepository.findByNickName(createMember.getNickName())
              .ifPresent(m -> {
                 throw new HexagonException(ErrorCode.EXIST_NICKNAME);
              });
   MemberEntity memberEntity=   MemberEntity.builder()
              .nickName(createMember.getNickName())
              .password(createMember.getPassword())
              .build();
      entityManager.persist(memberEntity);
   }

   @Override
   public QueryMember findMemberOne(Long memberId) {
      Optional<MemberEntity> memberEntityOptional=
              Optional.of(entityManager.find(MemberEntity.class,memberId));
     MemberEntity memberEntity= memberEntityOptional.orElseThrow(() -> new HexagonException(ErrorCode.NOT_FOUND_MEMBER));
      QueryMember queryMember = QueryMember.builder()
              .nickName(memberEntity.getNickName())
              .memberId(memberEntity.getMemberId())
              .updatedAt(memberEntity.getUpdatedDate())
              .createdAt(memberEntity.getCreatedDate())
              .build();
      return queryMember;
   }
}
