package com.example.yjp_capstone.repository.Storage;


import com.example.yjp_capstone.domain.storage.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {

    @Query(
            value = "select u.USE_STORAGE_START_TIME, u.USE_STORAGE_END_TIME, b.STORAGE_BOX_NAME,b.STORAGE_BOX_STATE, s.STORAGE_NAME  \n" +
                    "from ORDERLIST o \n" +
                    "join MEMBER m on o.MCODE = m.MCODE \n" +
                    "join USESTORAGEBOX u on o.ORDER_CODE = u.ORDER_CODE \n" +
                    "join STORAGEBOX b on u.STORAGE_BOX_CODE = b.STORAGE_BOX_CODE \n" +
                    "join STORAGE s on s.STORAGE_CODE = b.STORAGE_CODE \n" +
                    "WHERE m.MID = :memberId", nativeQuery = true)
    public Object[] findByMember(@Param("memberId") String memberId );

}
