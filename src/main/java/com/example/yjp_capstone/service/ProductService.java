package com.example.yjp_capstone.service;

import com.example.yjp_capstone.domain.Member.Member;
import com.example.yjp_capstone.dto.Product.MenuDTO;
import com.example.yjp_capstone.repository.Member.MemberRepository;
import com.example.yjp_capstone.repository.Product.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProductService {
    private final com.example.yjp_capstone.repository.Member.MemberRepository MemberRepository;
    private MemberRepository memberRepository;

    private MenuRepository menuRepository;

    @Autowired
    public ProductService(MemberRepository memberRepository, MenuRepository menuRepository) {
        this.MemberRepository = memberRepository;
        this.menuRepository = menuRepository;
    }


    public Member findByMemberId(long userid){
        Optional<Member> memberfind = memberRepository.findById(userid);
        return memberfind.get();
    }

//    @Transactional
//    public int savePost(MenuDTO menuDTO) {
//        return menuRepository.save(menuDTO.toEntity()).getMenuid();
//
//    }
}
