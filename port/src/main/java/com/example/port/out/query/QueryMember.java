package com.example.port.out.query;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class QueryMember {
    Long memberId;
    String nickName;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
