package com.example.yjp_capstone.repository.Plan;

import com.example.yjp_capstone.domain.storage.Member.Member;
import com.example.yjp_capstone.domain.Plan.Team_Member;

import com.example.yjp_capstone.domain.Plan.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface Team_MemberRepository extends JpaRepository<Team_Member, Long> {

     List<Team_Member> findBymcode(Member MCode);

     List<Team_Member> findByteamCode(Team teamCode);

     List<Team_Member> findByTeamCodeAndMcode(Team teamCode, Member mcode);

}

