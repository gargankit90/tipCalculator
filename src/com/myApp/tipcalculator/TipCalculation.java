package com.myApp.tipcalculator;

import java.util.logging.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculation extends Activity {
	private EditText etAmount;
	private EditText etTipValue;
	private SeekBar sbTip;
	private EditText etPeople;
	private SeekBar sbPeople;
	private float amount = 0;
	private float tip = 0;
	private int people = 0;
	private float totalAmount = 0;
	private float totalTip = 0;
	private float eachPays = 0;
	private TextView tvTipAmount;
	private TextView tvTotalBill;
	private TextView tvEachPays;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculation);
		etAmount = (EditText) findViewById(R.id.etAmount);
		etTipValue = (EditText) findViewById(R.id.etTip);
		sbTip = (SeekBar) findViewById(R.id.sbTip);
		etPeople = (EditText) findViewById(R.id.etPeople);
		sbPeople = (SeekBar) findViewById(R.id.sbPeople);
		tvTipAmount = (TextView) findViewById(R.id.tvValTipAmount);
		tvTotalBill = (TextView) findViewById(R.id.tvValTotalBill);
		tvEachPays = (TextView) findViewById(R.id.tvValEachPay);
		etTipValue.setText(sbTip.getProgress() * 5 + "");
		etPeople.setText(sbPeople.getProgress() + 1 + "");
		tip = sbTip.getProgress() * 5;
		people = sbPeople.getProgress() + 1;
		sbTip.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progressChanged = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progressChanged = progress * 5;
				etTipValue.setText(progressChanged + "");
				tip = progressChanged;
				compute();
				render();
			}
		});

		sbPeople.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progressChanged = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progressChanged = progress + 1;
				etPeople.setText(progressChanged + "");
				people = progressChanged;
				compute();
				render();
			}
		});

		etAmount.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				// Log.i("on Text Changed", s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.i("After Text Changed", s.toString());
				amount = s.toString().equalsIgnoreCase("") ? 0 :Float.parseFloat(s.toString());
				compute();
				render();
			}
		});
		
		etTipValue.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				tip = s.toString().equalsIgnoreCase("") ? 0 :Float.parseFloat(s.toString());
				compute();
				render();
			}
		});
		
		etPeople.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.i("Error Case", s.toString());
				people = s.toString().equalsIgnoreCase("") ? 0 : Integer.parseInt(s.toString());
				compute();
				render();
			}
		});
	}

	protected void compute() {
		totalTip = amount * tip / 100;
		Log.i("Total Tip", totalTip + "");
		totalAmount = amount + totalTip;
		Log.i("Total amount", totalAmount + "");
		eachPays = totalAmount / people;
		eachPays = (float) Math.ceil(eachPays);
		Log.i("Each Pays", eachPays + "");
	}

	protected void render() {
		tvTipAmount.setText("$" + totalTip);
		tvTotalBill.setText("$" + totalAmount);
		tvEachPays.setText("$" + eachPays);

	}
	
	private void OrientationEventListener() {
		// TODO Auto-generated method stub

	}

}
