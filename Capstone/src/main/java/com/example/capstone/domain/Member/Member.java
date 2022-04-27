package com.example.capstone.domain.Member;


import javax.persistence.*;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long MCode;

    @Column(length = 50)
    private String MID;
    @Column(length = 50)
    private String MPass;
    @Column(length = 50)

    private String MNick;
    @Column(length = 50)

    private String MPH;
    @Column(length = 50)
    private String MMail;
    @Column(length = 50)
    private String Mzc;
    @Column(length = 50)
    private String MAdd;
    @Column(length = 50)

    private String MSC;
    @Column(length = 50)
    private String MSD;
    @Column(length = 50)
    private String MLD;
    @Column
    private String mname;


    public Member(long MCode, String MID, String MPass, String MMail, String MNick, String MPH, String mzc, String MAdd, String MSC, String MSD, String MLD) {
        this.MCode = MCode;
        this.MID = MID;
        this.MPass = MPass;
        this.MMail = MMail;
        this.MNick = MNick;
        this.MPH = MPH;
        Mzc = mzc;
        this.MAdd = MAdd;
        this.MSC = MSC;
        this.MSD = MSD;
        this.MLD = MLD;
    }

    public Member() {

    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public long getMCode() {
        return MCode;
    }

    public void setMCode(long MCode) {
        this.MCode = MCode;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getMPass() {
        return MPass;
    }

    public void setMPass(String MPass) {
        this.MPass = MPass;
    }

    public String getMMail() {
        return MMail;
    }

    public void setMMail(String MMail) {
        this.MMail = MMail;
    }

    public String getMNick() {
        return MNick;
    }

    public void setMNick(String MNick) {
        this.MNick = MNick;
    }

    public String getMPH() {
        return MPH;
    }

    public void setMPH(String MPH) {
        this.MPH = MPH;
    }

    public String getMzc() {
        return Mzc;
    }

    public void setMzc(String mzc) {
        Mzc = mzc;
    }

    public String getMAdd() {
        return MAdd;
    }

    public void setMAdd(String MAdd) {
        this.MAdd = MAdd;
    }

    public String getMSC() {
        return MSC;
    }

    public void setMSC(String MSC) {
        this.MSC = MSC;
    }

    public String getMSD() {
        return MSD;
    }

    public void setMSD(String MSD) {
        this.MSD = MSD;
    }

    public String getMLD() {
        return MLD;
    }

    public void setMLD(String MLD) {
        this.MLD = MLD;
    }
}