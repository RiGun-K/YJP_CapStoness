
package com.example.capstone.domain.Plan;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
public class Checklist implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long checklistCode;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "DETAIL_CODE")
    private PlanDetail detailCode;

    @Column
    private char checkState ='n';
    @Column
    private String checkContent;
}