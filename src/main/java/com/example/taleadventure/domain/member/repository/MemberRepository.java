package com.example.taleadventure.domain.member.repository;

import com.example.taleadventure.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findBySocialId(String socialId);
}
