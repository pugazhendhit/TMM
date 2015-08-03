package com.example.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/////////////////// *** Start  Class *** ///////////////////////////

public class SignUpp extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
			Button next;
			EditText clubid,name,contact,password;
			String club,nam,con,pas;
			public SharedPreferences preferences;

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
			
/////////////////// *** Start OnCreateMethod *** ///////////////////////////
			
	@Override
			protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.signup);
		

/////////////////// Start Initialization Widgets  ///////////////////////////
			
			
		clubid=(EditText)findViewById(R.id.serverID);
		name=(EditText)findViewById(R.id.serverName);
		contact=(EditText)findViewById(R.id.Contact);
		password=(EditText)findViewById(R.id.Password);
		preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
		next=(Button)findViewById(R.id.NextButton);
		next.setOnClickListener(new OnClickListener() {

/////////////////// Close Initialization Widgets  ///////////////////////////
			
			
/////////////////// Start OnClick Method  ///////////////////////////
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				club = clubid.getText().toString();
				nam = name.getText().toString();
				con = contact.getText().toString();
				pas = password.getText().toString();
			if(club.length()>0 && nam.length()>0 && con.length()>0 && pas.length()>0){

          		  SharedPreferences.Editor editor = preferences.edit();
          		
          		  editor.putString("PASS",club);
          		  editor.putString("ID",nam);
          		  editor.putString("N",con);
          		  editor.putString("ROLEID",pas);
          		  editor.commit();
	
          		  Intent in=new Intent(getApplicationContext(),NextSignup.class);
          		  startActivity(in);
          		
				
			}
			else{
				
				Toast.makeText(getApplicationContext(), "Please fill all  the details", 40000).show();
			}
	
		}
			
			
/////////////////// Close OnClick Method  ///////////////////////////
	});
	
	
}
	
	 
/////////////////// *** Close OnCreateMethod *** ///////////////////////////
	
	
				
}


/////////////////// *** Close Class ***  ///////////////////////////