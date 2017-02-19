package com.example.lennon.currencyconverter;

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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
                .create().get();
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
        EditText amount = (EditText) mainActivity.findViewById(R.id.amountText);
        String amountText = mainActivity.getResources().getString(R.id
                .amountText);
        assertNotNull(amount);
        assertEquals("amount",amountText);
    }

    @Test
    public void textview_result_in_main_activity_should_be_show() {
        TextView result = (TextView) mainActivity.findViewById(R.id
                .resultTextView);
        assertNotNull(result);
    }

    @Test
    public void button_convert_in_main_activity_should_be_show() {
        Button convert = (Button) mainActivity.findViewById(R.id
                .convertButton);
        assertNotNull(convert);
    }




}//end class
