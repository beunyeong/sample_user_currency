package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CurrencyExchangeRequestDro;
import com.sparta.currency_user.dto.CurrencyExchangeResponseDro;
import com.sparta.currency_user.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequiredArgsConstructor
// 주소를 적을 때에는 언더바(_)는 적지 않으며, 단어와 단어 사이에는 하이픈(-)으로 구분한다.
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    // 1. 환전 요청 실행
    @PostMapping
    public ResponseEntity<CurrencyExchangeResponseDro> exchangeCurrency(@RequestBody CurrencyExchangeRequestDro currencyExchangeRequestDro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyExchangeService.exchangeRequest(
                currencyExchangeRequestDro.getUserId(),
                currencyExchangeRequestDro.getToCurrencyId(),
                currencyExchangeRequestDro.getAmountInKrw(),
                currencyExchangeRequestDro.getStatus())
        );
    }

    // 호출순서:
    // CurrencyExchangeController에서 exchangeRequest을 호출하고
    // CurrencyExchangeService에서 exchangeRequest가 얻어온 userId와 curruncyId를 통해서 user, curruncy를 만들고
    // user, curruncy를 만든 후에 환전 로직 수행
    // CurrencyExchange 객체를 만든 후 저장



}
