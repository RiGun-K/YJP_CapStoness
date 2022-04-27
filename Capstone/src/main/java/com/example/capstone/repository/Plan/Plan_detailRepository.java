package com.example.capstone.repository.Plan;


import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.Plan_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Plan_detailRepository extends JpaRepository<Plan_detail, Long> {

    List<Plan_detail> findByPlanCodeAndDetailDay(Plan planCode, int detailDay);

}
