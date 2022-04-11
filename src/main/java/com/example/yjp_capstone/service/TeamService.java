package com.example.yjp_capstone.service;


import com.example.yjp_capstone.domain.Plan.Team;
import com.example.yjp_capstone.repository.Plan.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TeamService {

    public void deleteTeam(Team team){
        System.out.println(team+"aaaaaaaaaaaaaaa");
        teamRepository.delete(team);
    }



    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}