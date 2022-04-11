
package com.example.yjp_capstone.domain.Plan;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Checklist implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long checklistCode;
    //ffasasd

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detailCode")
    private Plan_detail detailCode;


    @Column
    private char checkState ='n';

    @Column
    private String checkContent;


    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public Long getChecklistCode() {
        return checklistCode;
    }

    public void setChecklistCode(Long checklistCode) {
        checklistCode = checklistCode;
    }

    public Plan_detail getDetailCode() {
        return detailCode;
    }

    public char getCheckState() {
        return checkState;
    }

    public void setCheckState(char checkState) {
        this.checkState = checkState;
    }
}