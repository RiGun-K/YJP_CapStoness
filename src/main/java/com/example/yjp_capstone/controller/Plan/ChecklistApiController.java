package com.example.yjp_capstone.controller.Plan;


import com.example.yjp_capstone.domain.Plan.Checklist;
import com.example.yjp_capstone.service.ChecklistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ChecklistApiController {

    private final ChecklistService checklistService;

    public ChecklistApiController(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }


    @PutMapping("/api/insertChecklist")
    public void insertChecklist(@RequestBody Checklist checklist){
        System.out.println(checklist.getDetailCode());
        System.out.println(checklist.getCheckContent());
        checklistService.insertChecklist(checklist);
    }

@PostMapping("/api/loadChecklist")
    public List<Checklist> loadChecklist (@RequestBody  Checklist checklist){
    System.out.println(checklist.getDetailCode());
    System.out.println(checklist.getDetailCode());
    System.out.println("체크리스트 로드 받아짐");
    return checklistService.loadChecklist(checklist);
}
}
