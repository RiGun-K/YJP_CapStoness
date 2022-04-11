package com.example.yjp_capstone.repository.Storage;

import com.example.yjp_capstone.domain.storage.OrderList;
import com.example.yjp_capstone.domain.storage.StorageBox;
import com.example.yjp_capstone.domain.storage.UseStorageBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UseStorageBoxRepository extends JpaRepository<UseStorageBox, Long> {
    List<UseStorageBox> findByStorageBoxCode(StorageBox storageBox);
    List<UseStorageBox> findByOrderCode(OrderList orderList);
}
