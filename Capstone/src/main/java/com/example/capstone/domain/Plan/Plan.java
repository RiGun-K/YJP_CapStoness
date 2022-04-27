package com.example.capstone.domain.Plan;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column
    private int planTotalDate;


}