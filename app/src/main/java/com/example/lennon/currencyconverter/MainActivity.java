package com.example.lennon.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lennon.currencyconverter.converter.CurrencyConverter;
import com.example.lennon.currencyconverter.exchangerate.ExchangeRateServiceImpl;

public class MainActivity extends AppCompatActivity {

    private CurrencyConverter currencyConverter;

    private EditText amountEdt;
    private TextView resultTxv;
    private Button convertBtn;
    private EditText currencyTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onclickConvert();
    }

    private void onclickConvert() {
        convertBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currencyConverter = new CurrencyConverter(new ExchangeRateServiceImpl());
                Integer amount = Integer.valueOf(amountEdt.getText().toString());
                String currency = currencyTxt.getText().toString();
                getConvertCurrency(amount, currency);
            }
        });
    }

    private void getConvertCurrency(Integer amount, String currency) {
        try {
            int result = currencyConverter.converterCurrency(amount, currency);
            resultTxv.setText(String.valueOf(result));
        }catch (Exception e){
            resultTxv.setText("Can not convert!!!");
        }
    }

    protected void init() {
        amountEdt = (EditText) findViewById(R.id.amountText);
        resultTxv = (TextView) findViewById(R.id.resultTextView);
        convertBtn = (Button) findViewById(R.id.convertButton);
        currencyTxt = (EditText) findViewById(R.id.currencyTxt);
    }


}// end class
