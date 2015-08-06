package info.androidhive.slidingmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////	

public class Nextcreatemeating extends Activity {
	
	 
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
EditText master,evaluator,timer,ahcounter,gramarian;
Button next;
String year1,month1,day1,hour1,minute1;
String mastr,evaluatr,timr,ahconter,gramarrn,themee,woork,timee;
public SharedPreferences preferences;

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_nextcreatemeating);
		master=(EditText)findViewById(R.id.master);
		evaluator=(EditText)findViewById(R.id.general);
		timer=(EditText)findViewById(R.id.timer);
		ahcounter=(EditText)findViewById(R.id.counter);
		gramarian=(EditText)findViewById(R.id.grammarian);
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
			themee=(preferences.getString("PASS", ""));
			 woork=(preferences.getString("ID", ""));
			 timee=(preferences.getString("N", ""));

        next=(Button)findViewById(R.id.NextButton);
        next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			mastr = master.getText().toString();
		evaluatr = evaluator.getText().toString();
	timr = timer.getText().toString();
	ahconter = ahcounter.getText().toString();
	gramarrn = gramarian.getText().toString();
			
			if(mastr.length()>0 && evaluator.length()>0 && timr.length()>0 && ahconter.length()>0 && gramarrn.length()>0){

          		  SharedPreferences.Editor editor = preferences.edit();
          	
          		  editor.putString("PASS",mastr);
          		  editor.putString("ID",evaluatr);
          		editor.putString("N",timr);
         		editor.putString("N1",ahconter);
         		editor.putString("N2",gramarrn);
         		editor.putString("N3",themee);
         		editor.putString("N4",woork);
         		editor.putString("N5",timee);
          	
          	
          		
          		  editor.commit();
			
          		  Intent in=new Intent(getApplicationContext(),Secondnextcreatemeating.class);
          		  startActivity(in);
          		
				
			}
			else{
				
				Toast.makeText(getApplicationContext(), "Please Provide All The Details", 40000).show();
			}
	
		}
	});
	}
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
}
	

/////////////////// *** Close Class *** ///////////////////////////	