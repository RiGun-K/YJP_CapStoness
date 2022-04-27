package com.example.capstone.controller.Plan;


import com.example.capstone.domain.Plan.Checklist;
import com.example.capstone.service.ChecklistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ChecklistApiController {

    private final ChecklistService checklistService;

    public ChecklistApiController(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }


    @PutMapping("/api/insertChecklist")
    public void insertChecklist(@RequestBody Checklist checklist){
        System.out.println(checklist.getDetailCode().getDetailCode());
        System.out.println(checklist.getCheckContent());
        checklistService.insertChecklist(checklist);
    }

@PostMapping("/api/loadChecklist")
    public List<Checklist> loadChecklist (@RequestBody  Checklist checklist){
    System.out.println("hihhhhhhhhhhhhhhh");
        return checklistService.loadChecklist(checklist);
}

@PutMapping("/api/updateState")
    public Optional<Checklist> updateState(@RequestBody Checklist checklistCode){
        return checklistService.updateState(checklistCode);
}
@DeleteMapping("/api/deleteChecklist")
    public void deleteChecklist (@RequestBody Checklist checklist){
    System.out.println("컨트롤러!");
    System.out.println(checklist);
         checklistService.deleteChecklist(checklist);


}
}
