package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.CurrencyExchange;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CurrencyExchangeResponseDro {

    private Long userId;
    private Long toCurrencyId;
    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CurrencyExchangeResponseDro(CurrencyExchange savedCurrencyExchange) {
        this.userId = savedCurrencyExchange.getUser().getId();
        this.toCurrencyId = savedCurrencyExchange.getToCurrency().getId();
        this.amountInKrw = savedCurrencyExchange.getAmountInKrw();
        this.amountAfterExchange = savedCurrencyExchange.getAmountAfterExchange();
        this.status = savedCurrencyExchange.getStatus();
        this.createdAt = savedCurrencyExchange.getCreatedAt();
        this.modifiedAt = savedCurrencyExchange.getModifiedAt();
    }
}