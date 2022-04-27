package com.example.capstone.domain.Plan;

import com.example.capstone.domain.Member.Member;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Team_Member {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long teamMemberCode;

    @ManyToOne
    @JoinColumn(name = "MCODE")
    private Member mcode;

    @ManyToOne
    @JoinColumn(name = "TEAMCODE")
    private Team teamCode;


    @Column
    private char teamMemberAuthority;

    @Column
    private String acception="n";


    public Member getMember(){
        return mcode;
    }

    public Team getTeam(){
        return teamCode;
    }
    public Team getTeamCode() {
        return teamCode;
    }
    public void setTeamCode(Team teamCode) {
        this.teamCode = teamCode;
    }


    public String getAcception() {
        return acception;
    }

    public void setAcception(String acception) {
        this.acception = acception;
    }

    public Long getTeamMemberCode() {
        return teamMemberCode;
    }

    public void setTeamMemberCode(Long teamMemberCode) {
        this.teamMemberCode = teamMemberCode;
    }

    public Member getMcode() {
        return mcode;
    }

    public void setMcode(Member mcode) {
        this.mcode = mcode;
    }




    public char getTeamMemberAuthority() {
        return teamMemberAuthority;
    }

    public void setTeamMemberAuthority(char teamMemberAuthority) {
        this.teamMemberAuthority = teamMemberAuthority;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "teamMemberCode=" + teamMemberCode +
                ", mcode=" + mcode +
                ", teamCode=" + teamCode +

                ", teamMemberAuthority=" + teamMemberAuthority +
                '}';
    }
}