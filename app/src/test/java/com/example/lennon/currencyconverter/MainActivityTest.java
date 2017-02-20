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
//        assertEquals("amount", amount.getText().toString());
    }

    @Test
    public void textview_result_in_main_activity_should_be_show() {
        TextView result = (TextView) mainActivity.findViewById(R.id
                .resultTextView);

        assertNotNull(result);
        assertEquals(View.VISIBLE, result.getVerticalFadingEdgeLength());
//        assertEquals("TextView", result.getText().toString());
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
        EditText amount = (EditText) mainActivity.findViewById(R.id
                .amountText);
        Button convertBtn = (Button) mainActivity.findViewById(R.id.convertButton);

        EditText curencyType = (EditText) mainActivity.findViewById(R.id
                .currencyTxt);
        curencyType.setText("USD");
        amount.setText("10");
        convertBtn.performClick();

        Button button = (Button) mainActivity.findViewById( R.id.convertButton );
        button.performClick();

        TextView result = (TextView) mainActivity.findViewById(R.id.resultTextView);
        assertEquals("300", result.getText().toString());
    }

    @Test
    public void convert_20usd_to_thb_should_converted() {
        EditText amount = (EditText) mainActivity.findViewById(R.id
                .amountText);
        Button convertBtn = (Button) mainActivity.findViewById(R.id.convertButton);

        EditText curencyType = (EditText) mainActivity.findViewById(R.id
                .currencyTxt);
        curencyType.setText("USD");
        amount.setText("20");
        convertBtn.performClick();

        TextView result = (TextView) mainActivity.findViewById(R.id.resultTextView);
        assertEquals("600", result.getText().toString());
    }

    @Test
    public void convert_10eur_to_thb_should_converted() {
        EditText amount = (EditText) mainActivity.findViewById(R.id
                .amountText);
        Button convertBtn = (Button) mainActivity.findViewById(R.id.convertButton);

        EditText curencyType = (EditText) mainActivity.findViewById(R.id
                .currencyTxt);
        curencyType.setText("EUR");
        amount.setText("10");
        convertBtn.performClick();

        TextView result = (TextView) mainActivity.findViewById(R.id.resultTextView);
        assertEquals("400", result.getText().toString());
    }


}//end class
