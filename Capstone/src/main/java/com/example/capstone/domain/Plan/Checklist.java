
package com.example.capstone.domain.Plan;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Checklist implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long checklistCode;
    //ffasasd

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "detailCode")
    private Plan_detail detailCode;


    @Column
    private char checkState ='n';

    @Column
    private String checkContent;

    public Checklist(Long checklistCode, Plan_detail detailCode, char checkState, String checkContent) {
        this.checklistCode = checklistCode;
        this.detailCode = detailCode;
        this.checkState = checkState;
        this.checkContent = checkContent;
    }

    public void changeStateUpdate(char checkState){
        this.checkState = checkState;
    }


    @Override
    public String toString() {
        return "Checklist{" +
                "checklistCode=" + checklistCode +
                ", detailCode=" + detailCode +
                ", checkState=" + checkState +
                ", checkContent='" + checkContent + '\'' +
                '}';
    }


}