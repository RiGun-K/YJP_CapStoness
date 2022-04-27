package com.example.capstone.domain.Plan;


import javax.persistence.*;
import java.util.List;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long planCode;

    @ManyToOne
    @JoinColumn(name= "TEAMCODE")
    private Team teamCode;

    @OneToMany
    @JoinColumn(name="planCode")
    private List<Plan_detail> planDetails;


    @Column
    private String planDestination;

    @Column
    private String planName;

    @Column
    private int planBudget;
    @Column
    private String planType;
    @Column
    private String planStart;

    @Column
    private String planEnd;

    @Column
    private String planUpdate;


    @Column
    private int planNumber;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getPlanCode() {
        return planCode;
    }

    public void setPlanCode(Long planCode) {
        this.planCode = planCode;
    }

    public Team getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(Team teamCode) {
        this.teamCode = teamCode;
    }

    public String getPlanDestination() {
        return planDestination;
    }

    public void setPlanDestination(String planDestination) {
        this.planDestination = planDestination;
    }

    public int getPlanBudget() {
        return planBudget;
    }

    public void setPlanBudget(int planBudget) {
        this.planBudget = planBudget;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getPlanStart() {
        return planStart;
    }

    public void setPlanStart(String planStart) {
        this.planStart = planStart;
    }

    public String getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(String planEnd) {
        this.planEnd = planEnd;
    }

    public String getPlanUpdate() {
        return planUpdate;
    }

    public void setPlanUpdate(String planUpdate) {
        this.planUpdate = planUpdate;
    }

    public int getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(int planNumber) {
        this.planNumber = planNumber;
    }
}