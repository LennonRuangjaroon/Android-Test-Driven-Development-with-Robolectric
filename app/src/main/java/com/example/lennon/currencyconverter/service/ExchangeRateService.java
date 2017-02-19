package com.example.lennon.currencyconverter.service;


import java.util.HashMap;
import java.util.Map;

/**
 * The Rate for simulate rate of currency.
 * Created by lennon on 2/18/2017 AD.
 */
public interface ExchangeRateService {
    public int getRate(String currency);
}
