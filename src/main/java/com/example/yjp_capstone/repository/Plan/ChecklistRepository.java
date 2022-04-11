package com.example.yjp_capstone.repository.Plan;


import com.example.yjp_capstone.domain.Plan.Checklist;
import com.example.yjp_capstone.domain.Plan.Plan_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Plan_detail> {


    List<Checklist> findByDetailCode(Plan_detail plan_detail);

}
//    @Query(value = " select c.* from CHECKLIST c \n" +
//            " join PLAN_DETAIL p on c.DETAIL_CODE = p.DETAIL_CODE\n" +
//            " where p.DETAIL_CODE = :detalCode", nativeQuery = true)
//    public Object[Checklist] findBych(@Param("detalCode")long detalCode);