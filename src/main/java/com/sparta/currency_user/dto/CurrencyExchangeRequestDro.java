package com.sparta.currency_user.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyExchangeRequestDro {

    private Long userId;
    private Long toCurrencyId;
    private BigDecimal amountInKrw;
    private String status;

    public CurrencyExchangeRequestDro(Long userId, Long toCurrencyId, BigDecimal amountInKrw, String status) {
        this.userId = userId;
        this.toCurrencyId = toCurrencyId;
        this.amountInKrw = amountInKrw;
        this.status = status;
    }

    public CurrencyExchangeRequestDro() {}

}
