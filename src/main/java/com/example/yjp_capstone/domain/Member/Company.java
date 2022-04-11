package com.example.yjp_capstone.domain.Member;

import javax.persistence.*;

@Entity
@Table(name="Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CC;

    @OneToOne
    @JoinColumn(name = "MCode")
    private Member member;

    @Column
    private String CCode;

    @Column
    private String CName;

    @Column
    private String CEO;

    @Column
    private String Chp;

    @Column
    private String CZC;

    @Column
    private String CAdd;

    @Column
    private String Cph;

    @Column
    private String CEmail;

    @Column
    private String Cst;

    public Company(){

    }

    public Company(long CC, Member member, String CCode, String CName, String CEO, String chp, String CZC, String CAdd, String cph, String CEmail, String cst) {
        this.CC = CC;
        this.member = member;
        this.CCode = CCode;
        this.CName = CName;
        this.CEO = CEO;
        Chp = chp;
        this.CZC = CZC;
        this.CAdd = CAdd;
        Cph = cph;
        this.CEmail = CEmail;
        Cst = cst;
    }

    public long getCC() {
        return CC;
    }

    public void setCC(long CC) {
        this.CC = CC;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getCCode() {
        return CCode;
    }

    public void setCCode(String CCode) {
        this.CCode = CCode;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCEO() {
        return CEO;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public String getChp() {
        return Chp;
    }

    public void setChp(String chp) {
        Chp = chp;
    }

    public String getCZC() {
        return CZC;
    }

    public void setCZC(String CZC) {
        this.CZC = CZC;
    }

    public String getCAdd() {
        return CAdd;
    }

    public void setCAdd(String CAdd) {
        this.CAdd = CAdd;
    }

    public String getCph() {
        return Cph;
    }

    public void setCph(String cph) {
        Cph = cph;
    }

    public String getCEmail() {
        return CEmail;
    }

    public void setCEmail(String CEmail) {
        this.CEmail = CEmail;
    }

    public String getCst() {
        return Cst;
    }

    public void setCst(String cst) {
        Cst = cst;
    }
}

