package info.androidhive.slidingmenu;

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
import info.androidhive.slidingmenuserver.R;


/////////////////// *** Start  Class *** ///////////////////////////	

public class Create_MeetingFragupdate extends Activity {

/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	ImageView calender;
	EditText theme ,work ,time;
	String theeme,woork,timee,timeee,meetingname,id,workk;
	Button next;
	String hourrr,hourr2,setzero,sethour,setmin,setmonth,setday;
	Intent i;
	int hour22,hourr;
	
 final static int RQS_1 = 1;
 String year1,month1,day1,hour1,minute1;
public SharedPreferences preferences;
String master,timer,topic,general,grammarian,ah,ev1,ev2,ev3,ev4,ev5,sp1,sp2,sp3,sp4,sp5;

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.create_meeting);
		
		theme=(EditText)findViewById(R.id.theme);
	
		
		work=(EditText)findViewById(R.id.workday);
		
	
		calender=(ImageView)findViewById(R.id.imageView1);
        next=(Button)findViewById(R.id.NextButton);

    	
		Intent update=getIntent();
		meetingname=update.getStringExtra("MEETINGNAME");
		timeee=update.getStringExtra("TIMEE");
		id=update.getStringExtra("ID");
		master=update.getStringExtra("MASTER");
		timer=update.getStringExtra("TIMER");
		topic=update.getStringExtra("TOPIC");
		general=update.getStringExtra("GENEARAL");
		grammarian=update.getStringExtra("GRAMMARIAN");
		ah=update.getStringExtra("AH");
		ev1=update.getStringExtra("EV1");
		ev2=update.getStringExtra("EV2");
		ev3=update.getStringExtra("EV3");
		ev4=update.getStringExtra("EV4");
		ev5=update.getStringExtra("EV5");
		sp1=update.getStringExtra("SP1");
		sp2=update.getStringExtra("SP2");
		sp3=update.getStringExtra("SP3");
		sp4=update.getStringExtra("SP4");
		sp5=update.getStringExtra("SP5");
		workk=update.getStringExtra("WORK");
		work.setText(workk);
		theme.setText(meetingname);
		time=(EditText)findViewById(R.id.time);
		time.setText(timeee);
		time.setEnabled(false);
	
		if(timeee != null) {
		       time.setText(timeee);
		       time.setEnabled(false);}
		
		else 
		{
		time.setText( "Date : "+day1 + "/" +( month1 )+ "/"  +year1  +"\n"+" Time : " 
					+ hour1 + ":" + minute1);
		time.setEnabled(false);}
		
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);

        calender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent cal=new Intent(getApplicationContext(),Datetimepicker.class);
				startActivityForResult(cal, 1);
				
				
			}
		});

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			theeme = theme.getText().toString();
		woork = work.getText().toString();
	timee = time.getText().toString();
			
			if(theeme.length()>0 && woork.length()>0 && timee.length()>0){
          		  SharedPreferences.Editor editor = preferences.edit();
          		  editor.putString("PASS",theeme);
          		  editor.putString("ID",woork);
          		editor.putString("N",timee);
          		editor.putString("IDD",id);
          		editor.putString("MASTER",master);
          		editor.putString("TIMER",timer);
          		editor.putString("TOPIC",topic);
          		editor.putString("GENERAL",general);
          		editor.putString("GRAMMARIAN",grammarian);
          		editor.putString("AH",ah);
          		editor.putString("EV1",ev1);
          		editor.putString("EV2",ev2);
          		editor.putString("EV3",ev3);
          		editor.putString("EV4",ev4);
          		editor.putString("EV5",ev5);
          		editor.putString("SP1",sp1);
          		editor.putString("SP2",sp2);
          		editor.putString("SP3",sp3);
          		editor.putString("SP4",sp4);
          		editor.putString("SP5",sp5);
          	
          		
          		  editor.commit();
		
          		  Intent in=new Intent(getApplicationContext(),Nextcreatemeatingupdate.class);
          		  startActivity(in);
          		  finish();
          		
				
			}
			else{
				
				Toast.makeText(getApplicationContext(), "Please Fill All The Details", 40000).show();
			}
	
		}
	});
	
	
}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		year1= data.getStringExtra("YEAR");
		month1= data.getStringExtra("MONTH");
		hour1= data.getStringExtra("HOUR");
		day1= data.getStringExtra("DAY");
		minute1= data.getStringExtra("MINUTE");
		 hour22 = Integer.parseInt(hour1);
		 if(month1.length()==1){
			 setmonth="0"+month1;
		 }
		 else{
			 setmonth=month1; 
		 }
		 if(day1.length()==1){
			 setday="0"+day1;
		 }else{
			 setday=day1;
		 }
		 if(minute1.length()==1){
			 setmin="0"+minute1;
		 }
		 else{
			 setmin=minute1;
		 }
		if(hour22>12){
			hourr=hour22-12;
			hourr2 = String.valueOf(hourr);
			hourrr=" pm";
			if(hourr2.length()==1){
				sethour="0"+hourr2;
			}
			else{
				sethour=hourr2;
			}
			
		}
		else{
			hourr=hour22;
			hourr2 = String.valueOf(hourr);
			hourrr=" am";
			if(hourr2.length()==1){
				sethour="0"+hourr2;
			}
			else{
				sethour=hourr2;
			}
		}
		time.setText( "Date : "+ year1 + "/" +( setmonth )+ "/"  + setday +"\n"+" Time : " 
				+ sethour + ":" + setmin+""+hourrr);
	time.setEnabled(false);
		
	}
				
/////////////////// *** Close OnCreateMethod *** ///////////////////////////		

        
  
}

/////////////////// *** Close Class *** ///////////////////////////	