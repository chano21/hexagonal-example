package com.example.adapter.out.repository;


import com.example.adapter.out.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository
        extends JpaRepository<MemberEntity, Long> {
   Optional<MemberEntity> findByNickName(String nickName);
}

