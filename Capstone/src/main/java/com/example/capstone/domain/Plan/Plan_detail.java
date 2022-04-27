package com.example.capstone.domain.Plan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Plan_detail{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long detailCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "detailCode",cascade = CascadeType.ALL)
    private List<Checklist> checklists = new ArrayList<Checklist>();

    @ManyToOne
    @JoinColumn(name = "planCode")
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

    public String getDetailName() {
        return detailName;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Long getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(Long detailCode) {
        this.detailCode = detailCode;
    }

    public Plan getPlanCode() {
        return planCode;
    }

    public void setPlanCode(Plan planCode) {
        this.planCode = planCode;
    }

    public String getDetailMemo() {
        return detailMemo;
    }

    public void setDetailMemo(String detailMemo) {
        this.detailMemo = detailMemo;
    }

    public String getDetailStart() {
        return detailStart;
    }

    public void setDetailStart(String detailStart) {
        this.detailStart = detailStart;
    }

    public String getDetailEnd() {
        return detailEnd;
    }

    public void setDetailEnd(String detailEnd) {
        this.detailEnd = detailEnd;
    }

    public int getDetailDay() {
        return detailDay;
    }

    public void setDetailDay(int detailDay) {
        this.detailDay = detailDay;
    }
}


/*package com.example.dongmin.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Plan_detail{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long detailCode;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="detailCode")
    private List<Checklist> checklists;

    @ManyToOne
    @JoinColumn(name = "planCode")
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

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Long getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(Long detailCode) {
        this.detailCode = detailCode;
    }

    public Plan getPlanCode() {
        return planCode;
    }

    public void setPlanCode(Plan planCode) {
        this.planCode = planCode;
    }

    public String getDetailMemo() {
        return detailMemo;
    }

    public void setDetailMemo(String detailMemo) {
        this.detailMemo = detailMemo;
    }

    public String getDetailStart() {
        return detailStart;
    }

    public void setDetailStart(String detailStart) {
        this.detailStart = detailStart;
    }

    public String getDetailEnd() {
        return detailEnd;
    }

    public void setDetailEnd(String detailEnd) {
        this.detailEnd = detailEnd;
    }

    public int getDetailDay() {
        return detailDay;
    }

    public void setDetailDay(int detailDay) {
        this.detailDay = detailDay;
    }
}*/