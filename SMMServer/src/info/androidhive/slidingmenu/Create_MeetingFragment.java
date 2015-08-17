package info.androidhive.slidingmenu;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.sax.RootElement;
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

public class Create_MeetingFragment extends Fragment {

/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	private static final int MODE_PRIVATE = 0;
	ImageView calender;
	EditText theme ,work ,time;
	String theeme,woork,timee;
	Button next;
	String hourrr,hourr2,setzero,sethour,setmin,setday,setmonth;
	int hour22,hourr;
	View rootView;
	Intent i;
 final static int RQS_1 = 1;
 String year1,month1,day1,hour1,minute1;
public SharedPreferences preferences;


/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////

public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

     rootView = inflater.inflate(R.layout.create_meeting, container, false);
		
		theme=(EditText)rootView.findViewById(R.id.theme);
		work=(EditText)rootView.findViewById(R.id.workday);
		
	
		calender=(ImageView)rootView.findViewById(R.id.imageView1);
        next=(Button)rootView.findViewById(R.id.NextButton);

	
		time=(EditText)rootView.findViewById(R.id.time);
	       time.setText("Select Time and Date From Calendar");
	       time.setEnabled(false);
		
		 preferences = getActivity().getSharedPreferences("7", MODE_PRIVATE);

        calender.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent cal=new Intent(getActivity(),Datetimepicker.class);
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
  	
  	
  		
  		  editor.commit();

  		  Intent in=new Intent(getActivity(),Nextcreatemeating.class);
  		  startActivity(in);
  		
		
	}
	else{
		
		Toast.makeText(getActivity(), "Please Fill All The Details", 40000).show();
	}

}
});
return rootView;



		
	}

				
/////////////////// *** Close OnCreateMethod *** ///////////////////////////		
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
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

		
	
//		time.setText( "Date : "+day1 + "/" +( month1 )+ "/"  +year1  +"\n"+" Time : " 
//				+ hour1 + ":" + minute1);
	time.setEnabled(false);
		
	}
        
  
}

/////////////////// *** Close Class *** ///////////////////////////	