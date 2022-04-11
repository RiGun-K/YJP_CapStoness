package com.example.yjp_capstone.controller.Member;

import com.example.yjp_capstone.domain.Member.Company;
import com.example.yjp_capstone.domain.Member.Member;
import com.example.yjp_capstone.repository.Member.CompanyRepository;
import com.example.yjp_capstone.repository.Member.MemberRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/login")
    public Member login(@RequestBody HashMap<String, String> loginMem){
        List<Member> member = memberRepository.findByMID(loginMem.get("MID"));
        if(member.isEmpty()){
            return null;
        }

        if(member.get(0).getMPass().toString().equals(loginMem.get("MPASS"))){
            return member.get(0);
        }else{
            return null;
        }

    }

    @PostMapping ("/signUp")
    public Boolean signUp(@RequestBody HashMap<String, String> signUp){
        List<Member> memberCh = memberRepository.findByMID(signUp.get("MID"));
        if(!memberCh.isEmpty()){
            return false;
        }

        Member member = new Member();
        member.setMID(signUp.get("MID"));
        member.setMPass(signUp.get("MPASS"));
        member.setMNick(signUp.get("MNick"));
        member.setMzc(signUp.get("MZC"));
        member.setMAdd(signUp.get("MAdd"));
        member.setMPH(signUp.get("MPH"));
        member.setMMail(signUp.get("MEmail"));
        member.setMSC(signUp.get("MSC"));
        member.setMSD(LocalDate.now().toString());

        memberRepository.save(member);
        return true;
    }

    @PostMapping("chagneMSC")
    public Boolean changeMSC(@RequestBody HashMap<String, String> updataData){
        List<Member> memberCh = memberRepository.findByMID(updataData.get("MID"));

        if(memberCh.isEmpty()){
            return false;
        }

        memberCh.get(0).setMSC(updataData.get("MSC"));
        memberRepository.save(memberCh.get(0));
        return true;
    }

    @PostMapping("memberUpdate")
    public Boolean memberUpdate(@RequestBody HashMap<String, String> updataData){
        List<Member> memberCh = memberRepository.findByMID(updataData.get("MID"));

        if(memberCh.isEmpty()){
            return false;
        }

        memberCh.get(0).setMNick(updataData.get("MNick"));
        memberCh.get(0).setMzc(updataData.get("MZC"));
        memberCh.get(0).setMAdd(updataData.get("MAdd"));
        memberCh.get(0).setMPH(updataData.get("MPH"));
        memberCh.get(0).setMMail(updataData.get("MEmail"));
        memberRepository.save(memberCh.get(0));

        return true;
    }

    @PostMapping("deleteMem")
    public Boolean deleteMem(@RequestBody HashMap<String, String> updataData){
        List<Member> memberCh = memberRepository.findByMID(updataData.get("MID"));

        if(memberCh.isEmpty()){
            return false;
        }

        memberCh.get(0).setMSC("0");
        memberCh.get(0).setMLD(LocalDate.now().toString());
        memberRepository.save(memberCh.get(0));

        return true;
    }

    @PostMapping("/userCheck")
    public Boolean userCheck(@RequestBody HashMap<String, String> signUp) {
        List<Member> memberCh = memberRepository.findByMID(signUp.get("MID"));
        if (memberCh.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    @PostMapping ("/nameCheck")
    public Boolean nameCheck(@RequestBody HashMap<String, String> signUp) {
        List<Member> memberCh = memberRepository.findByMNick(signUp.get("MNick"));
        System.out.println(signUp);
        System.out.println(memberCh.isEmpty());

        if (memberCh.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("companyCodeCheck")
    public Boolean companyCodeCheck(@RequestBody HashMap<String, String> company){
        List<Company> companyList = companyRepository.findCompanyByCCode(company.get("CCode"));

        if(companyList.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("signCompany")
    public Boolean signCompany(@RequestBody HashMap<String, String> signUp){
        List<Member> memberCh = memberRepository.findByMID(signUp.get("MID"));
        List<Company> com = companyRepository.findCompanyByMember(memberCh.get(0));
        if(!com.isEmpty()){
            return false;
        }

        Company company = new Company();
        company.setMember(memberCh.get(0));
        company.setCCode(signUp.get("CCode"));
        company.setCName(signUp.get("CName"));
        company.setCEO(signUp.get("CEO"));
        company.setCZC(signUp.get("CZC"));
        company.setCAdd(signUp.get("CAdd"));
        company.setCph(signUp.get("Cph"));
        company.setCEmail(signUp.get("CEmail"));
        company.setChp(signUp.get("Chp"));
        company.setCst(LocalDate.now().toString());

        memberCh.get(0).setMSC("2");
        memberRepository.save(memberCh.get(0));
        companyRepository.save(company);
        return true;
    }

    @PostMapping("loginCheck")
    public Boolean loginCheck(@RequestBody HashMap<String, String> check){
        List<Member> memberCh = memberRepository.findByMID(check.get("MID"));
        if(!memberCh.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @PostMapping("getMember")
    public Member getMember(@RequestBody HashMap<String, String> check){
        List<Member> memberCh = memberRepository.findByMID(check.get("MID"));
        if(!memberCh.isEmpty()){
            return memberCh.get(0);
        }else {
            return null;
        }
    }
    @GetMapping("getAllmember")
    public List<Member> getAllmember(){
        List<Member> members = memberRepository.findAll();

        return members;
    }


}
