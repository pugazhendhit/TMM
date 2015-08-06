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

public class Summary_Table extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	String text;
  private ListView mainListView ;
  private ArrayAdapter<String> listAdapter ;
  
  
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().requestFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.summary_table);
    
    // Find the ListView resource. 
    mainListView = (ListView) findViewById( R.id.mainListView );

    // Create and populate a List of planet names.
    final String[] planets = new String[] { "BEST MEETING SPEAKER", "BEST TABLE TOPIC SPEAKER", "BEST EVALUATER", "BEST ROLE TAKER"};  
    ArrayList<String> planetList = new ArrayList<String>();
    planetList.addAll( Arrays.asList(planets) );
    
    // Create ArrayAdapter using the planet list.
    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
    
   
    mainListView.setAdapter( listAdapter );  
    mainListView.setOnItemClickListener(new OnItemClickListener() {
		
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			  text = planets[arg2];
		//	  Toast.makeText(getApplicationContext(), text, 70000).show();
//	            Intent i = new Intent(getApplication(), DirectInco.class);
//	            startActivity(i);
			  if(text.equals("CREATE MEETING")){
				//  Toast.makeText(getApplicationContext(), "1", 70000).show();
			//	  Toast.makeText(getApplicationContext(), text, 70000).show();
//		            Intent i = new Intent(getApplication(), Absolute_Avail.class);
//		            startActivity(i);
			  }
			  else if(text.equals("VIEW MEETING")){
				//  Toast.makeText(getApplicationContext(), "2", 70000).show();
//				  Intent i = new Intent(getApplication(),Twisted_avail.class);
//		            startActivity(i);
			  }
else if(text.equals("VIEW SLOT")){
	//  Toast.makeText(getApplicationContext(), "Not Available", 70000).show();
//	  Intent i = new Intent(getApplication(),Infinite_Avail.class);
//      startActivity(i);
			  }
else if(text.equals("ENROLL MEMBER")){
	  //Toast.makeText(getApplicationContext(), "Not Available", 70000).show();
//	 Intent i = new Intent(getApplication(),Circular_income.class);
//	    startActivity(i);
}

else {
	 // Toast.makeText(getApplicationContext(), "Not Available", 70000).show();
//	Intent i = new Intent(getApplication(),Grandiose_Sweetner.class);
//    startActivity(i);
}
 
		}
	});
  }
  
/////////////////// *** Close OnCreateMethod *** ///////////////////////////
}

/////////////////// *** Close Class *** ///////////////////////////	