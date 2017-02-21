package com.example.lennon.currencyconverter.converter;


import com.example.lennon.currencyconverter.exchangerate.ExchangeRateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * The Currency Converter Service Test
 * author lennon
 * Created by lennon on 2/18/2017 AD.
 */
public class CurrencyConverterTest {

    private CurrencyConverter currencyConverter;

    @Mock
    private ExchangeRateService exchangeRateService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        currencyConverter = new CurrencyConverter(exchangeRateService);
    }

    @After
    public void tearDown(){
        currencyConverter = null;
    }

    @Test
    public void convert_10usd_to_thb_converted() {
        when(exchangeRateService.getRate("USD")).thenReturn(30);
        assertCurrencyConverter(10, "USD", 300);
    }

    @Test
    public void convert_20usd_to_thb_converted() {
        when(exchangeRateService.getRate("USD")).thenReturn(30);
        assertCurrencyConverter(20, "USD", 600);
    }

    @Test
    public void convert_10eur_to_thb_converted() {
        when(exchangeRateService.getRate("EUR")).thenReturn(40);
        assertCurrencyConverter(10, "EUR", 400);
    }

    @Test
    public void convert_20eur_to_thb_converted() {
        when(exchangeRateService.getRate("EUR")).thenReturn(40);
        assertCurrencyConverter(20, "EUR", 800);
    }

    @Test
    public void convert_0eur_to_thb_converted() {
        when(exchangeRateService.getRate("EUR")).thenReturn(30);
        assertCurrencyConverter(0, "EUR", 0);
    }

    @Test(expected = ArithmeticException.class)
    public void convert_amount_large_range_should_throw_exception() {
        when(exchangeRateService.getRate("USD")).thenReturn(30);
        currencyConverter.converterCurrency(1000000000, "USD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_negative_amount_should_throw_exception() {
        when(exchangeRateService.getRate("USD")).thenThrow
                (IllegalArgumentException.class);
        currencyConverter.converterCurrency(-10, "USD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_not_found_currency_should_throw_exception() {
        when(exchangeRateService.getRate("")).thenThrow
                (IllegalArgumentException.class);
        currencyConverter.converterCurrency(10, "");
    }

    private void assertCurrencyConverter(int amount, String currency, int expected) {
        int result = currencyConverter.converterCurrency(amount, currency);
        assertEquals(expected, result);

        verify(exchangeRateService, times(2)).getRate(eq(currency));
    }

}
