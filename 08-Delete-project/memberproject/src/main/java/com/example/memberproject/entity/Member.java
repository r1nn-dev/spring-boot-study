package com.example.memberproject.entity;

import com.example.memberproject.dto.MemberUpdateForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Slf4j
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void logInfo() {
        log.info("Member id: {}, email: {}, password: {}", id, email, password);
    }

    public void patch(MemberUpdateForm memberUpdateForm) {
        if (memberUpdateForm.getEmail() != null) {
            this.email = memberUpdateForm.getEmail();
        }

        if (memberUpdateForm.getPassword() != null) {
            this.password = memberUpdateForm.getPassword();
        }
    }
}