package com.example.memberproject.repository;

import com.example.memberproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    List<Member> findAll();
}