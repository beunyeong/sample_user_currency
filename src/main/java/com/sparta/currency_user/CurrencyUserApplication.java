package com.sparta.currency_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyUserApplication.class, args);
    }


    //Lv.1
    // 환전 요청 중간 테이블(CurrencyExchange 클래스 추가)
        // 필드: 고객 고유 식별자, 환전 대상 통화 식별자, 환전 전 금액, 환전 후 금액, 상태

    //Lv.2 환전 요청 CRUD
    // 환전 요청 수행
        //환전 후 금액 = 환전 전 금액 / 환율
    // 특정 고객이 수행한 환전 요청 조회
    // 특정 환전 요청 상태를 취소로 변경
    // 고객이 삭제될 때 해당 고객이 수행한 모든 환전 요청 삭제



}
