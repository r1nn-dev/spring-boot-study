package com.example.memberproject.dto;

import com.example.memberproject.entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class MemberForm {
    private String email;
    private String password;

    // 회원가입 폼 데이터를 Member 엔티티로 변환한다.
    public Member toEntity() {
        return new Member(email, password);
    }

    public void logInfo() {
        log.info("email: {}, password: {}", email, password);
    }
}
