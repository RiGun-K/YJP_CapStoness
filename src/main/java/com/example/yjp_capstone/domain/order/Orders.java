package com.example.yjp_capstone.domain.order;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderCode;

    @Column
    private int orderPrice; //주문금액
    private char orderType; //주문유형
    private String patmentCode; //결제코드
    private LocalDateTime paymentDate;  //결제날짜
    private String paymentInfo; //결제정보
    private String deliveryZipcode; //배송지 우편번호
    private String delivaryAddress; //배송지 상세주소
    private char orderState; //주문상태
    private String delivaryRequest; //배송요청사항
    private String reservationRequestTime;  //예약요청시간(렌탈시 )
    private String reservationStartDate;
}
