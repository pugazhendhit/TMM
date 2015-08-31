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

public class Nextcreatemeatingupdate extends Activity {
	
	 
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
EditText master,evaluator,timer,ahcounter,gramarian,tabletopicmaster;
Button next;
String year1,month1,day1,hour1,minute1,tabletopic,id,masterr,topic,general,timerr,ah,grammarian,ev1,ev2,ev3,ev4,ev5,sp1,sp2,sp3,sp4,sp5;
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
		
		tabletopicmaster=(EditText)findViewById(R.id.tablemaster);
	
		evaluator=(EditText)findViewById(R.id.general);
	
		timer=(EditText)findViewById(R.id.timer);
	
		ahcounter=(EditText)findViewById(R.id.counter);
	
		gramarian=(EditText)findViewById(R.id.grammarian);
		
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
			themee=(preferences.getString("PASS", ""));
			 woork=(preferences.getString("ID", ""));
			 timee=(preferences.getString("N", ""));
			 masterr=(preferences.getString("MASTER", ""));
			 timerr=(preferences.getString("TIMER", ""));
			 topic=(preferences.getString("TOPIC", ""));
			 general=(preferences.getString("GENERAL", ""));
			 grammarian=(preferences.getString("GRAMMARIAN", ""));
			 ah=(preferences.getString("AH", ""));
			ev1=(preferences.getString("EV1", ""));
			 ev2=(preferences.getString("EV2", ""));
			 ev3=(preferences.getString("EV3", ""));
			 ev4=(preferences.getString("EV4", ""));
			 ev5=(preferences.getString("EV5", ""));
			 sp1=(preferences.getString("SP1", ""));
			 sp2=(preferences.getString("SP2", ""));
			 sp3=(preferences.getString("SP3", ""));
			 sp4=(preferences.getString("SP4", ""));
			 sp5=(preferences.getString("SP5", ""));
			
			
			 id=(preferences.getString("IDD", ""));
			 master.setText(masterr);
				tabletopicmaster.setText(topic);
				evaluator.setText(general);
				timer.setText(timerr);
				ahcounter.setText(ah);
				gramarian.setText(grammarian);
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
			tabletopic=tabletopicmaster.getText().toString();
			if(mastr.length()>0 && evaluator.length()>0 && timr.length()>0 && ahconter.length()>0 && gramarrn.length()>0 && tabletopic.length()>0){

          		  SharedPreferences.Editor editor = preferences.edit();
          	
          		  editor.putString("PASS",mastr);
          		  editor.putString("ID",evaluatr);
          		editor.putString("N",timr);
         		editor.putString("N1",ahconter);
         		editor.putString("N2",gramarrn);
         		editor.putString("N3",themee);
         		editor.putString("N4",woork);
         		editor.putString("N5",timee);
         		editor.putString("N6",tabletopic);
         		editor.putString("IDD",id);
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
			
          		  Intent in=new Intent(getApplicationContext(),Secondevaluatorcrupdate.class);
          		  startActivity(in);
          		finish();
				
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