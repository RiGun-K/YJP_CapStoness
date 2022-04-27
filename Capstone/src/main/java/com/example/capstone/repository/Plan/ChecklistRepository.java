package com.example.capstone.repository.Plan;


import com.example.capstone.domain.Plan.Checklist;
import com.example.capstone.domain.Plan.Plan_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {


    List<Checklist> findByDetailCode(Plan_detail plan_detail);

}
