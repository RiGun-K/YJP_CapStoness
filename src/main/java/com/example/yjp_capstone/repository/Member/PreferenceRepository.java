package com.example.yjp_capstone.repository.Member;

import com.example.yjp_capstone.domain.Member.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
