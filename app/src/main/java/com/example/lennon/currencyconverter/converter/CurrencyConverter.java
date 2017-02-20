package com.example.lennon.currencyconverter.converter;

import com.example.lennon.currencyconverter.exchangerate.ExchangeRateService;

/**
 * The Currency Converter Service
 * author lennon
 * Created by lennon on 2/18/2017 AD.
 */
@SuppressWarnings("Since15")
public class CurrencyConverter {

    private ExchangeRateService exchangeRateService;

    public CurrencyConverter(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    /**
     * Converter Currency
     *
     * @param amount
     * @param currency
     * @return
     */
    public int converterCurrency(int amount, String currency) {
        validateAmount(amount);
        validateCurrency(currency);
        return multiply(amount, exchangeRateService.getRate(currency));
    }

    private int multiply(int amount, int rate){
        try {
            return Math.multiplyExact(amount, rate);
        } catch (Exception e) {
            throw e;
        }
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount can't be negative.");
        }
    }

    private int validateCurrency(String currency) {
        try {
            return exchangeRateService.getRate(currency);
        } catch (Exception e) {
            throw new IllegalArgumentException("Not found currency");
        }
    }
}
