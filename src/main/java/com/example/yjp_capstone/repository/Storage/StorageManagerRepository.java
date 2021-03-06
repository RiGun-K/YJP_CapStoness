package com.example.yjp_capstone.repository.Storage;


import com.example.yjp_capstone.domain.Member.Member;
import com.example.yjp_capstone.domain.storage.Storage;
import com.example.yjp_capstone.domain.storage.StorageManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface StorageManagerRepository extends JpaRepository<StorageManager, Long> {
    public List<StorageManager> findByStorageCode(Storage storage);
    public Optional<StorageManager> findByMCode(Member member);
}
