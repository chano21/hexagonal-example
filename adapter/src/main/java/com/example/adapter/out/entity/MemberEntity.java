package com.example.adapter.out.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_member")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity extends BaseEntity {
    @Id
    @Column(name = "member_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberId;
    @Column
    String nickName;
    @Column
    String password;
}
