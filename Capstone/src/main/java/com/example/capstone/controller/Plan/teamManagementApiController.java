package com.example.capstone.controller.Plan;


import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.Team;
import com.example.capstone.domain.Plan.TeamMember;
import com.example.capstone.repository.Member.MemberRepository;
import com.example.capstone.repository.Plan.TeamRepository;
import com.example.capstone.repository.Plan.Team_MemberRepository;
import com.example.capstone.service.PlanService;
import com.example.capstone.service.TeamService;
import com.example.capstone.service.Team_MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class teamManagementApiController {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final Team_MemberRepository team_memberRepository;
    private final PlanService planService;
    private final Team_MemberService team_memberService;
    private final TeamService teamService;

    public teamManagementApiController(MemberRepository memberRepository, TeamRepository teamRepository, Team_MemberRepository team_memberRepository, PlanService planService, Team_MemberService team_memberService, TeamService teamService) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        this.team_memberRepository = team_memberRepository;
        this.planService = planService;
        this.team_memberService = team_memberService;
        this.teamService = teamService;
    }

    @PostMapping("/api/TeamManagementPage/{mcode}")
    public List<TeamMember> teamManagementPage(@PathVariable("mcode") Member mcode) {
        List<TeamMember> tm = team_memberRepository.findBymcode(mcode);
        if (tm.isEmpty()) {
            return null;
        } else return tm;
    }

    @GetMapping("/api/loadTeamMemberList/{teamName}")
    public List<TeamMember> loadTeamMemberList(@PathVariable("teamName") String teamName) {
        Optional<Team> teamCode = teamRepository.findByTeamName(teamName);
        System.out.println(teamCode.get());
        List<TeamMember> teamMcode = team_memberRepository.findByteamCode(teamCode.get());
        System.out.println(teamMcode.get(0));
        if (teamMcode.isEmpty()) {
            return null;
        } else return teamMcode;
    }

    @PutMapping("/api/addTeam")
    public String addTeam(@RequestBody Team tm) {
        Optional<Team> newTeamName = teamRepository.findByTeamName(tm.getTeamName());
        if (newTeamName.isEmpty()) {
            teamRepository.save(tm);
            return "y";
        } else {
            return "n";
        }
    }

    @PostMapping("api/addTeamMember")
    public String addTeamMember(@RequestBody TeamMember teamMember) {
        return team_memberService.addTeamMember(teamMember);
    }

    @PostMapping("/api/acceptTeam")
    public String acceptTeam(@RequestBody TeamMember teamMember) {
        team_memberService.acceptTeam(teamMember);
        return "y";
    }

    @PostMapping("/api/refuseTeam")
    public String refuseTeam(@RequestBody TeamMember teamMember) {
        team_memberService.refuseTeam(teamMember);
        return "y";
    }

    @PostMapping("/api/deleteTeam")
    public String deleteTeam(@RequestBody Team team) {
        teamService.deleteTeam(team);
        return "y";
    }

    @PostMapping("/api/loginedTeamCode")
    public TeamMember loginedTeamCode(@RequestBody TeamMember teamMember) {
        return team_memberService.loginedTeamCode(teamMember);
    }

    @GetMapping("/api/loadTeamPlans/{teamCode}")
    public List<Plan> loadTeamPlans(@PathVariable("teamCode") Long team) {
//        //== test ==//
//        TeamDto teamDto = TeamDto.builder()
//                .teamCode(1L)
//                .build();

        return team_memberService.loadTeamPlans(team);

    }

}