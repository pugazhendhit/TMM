
//	@Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState) {
// 
//        View rootView = inflater.inflate(R.layout.view_slot, container, false);
   package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuserver.R;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/////////////////// *** Start  Class *** ///////////////////////////
public class View_SlotFragment  extends Activity {
    /** Called when the activity is first created. */
//////////////////*** Start OnCreateMethod *** ///////////////////////////	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.view_slot);
        
        ArrayList<SearchResults> searchResults = GetSearchResults();
        
        final ListView lv1 = (ListView) findViewById(R.id.ListView01);
        lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));
        
        lv1.setOnItemClickListener(new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
        		Object o = lv1.getItemAtPosition(position);
            	SearchResults fullObject = (SearchResults)o;
        		Toast.makeText(View_SlotFragment.this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
        	}  
        });
    }
    
/////////////////// *** Close OnCreateMethod *** ///////////////////////////
    private ArrayList<SearchResults> GetSearchResults(){
    	ArrayList<SearchResults> results = new ArrayList<SearchResults>();
    	
    	SearchResults sr1 = new SearchResults();
    	sr1.setName("Gautam");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Jane Doe");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Steve Young");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Fred Jones");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Bob Marsh");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Harold Funk");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Scott Dorf");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Jane Doe");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	sr1 = new SearchResults();
    	sr1.setName("Jane Doe");
    
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	sr1 = new SearchResults();
    	sr1.setName("Mike Hail");
    	
    	sr1.setPhone("10:30am");
    	results.add(sr1);
    	
    	return results;
    }
}

/////////////////// *** Close Class *** ///////////////////////////	