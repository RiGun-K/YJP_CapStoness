package com.example.yjp_capstone.controller.Plan;

import com.example.yjp_capstone.domain.Plan.Plan;
import com.example.yjp_capstone.domain.Plan.Plan_detail;
import com.example.yjp_capstone.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PlannerApiController {
//
    private final PlanService planService;

    public PlannerApiController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/api/createPlan")
    public Optional<Plan> createPlan(@RequestBody Plan plan){
        System.out.println("생성버튼 받아짐" +plan.getTeamCode());
        planService.createPlan(plan);
        System.out.println("저장은 됨");
        Optional<Plan> selectedPlan =planService.selectPlan(plan.getPlanName());
        return selectedPlan;
    }

    @PostMapping("/api/checkPlanName")
    public String checkPlanName(@RequestBody Plan plan) {
       String result= planService.checkPlanName(plan);
        return result;
    }

    @PutMapping("/api/insertDetailPlan")
    public void insertDetailPlan(@RequestBody Plan_detail plan_detail){
        System.out.println("일정삽입 받아짐");


        System.out.println(plan_detail.getDetailMemo());
        planService.insertDetailPlan(plan_detail);


    }
    @PostMapping("/api/loadDetailPlanOfDay")
    public List<Plan_detail> loadDetailPlanOfDay(@RequestBody Plan_detail plan_detail){
        System.out.println("api받아짐");
        System.out.println(plan_detail.getPlanCode().getPlanCode());
       return planService.loadDetailPlan(plan_detail);
    }
}
