package com.example.capstone.controller.Plan;


import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.Team;
import com.example.capstone.domain.Plan.Team_Member;
import com.example.capstone.dto.plan.TeamDto;
import com.example.capstone.repository.Member.MemberRepository;
import com.example.capstone.repository.Plan.TeamRepository;
import com.example.capstone.repository.Plan.Team_MemberRepository;
import com.example.capstone.service.PlanService;
import com.example.capstone.service.TeamService;
import com.example.capstone.service.Team_MemberService;
import org.springframework.http.converter.json.GsonBuilderUtils;
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
    public List<Team_Member> teamManagementPage(@PathVariable("mcode") Member mcode) {
        List<Team_Member> tm = team_memberRepository.findBymcode(mcode);
        if (tm.isEmpty()) {
            return null;
        } else return tm;
    }

    @GetMapping("/api/loadTeamMemberList/{teamName}")
    public List<Team_Member> loadTeamMemberList(@PathVariable("teamName") String teamName) {
        Optional<Team> teamCode = teamRepository.findByTeamName(teamName);
        System.out.println(teamCode.get());
        List<Team_Member> teamMcode = team_memberRepository.findByteamCode(teamCode.get());
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
    public String addTeamMember(@RequestBody Team_Member teamMember) {
        return team_memberService.addTeamMember(teamMember);
    }

    @PostMapping("/api/acceptTeam")
    public String acceptTeam(@RequestBody Team_Member teamMember) {
        team_memberService.acceptTeam(teamMember);
        return "y";
    }

    @PostMapping("/api/refuseTeam")
    public String refuseTeam(@RequestBody Team_Member teamMember) {
        team_memberService.refuseTeam(teamMember);
        return "y";
    }

    @PostMapping("/api/deleteTeam")
    public String deleteTeam(@RequestBody Team team) {
        teamService.deleteTeam(team);
        return "y";
    }

    @PostMapping("/api/loginedTeamCode")
    public Team_Member loginedTeamCode(@RequestBody Team_Member teamMember) {
        return team_memberService.loginedTeamCode(teamMember);
    }

    @GetMapping("/api/loadTeamPlans/{teamCode}")
    public List<Plan> loadTeamPlans(@PathVariable("teamCode") Long team) {
        //== test ==//
        TeamDto teamDto = TeamDto.builder()
                .teamCode(1L)
                .build();

        return team_memberService.loadTeamPlans(team);

    }

}