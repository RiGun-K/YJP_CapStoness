package com.example.capstone.service;


import com.example.capstone.domain.Plan.TeamMember;
import com.example.capstone.repository.Plan.Team_MemberRepository;
import org.springframework.stereotype.Service;
import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.repository.Plan.PlanRepository;
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

    public void acceptTeam(TeamMember teamMember) {

        List<TeamMember> acceptionCheck = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        acceptionCheck.get(0).setAcception("y");
        team_memberRepository.findById(acceptionCheck.get(0).getMcode().getMCode());
        team_memberRepository.save(acceptionCheck.get(0));
    }

    public void refuseTeam(TeamMember teamMember) {
        System.out.println("받아짐");
        List<TeamMember> acceptionCheck = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        team_memberRepository.delete(acceptionCheck.get(0));
        System.out.println("거절성공");
    }

    public String addTeamMember(TeamMember teamMember) {

        List<TeamMember> checkMember = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        if (checkMember.isEmpty()) {
            team_memberRepository.save(teamMember);
            return "y";
        } else {
            System.out.println("존재하는 회원입니다");
            return "n";
        }

    }

    public TeamMember loginedTeamCode(TeamMember teamMember) {
        List<TeamMember> tm = team_memberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        return tm.get(0);
    }

    public List<Plan> loadTeamPlans(Long team) {
        List < Plan > plans = planRepository.findByTeamCodeTeamCode(team);
        return plans;

    }
}