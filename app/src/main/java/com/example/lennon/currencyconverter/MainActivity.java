package com.example.lennon.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();

//        CurrencyConverterServiceExchange currencyConverterService = new
//                CurrencyConverterServiceExchange(new ExchangeRateService());
//        int converterCurrency = currencyConverterService.converterCurrency(10, "USD");
//        TextView viewById = (TextView) findViewById(R.id.amountText);
//        viewById.setText("test " + converterCurrency);
//        TextView viewById = (TextView) findViewById(R.id.helloworld);

    }

    protected void initControls(){
        amount = (EditText) findViewById(R.id.amountText);
    }


}
