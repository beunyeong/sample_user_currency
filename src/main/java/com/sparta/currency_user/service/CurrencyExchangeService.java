package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CurrencyExchangeResponseDro;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.CurrencyExchange;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.CurrencyExchangeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor        //fanal에 대한 생성자 의존성 주입
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final UserService userService;
    private final CurrencyService currencyService;

    final int ROUND_NUMBER = 2;

    @Transactional
    public CurrencyExchangeResponseDro exchangeRequest(Long userId, Long toCurrencyId, BigDecimal amountInKrw, String status) {

        // user, currency 정보
        User user = userService.findUserById(userId);
        Currency toCurrencyById = currencyService.findCurrencyById(toCurrencyId);

        // 환전을 실제 수행
        // 환전 후 금액 = 환전 전 금액 / 환율
        BigDecimal exchangedAmount = amountInKrw.divide(toCurrencyById.getExchangeRate(),ROUND_NUMBER, RoundingMode.HALF_UP);

        // 저장
        CurrencyExchange currencyExchange = new CurrencyExchange(user, toCurrencyById, amountInKrw, exchangedAmount, status);

        // 리턴
        CurrencyExchange savedCurrencyExchange = currencyExchangeRepository.save(currencyExchange);

        return new CurrencyExchangeResponseDro(savedCurrencyExchange);


    }


}


