package com.sparta.currency_user.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity     // -> pk를 가져야 한다.
public class CurrencyExchange extends BaseEntity {

    // 필드: 고객 고유 식별자, 환전 대상 통화 식별자, 환전 전 금액, 환전 후 금액, 상태

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // Currency 식별자가 있어야 환전 요청을 했을 때,
    // -> 그 ID가 1번이면 Currency 테이블에 있는 1번이 어떤 환율인지, 통화인지 볼수 있음
    @ManyToOne
    @JoinColumn(name = "toCurrencyId")
    private Currency currency;

    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;

}
