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
public class MemberUpdateForm {
    private Long id;
    private String email;
    private String password;

    // 수정 폼 데이터를 Member 엔티티로 변환한다.
    public Member toEntity() {
        return new Member(id, email, password);
    }

    public void logInfo() {
        log.info("id: {}, email: {}, password: {}", id, email, password);
    }
}
