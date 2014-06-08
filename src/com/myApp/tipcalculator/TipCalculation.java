package com.myApp.tipcalculator;

import java.util.logging.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculation extends Activity {
	private EditText etAmount;
	private TextView tvTipValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculation);
        etAmount = (EditText) findViewById(R.id.etAmount);
        tvTipValue =  (TextView) findViewById(R.id.tvTipValue);
        findViewById(R.id.btnTip5).setOnClickListener(tipCalculation_OnClickListener);
        findViewById(R.id.btnTip10).setOnClickListener(tipCalculation_OnClickListener);
        findViewById(R.id.btnTip15).setOnClickListener(tipCalculation_OnClickListener);
    }
    
    protected float computeTip(float amount, float tipPercent) {
		float tip = amount*tipPercent/100;
    	return tip;
	}
    
    //Global On click listener for all views
    final OnClickListener tipCalculation_OnClickListener = new OnClickListener() {
        public void onClick(final View v) {
        	float amount = Float.parseFloat(etAmount.getText().toString());
        	float tip = 0,tipPercent= 0;
        	Log.i("Button Clicked","Amount is : "+amount);
            switch(v.getId()) {
                case R.id.btnTip5:
                    //Inform the user the button1 has been clicked
//                    Toast.makeText(v.getContext(),"5 clicked", Toast.LENGTH_LONG);      
                	Log.i("Button Clicked","5 % clciked");
                	tipPercent = 5;
                break;
                case R.id.btnTip10:
                    //Inform the user the button2 has been clicked
//                	Toast.makeText(v.getContext(),"10 clicked", Toast.LENGTH_LONG);
                	Log.i("Button Clicked","10 % clciked");
                	tipPercent = 10;
                break;
                case R.id.btnTip15:
                    //Inform the user the button2 has been clicked
//                	Toast.makeText(v.getContext(),"15 clicked", Toast.LENGTH_LONG);
                	Log.i("Button Clicked","15 % clciked");
                	tipPercent = 15;
                break;
            }
            tip = computeTip(amount, tipPercent);
            tvTipValue.setText("Your Tip is :  $"+tip);
        }
    };
    
}
