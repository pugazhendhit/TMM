package com.example.main;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/////////////////// *** Start  Class *** ///////////////////////////	

public class Create_Meeting extends Activity {
	 
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
		ImageView calender;
		EditText theme ,work ,time;
		String theme_string_string_string,woork,timee;
		Button next;
		Intent i;
		String year1,month1,day1,hour1,minute1;
		public SharedPreferences preferences;
		
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
		
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.create_meeting);

/////////////////// Start Initialization Widgets  ///////////////////////////
		
		theme=(EditText)findViewById(R.id.theme);
		work=(EditText)findViewById(R.id.workday);
		calender=(ImageView)findViewById(R.id.imageView1);
        next=(Button)findViewById(R.id.NextButton);
    	time=(EditText)findViewById(R.id.time);
   	 	preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
   	 	
/////////////////// Close Initialization Widgets  ///////////////////////////

         i = getIntent();
		year1= i.getStringExtra("YEAR");
		month1= i.getStringExtra("MONTH");
		hour1= i.getStringExtra("HOUR");
		day1= i.getStringExtra("DAY");
		minute1= i.getStringExtra("MINUTE");
		
		if(i.getExtras() == null) {
	       time.setText("Select Time and Date From Calendar");
	       time.setEnabled(false);}
		else

		{ time.setText( "Date : "+day1 + "/" +( month1 )+ "/"  +year1  +"\n"+" Time : " + hour1 + ":" + minute1);
		time.setEnabled(false);}

/////////////////// Start OnClick Method  ///////////////////////////
        calender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent cal= new Intent(getApplicationContext(),Datetimepicker.class);
				startActivity(cal);
				finish();
			}
		});

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			theme_string = theme.getText().toString();
			woork = work.getText().toString();
			timee = time.getText().toString();
			
			if(theme_string.length()>0 && woork.length()>0 && timee.length()>0){

			SharedPreferences.Editor editor = preferences.edit();
          	
			editor.putString("PASS",theme_string);
          	editor.putString("ID",woork);
          	editor.putString("N",timee);
          	
          	
          		
           editor.commit();
		
          		  Intent in=new Intent(getApplicationContext(),Nextcreatemeating.class);
          		  startActivity(in);
          		
				
			}
			else{
				
				Toast.makeText(getApplicationContext(), "Please Fill All The Details", 40000).show();
			}
	
		}
	});
	
/////////////////// Close OnClick Method  ///////////////////////////
}
/////////////////// *** Close OnCreateMethod *** ///////////////////////////			
	
}

/////////////////// *** Close Class *** ///////////////////////////	