package com.example.yjp_capstone.service;



import com.example.yjp_capstone.domain.Plan.Plan;
import com.example.yjp_capstone.domain.Plan.Plan_detail;
import com.example.yjp_capstone.repository.Plan.PlanRepository;
import com.example.yjp_capstone.repository.Plan.Plan_detailRepository;
import com.example.yjp_capstone.repository.Plan.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PlanService {

    public final TeamRepository teamRepository;
    public final PlanRepository planRepository;
    public final Plan_detailRepository plan_detailRepository;


    public Plan createPlan(Plan plan) {

        planRepository.save(plan);

        return plan;
    }

    public PlanService(TeamRepository teamRepository, PlanRepository planRepository, Plan_detailRepository plan_detailRepository) {
        this.teamRepository = teamRepository;
        this.planRepository = planRepository;
        this.plan_detailRepository = plan_detailRepository;
    }

    public String checkPlanName(Plan plan) {

        Optional<Plan> check = planRepository.findByTeamCodeAndPlanName(plan.getTeamCode(), plan.getPlanName());
        if (check.isPresent() == true) {
            return "n";
        } else {
            return "y";
        }


    }
    public Optional<Plan> selectPlan(String planName){
       Optional<Plan> selectPlan =planRepository.findByPlanName(planName);

  return selectPlan;
    }

    public void insertDetailPlan(Plan_detail plan_detail){
        plan_detailRepository.save(plan_detail);


    }

    public List<Plan_detail> loadDetailPlan(Plan_detail plan_detail){
        System.out.println("서비스받음");
        List<Plan_detail> planDetails = plan_detailRepository.findByPlanCodeAndDetailDay(plan_detail.getPlanCode(),plan_detail.getDetailDay());
        System.out.println("서비스받음");
        return planDetails;
    }

}
