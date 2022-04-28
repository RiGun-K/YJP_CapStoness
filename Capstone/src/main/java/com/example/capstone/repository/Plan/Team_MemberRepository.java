package com.example.capstone.repository.Plan;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.TeamMember;

import com.example.capstone.domain.Plan.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface Team_MemberRepository extends JpaRepository<TeamMember, Long> {

     @EntityGraph(attributePaths = {"teamCode"})
     List<TeamMember> findByMcode(Member MCode);

     @EntityGraph(attributePaths = {"mcode"})
     List<TeamMember> findByteamCode(Team teamCode);

     @EntityGraph(attributePaths = {"teamCode","mcode"})
     List<TeamMember> findByTeamCodeAndMcode(Team teamCode, Member mcode);
}

