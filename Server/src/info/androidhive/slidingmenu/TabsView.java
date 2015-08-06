package info.androidhive.slidingmenu;




import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class TabsView extends Activity {
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	

	ArrayAdapter<String> adapter;
	String[] menu;
	MainLayout mainLayout;
	ActionBar actionBar;
	boolean visible=true;
	ListView Side_menu;
	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////
	
	public void onCreate(Bundle savedInstanceState)
    {
		 super.onCreate(savedInstanceState);
//		
		  //to make action bar custom transparent
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        View customActionBarView = getLayoutInflater().inflate(R.layout.actioncustom, null);
        actionBar.setCustomView(customActionBarView,   new ActionBar.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT,android.view.ViewGroup.LayoutParams.FILL_PARENT));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
     actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.seach_back));
      
    
	    mainLayout = (MainLayout)this.getLayoutInflater().inflate(R.layout.tab_host, null);
       
       setContentView(mainLayout);
       menu = new String[]{"CREATE MEETING","VIEW MEETING","VIEW SLOTS","ENROLL MEMBER"};
       
     Side_menu=(ListView)mainLayout.findViewById(R.id.Pro_menu);
     
     adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
     
     Side_menu.setAdapter(adapter);
    
 
       LayoutInflater inflater = getLayoutInflater();
       
       View actionbarview = inflater.inflate( R.layout.actioncustom, null);


    }
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
	
	//custom tab view
	
	   private static View createTabView(Context context, String tabText) {
	        View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null, false);
	        TextView tv = (TextView) view.findViewById(R.id.tabsText);
			tv.setText(tabText);
			tv.setTextSize(9);
	        return view;
	    }    

	   public void Show_Slider()
		{
			mainLayout.toggleMenu();
			if(visible)
			{
				//actionBar.hide();
				visible=false;

			}
			else
			{
				//actionBar.show();
				visible=true;
				
			}
			
		
		}
	

	
}

/////////////////// *** Close Class *** ///////////////////////////	
