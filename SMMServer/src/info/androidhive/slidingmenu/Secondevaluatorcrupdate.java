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

public class Secondevaluatorcrupdate extends Activity {
	
	 
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
EditText evaluator1,evaluator2,evaluator3,evaluator4,evaluator5;
Button next;
String year1,month1,day1,hour1,minute1,tabletopic,mastr,evaluatr,timr,ahconter,gramarrn,id,ev1,ev2,ev3,ev4,ev5,sp1,sp2,sp3,sp4,sp5;
String evaluatorr1,evaluatorr2,evaluatorr3,evaluatorr4,evaluatorr5,themee,woork,timee;
public SharedPreferences preferences;

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_secondevaluatorcreate);
	
		evaluator1=(EditText)findViewById(R.id.evaluator1);
		
		evaluator2=(EditText)findViewById(R.id.evaluator2);
		
		evaluator3=(EditText)findViewById(R.id.evaluator3);
	
		evaluator4=(EditText)findViewById(R.id.evaluator4);
	
		evaluator5=(EditText)findViewById(R.id.evaluator5);
		
	
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
			themee=(preferences.getString("PASS", ""));
			 woork=(preferences.getString("ID", ""));
			 timee=(preferences.getString("N", ""));
			 mastr=(preferences.getString("N1", ""));
			 evaluatr=(preferences.getString("N2", ""));
			 timr=(preferences.getString("N3", ""));
			 ahconter=(preferences.getString("N4", ""));
			 gramarrn=(preferences.getString("N5", ""));
			 tabletopic=(preferences.getString("N6", ""));
			 id=(preferences.getString("IDD", ""));
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
			 
				 evaluator1.setText(ev1);
				 evaluator2.setText(ev2);
					evaluator3.setText(ev3);
					evaluator4.setText(ev4);
					evaluator5.setText(ev5);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			evaluatorr1 = evaluator1.getText().toString();
		evaluatorr2 = evaluator2.getText().toString();
	evaluatorr3 = evaluator3.getText().toString();
	evaluatorr4 = evaluator4.getText().toString();
	evaluatorr5 = evaluator5.getText().toString();
			
			if(evaluatorr1.length()>0 && evaluatorr2.length()>0 && evaluatorr3.length()>0 ){

          		  SharedPreferences.Editor editor = preferences.edit();
          		 editor.putString("PASS",mastr);
         		  editor.putString("ID",evaluatr);
         		editor.putString("N",timr);
        		editor.putString("N1",ahconter);
        		editor.putString("N2",gramarrn);
          		  editor.putString("EV1",evaluatorr1);
          		  editor.putString("EV2",evaluatorr2);
          		editor.putString("EV3",evaluatorr3);
         		editor.putString("EV4",evaluatorr4);
         		editor.putString("EV5",evaluatorr5);
         		editor.putString("N3",themee);
         		editor.putString("N4",woork);
         		editor.putString("N5",timee);
         		editor.putString("N6",tabletopic);
         		editor.putString("IDD",id);
         		editor.putString("SP1",sp1);
          		editor.putString("SP2",sp2);
          		editor.putString("SP3",sp3);
          		editor.putString("SP4",sp4);
          		editor.putString("SP5",sp5);
          		  editor.commit();
			
          		  Intent in=new Intent(getApplicationContext(),Secondnextcreatemeatingupdate.class);
          		  startActivity(in);
          		  finish();
          		
				
			}
			else{
				
				Toast.makeText(getApplicationContext(), "Please fill atleast 3 Evaluators", 40000).show();
			}

		}
	});
	}
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
}
	

/////////////////// *** Close Class *** ///////////////////////////	