package com.example.capstone.repository.Plan;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.TeamMember;

import com.example.capstone.domain.Plan.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface Team_MemberRepository extends JpaRepository<TeamMember, Long> {

     List<TeamMember> findBymcode(Member MCode);

     List<TeamMember> findByteamCode(Team teamCode);

     List<TeamMember> findByTeamCodeAndMcode(Team teamCode, Member mcode);

}

