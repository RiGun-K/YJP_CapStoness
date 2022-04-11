package com.example.yjp_capstone.repository.Member;

import com.example.yjp_capstone.domain.Member.Company;
import com.example.yjp_capstone.domain.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public List<Company> findCompanyByCCode(String CCode);
    public List<Company> findCompanyByMember(Member member);
}
