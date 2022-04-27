package com.example.capstone.domain.Plan;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="TEAMCODE")
    private Long teamCode;

    @Column(name="TEAMNAME")
    private String teamName;

    @Column
    private char teamState;


    @Column
    private String teamMaster;

    public String getTeamMaster() {
        return teamMaster;
    }

    public void setTeamMaster(String teamMaster) {
        this.teamMaster = teamMaster;
    }
    public Long getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(Long teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public char getTeamState() {
        return teamState;
    }

    public void setTeamState(char teamState) {
        this.teamState = teamState;
    }



    @Override
    public String toString() {
        return "Team{" +
                "teamCode='" + teamCode + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teamState=" + teamState +
                '}';
    }
}