package com.example.capstone.domain.Plan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Plan_detail{


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long detailCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "detailCode",cascade = CascadeType.ALL)
    private List<Checklist> checklists = new ArrayList<Checklist>();

    @ManyToOne
    @JoinColumn(name = "PLAN_CODE")
    private Plan planCode;

    @Column
    private  String detailName;
    @Column
    private String detailMemo;
    @Column
    private String detailStart;
    @Column
    private String detailEnd;
    @Column
    private int detailDay;

}