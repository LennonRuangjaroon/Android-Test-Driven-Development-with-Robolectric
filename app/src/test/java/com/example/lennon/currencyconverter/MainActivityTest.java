package com.example.lennon.currencyconverter;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * The MainActivity Test.
 * author lennon
 * Created by lennon on 2/18/2017 AD.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create().start().resume().get();
    }

    @After
    public void tearDown() {
        mainActivity = null;
    }

    @Test
    public void main_activity_should_not_null() {
        assertNotNull(mainActivity);
    }

    @Test
    public void textbox_amount_in_main_activity_should_be_show() {
        TextView amount = (EditText) mainActivity.findViewById(R.id.amountText);

        assertNotNull(amount);
        assertEquals(View.VISIBLE, amount.getVisibility());
    }

    @Test
    public void textview_result_in_main_activity_should_be_show() {
        TextView result = (TextView) mainActivity.findViewById(R.id
                .resultTextView);

        assertNotNull(result);
        assertEquals(View.VISIBLE, result.getVerticalFadingEdgeLength());
    }

    @Test
    public void button_convert_in_main_activity_should_be_show() {
        Button convert = (Button) mainActivity.findViewById(R.id
                .convertButton);

        assertNotNull(convert);
        assertEquals(View.VISIBLE, convert.getVisibility());
        assertEquals("Convert", convert.getText().toString());
    }

    @Test
    public void convert_10usd_to_thb_should_converted() {
        perfromInputData("10", "USD");
        perfromClickConvert();

        assertConvertCurrency("300");
    }

    @Test
    public void convert_20usd_to_thb_should_converted() {
        perfromInputData("20", "USD");
        perfromClickConvert();

        assertConvertCurrency("600");
    }

    @Test
    public void convert_10eur_to_thb_should_converted() {
        perfromInputData("10", "EUR");
        perfromClickConvert();

        assertConvertCurrency("400");
    }

    @Test
    public void convert_20eur_to_thb_should_converted() {
        perfromInputData("20", "EUR");
        perfromClickConvert();

        assertConvertCurrency("800");
    }

    @Test
    public void convert_worng_currency_type_should_show_msg_error() {
        perfromInputData("20", "xxx");
        perfromClickConvert();

        assertConvertCurrency("Can not convert!!!");
    }

    private void perfromInputData(String amount, String currencyType) {
        EditText amountTxt = (EditText) mainActivity.findViewById(R.id
                .amountText);

        EditText curencyTypeTxt = (EditText) mainActivity.findViewById(R.id
                .currencyTxt);

        curencyTypeTxt.setText(currencyType);
        amountTxt.setText(amount);
    }

    private void perfromClickConvert() {
        Button convertBtn = (Button) mainActivity.findViewById(R.id.convertButton);
        convertBtn.performClick();
    }

    private void assertConvertCurrency(String result) {
        TextView resultTxt = (TextView) mainActivity.findViewById(R.id.resultTextView);
        assertEquals(result, resultTxt.getText().toString());
    }


}//end class
