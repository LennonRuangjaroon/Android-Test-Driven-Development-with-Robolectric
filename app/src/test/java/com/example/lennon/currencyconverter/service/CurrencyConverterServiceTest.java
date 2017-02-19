package com.example.lennon.currencyconverter.service;


import com.example.lennon.currencyconverter.service.impl.ExchangeRateServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The Currency Converter Service Test
 * author lennon
 * Created by lennon on 2/18/2017 AD.
 */
public class CurrencyConverterServiceTest {

    private CurrencyConverterService currencyConverterService;

    @Before
    public void setUp() {
        currencyConverterService = new CurrencyConverterService(new
                ExchangeRateServiceImpl());
    }

    @Test
    public void convert_10usd_to_thb_converted() {
        assertCurrencyConverter(10, "USD", 300);
    }

    @Test
    public void convert_20usd_to_thb_converted() {
        assertCurrencyConverter(20, "USD", 600);
    }

    @Test
    public void convert_10eur_to_thb_converted() {
        assertCurrencyConverter(10, "EUR", 400);
    }

    @Test
    public void convert_20eur_to_thb_converted() {
        assertCurrencyConverter(20, "EUR", 800);
    }

    @Test
    public void convert_0eur_to_thb_converted() {
        assertCurrencyConverter(0, "EUR", 0);
    }

    @Test(expected = ArithmeticException.class)
    public void convert_amount_large_range_should_throw_exception() {
        currencyConverterService.converterCurrency(1000000000, "USD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_negative_amount_should_throw_exception() {
        currencyConverterService.converterCurrency(-10, "USD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_not_found_currency_should_throw_exception() {
        currencyConverterService.converterCurrency(10, "");
    }

    private void assertCurrencyConverter(int amount, String currency, int expected) {
        int result = currencyConverterService.converterCurrency(amount, currency);
        assertEquals(expected, result);
    }

}
