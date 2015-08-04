package com.example.main;

import java.util.Calendar;
	

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/////////////////// *** Start  Class *** ///////////////////////////	

public class Datetimepicker extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
			private int year;
			private int month;
			private int day;
			private int hour;
			private int minute;
			String year1,month1,day1,hour1,minute1;
			Button done;
			public SharedPreferences preferences;
			
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
			

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	

			@Override
			protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.timedatepicker);
			
/////////////////// Start Initialization Widgets  ///////////////////////////
			
			preferences = getApplicationContext().getSharedPreferences("9", MODE_PRIVATE);
			DatePicker date = (DatePicker) findViewById (R.id.pickerdate);
			done=(Button)findViewById(R.id.setdate);
			TimePicker time = (TimePicker) findViewById (R.id.pickertime);
			
/////////////////// Close Initialization Widgets  ///////////////////////////
			
/////////////////// Start OnClick Method  ///////////////////////////
			
			done.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showDate (year, month, day, hour, minute);
			 year1= String.valueOf(year);
			 month1= String.valueOf(month+1);
			 hour1= String.valueOf(hour);
			day1= String.valueOf(day);
			 minute1= String.valueOf(minute);
			 Intent i=new Intent(getApplicationContext(),Create_Meeting.class);
			 i.putExtra("YEAR",year1 );
			 i.putExtra("MONTH", month1);  
			 i.putExtra("HOUR", hour1);  
			 i.putExtra("DAY", day1);  
			 i.putExtra("MINUTE", minute1);  
			 startActivity(i);

		}
	});

/////////////////// Close OnClick Method  ///////////////////////////
			
			
		// Perhaps the current year, month, day, hour, minute,
			
			Calendar ca = Calendar.getInstance ();
			year = ca.get (Calendar.YEAR);
			month = ca.get (Calendar.MONTH);
			day = ca.get (Calendar.DAY_OF_MONTH);
			hour = ca.get (Calendar.HOUR);
			minute = ca.get (Calendar.MINUTE);

		// Initialize DatePicker
		date.init (year, month, day, new OnDateChangedListener () {

			public void onDateChanged (DatePicker arg0, int year, int month,int day) {
			Datetimepicker.this.year = year;
			Datetimepicker.this.month = month;
			Datetimepicker.this.day = day;
			
				// Display the current time and date
				showDate (year, month, day, hour, minute);  //call showDate Method
			}

		});

		// Specify the event listener for TimerPicker
			time.setOnTimeChangedListener (new OnTimeChangedListener () {

			
			public void onTimeChanged (TimePicker arg0, int hour, int minute) {
				Datetimepicker.this.hour = hour;
				Datetimepicker.this.minute = minute;
				showDate (year, month, day, hour, minute);  //call showDate Method
			}
		});
	}
			
/////////////////// *** Close OnCreateMethod *** ///////////////////////////
	  
/////////////////// *** Start showDateMethod *** ///////////////////////////	
			
	protected void showDate (int year2, int month2, int day2, int hour2,
			int minute2) {
		EditText text = (EditText) findViewById (R.id.editText1);
		text.setText (day2  + "/" +( month2+1 )+ "/"  + year2 + " , Time : " 
				+ hour2 + ":" + minute2 );


	        }
/////////////////// *** Close showDateMethod *** ///////////////////////////	

	}
	 

/////////////////// *** Close Class *** ///////////////////////////	