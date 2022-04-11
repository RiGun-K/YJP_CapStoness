package com.example.yjp_capstone.service;


import com.example.yjp_capstone.domain.Plan.Checklist;
import com.example.yjp_capstone.repository.Plan.ChecklistRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChecklistService {

    private final ChecklistRepository checklistRepository;

    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }


    public void insertChecklist(Checklist checklist){
        System.out.println(checklist.getDetailCode());
        System.out.println(checklist.getCheckContent());

        checklistRepository.save(checklist);
        System.out.println("저장 성공");
    }

    public List<Checklist> loadChecklist(Checklist checklist){


       List<Checklist> ch= checklistRepository.findByDetailCode(checklist.getDetailCode());

    return ch;
    }
}
