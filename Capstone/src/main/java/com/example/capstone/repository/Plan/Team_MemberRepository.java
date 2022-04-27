package com.example.capstone.repository.Plan;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.Team_Member;

import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface Team_MemberRepository extends JpaRepository<Team_Member, Long> {

     List<Team_Member> findBymcode(Member MCode);

     List<Team_Member> findByteamCode(Team teamCode);

     List<Team_Member> findByTeamCodeAndMcode(Team teamCode, Member mcode);

}

