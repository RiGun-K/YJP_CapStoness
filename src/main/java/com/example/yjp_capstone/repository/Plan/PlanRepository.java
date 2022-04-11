package com.example.yjp_capstone.repository.Plan;

import com.example.yjp_capstone.domain.Plan.Plan;
import com.example.yjp_capstone.domain.Plan.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    Optional<Plan> findByPlanName(String planName);

    Optional<Plan> findByTeamCodeAndPlanName(Team team, String planName);

    List<Plan> findByTeamCodeTeamCode(Long team);
}
