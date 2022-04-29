package com.example.yjp_capstone.repository.Member;

import com.example.yjp_capstone.domain.storage.Member.Company;
import com.example.yjp_capstone.domain.storage.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Optional<Company> findCompanyByCCode(String CCode);
    public Optional<Company> findCompanyByMember(Member member);
}
