package com.example.capstone.domain.Plan;

import com.example.capstone.domain.Member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeamMember {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long teamMemberCode;

   // @JsonIgnore
    @ManyToOne// (fetch = FetchType.LAZY)
    @JoinColumn(name = "MCODE")
    private Member mcode;

    // @JsonIgnore
    @ManyToOne// (fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAMCODE")
    private Team teamCode;

    @Column
    private char teamMemberAuthority;
    @Column
    private String acception="n";
}