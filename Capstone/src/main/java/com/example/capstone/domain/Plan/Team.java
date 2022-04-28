package com.example.capstone.domain.Plan;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="TEAMCODE")
    private Long teamCode;

    @OneToMany(mappedBy = "teamCode",cascade = {CascadeType.ALL},orphanRemoval = true)
    private List<TeamMember> teamMembers = new ArrayList<>();

    @Column
    private String teamName;
    @Column
    private char teamState;
    @Column
    private String teamMaster;




}