package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuserver.R;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


/////////////////// *** Start  Class *** ///////////////////////////

public class Login_Success extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	String text;
  private ListView mainListView ;
  private ArrayAdapter<String> listAdapter ;
  
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().requestFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.login_success);
    
    // Find the ListView resource. 
    mainListView = (ListView) findViewById( R.id.mainListView );

    // Create and populate a List of planet names.
    final String[] planets = new String[] { "CREATE MEETING", "VIEW MEETING", "VIEW SLOT", "ENROLL MEMBER"};  
    ArrayList<String> planetList = new ArrayList<String>();
    planetList.addAll( Arrays.asList(planets) );
    
    // Create ArrayAdapter using the planet list.
    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
    
   
    // Set the ArrayAdapter as the ListView's adapter.
    mainListView.setAdapter( listAdapter );  
  
    mainListView.setOnItemClickListener(new OnItemClickListener() {
		
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			  text = planets[arg2];
			  if(text.equals("CREATE MEETING")){
			
		            Intent i = new Intent(getApplication(), LogoutFragment.class);
		            startActivity(i);
			  }
			  else if(text.equals("VIEW MEETING")){
			
				  Intent i = new Intent(getApplication(),View_MeetingFragment2.class);
		            startActivity(i);
			  }
else if(text.equals("VIEW SLOT")){

	  Intent i = new Intent(getApplication(),Tab_class.class);
      startActivity(i);
			  }
else if(text.equals("ENROLL MEMBER")){
	
	 Intent i = new Intent(getApplication(),Enroll_MemberFragment.class);
	    startActivity(i);
}

else {
	
}
 
		}
	});
  }
  
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
}
/////////////////// *** Close Class *** ///////////////////////////	