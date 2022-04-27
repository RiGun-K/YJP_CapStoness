package com.example.capstone.service;


import com.example.capstone.domain.Plan.Team_Member;
import com.example.capstone.repository.Plan.Team_MemberRepository;
import org.springframework.stereotype.Service;
import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.Plan_detail;
import com.example.capstone.repository.Plan.PlanRepository;
import com.example.capstone.repository.Plan.Plan_detailRepository;
import com.example.capstone.repository.Plan.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Team_MemberService {
    private final TeamRepository teamRepository;
    private final Team_MemberRepository team_memberRepository;
    private final PlanRepository planRepository;

    public Team_MemberService(TeamRepository teamRepository, Team_MemberRepository team_memberRepository, PlanRepository planRepository) {
        this.teamRepository = teamRepository;
        this.team_memberRepository = team_memberRepository;
        this.planRepository = planRepository;
    }

    public void acceptTeam(Team_Member teamMember) {

        List<Team_Member> acceptionCheck = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeam(), teamMember.getMember());
        acceptionCheck.get(0).setAcception("y");
        team_memberRepository.findById(acceptionCheck.get(0).getMember().getMCode());
        team_memberRepository.save(acceptionCheck.get(0));
    }

    public void refuseTeam(Team_Member teamMember) {
        System.out.println("받아짐");
        List<Team_Member> acceptionCheck = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeam(), teamMember.getMember());
        team_memberRepository.delete(acceptionCheck.get(0));
        System.out.println("거절성공");
    }

    public String addTeamMember(Team_Member teamMember) {

        List<Team_Member> checkMember = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeam(), teamMember.getMember());
        if (checkMember.isEmpty()) {
            System.out.println("있는지 없는지 확인");
            System.out.println(teamMember.getTeamMemberCode());
            System.out.println(teamMember.getAcception());

            team_memberRepository.save(teamMember);
            System.out.println(teamMember.getTeamMemberCode());
            return "y";
        } else {
            System.out.println("존재하는 회원입니다");
            return "n";
        }

    }

    public Team_Member loginedTeamCode(Team_Member teamMember) {
        List<Team_Member> tm = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        return tm.get(0);
    }

    public List<Plan> loadTeamPlans(Long team) {
        List < Plan > plans = planRepository.findByTeamCodeTeamCode(team);
        return plans;

    }
}