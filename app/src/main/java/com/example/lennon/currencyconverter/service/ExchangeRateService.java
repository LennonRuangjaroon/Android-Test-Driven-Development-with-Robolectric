package com.example.lennon.currencyconverter.service;


import java.util.HashMap;
import java.util.Map;

/**
 * The Rate for simulate rate of currency.
 * Created by lennon on 2/18/2017 AD.
 */
public class ExchangeRateService {

    public int getRate(String currency) {
        Map<String, Integer> setRate = new HashMap<String, Integer>();
        setRate.put("USD", Integer.valueOf(30));
        setRate.put("EUR", Integer.valueOf(40));

        return setRate.get(currency);
    }

}
