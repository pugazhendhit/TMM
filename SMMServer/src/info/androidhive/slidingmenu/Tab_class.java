package info.androidhive.slidingmenu;


import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import android.widget.TabHost;
import android.widget.TextView;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////	
@SuppressWarnings("deprecation")
public class Tab_class extends TabActivity {
	String meeting_id;
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_tabb);
		Intent intentt = getIntent();
		meeting_id = intentt.getStringExtra("messagefor");
		Log.e("Hello",meeting_id);
		Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
    
		TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
		tabHost.setup();
		TabHost mTabHost = getTabHost();
		
	       mTabHost.addTab(mTabHost.newTabSpec("Other")
	    		
	              .setIndicator(("REVIEWS"))
	         .setContent(new Intent(this, Review.class)));
	       mTabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.selector);
	       mTabHost.getTabWidget().getChildAt(0).getBottom();
     
	     
	  
	       mTabHost.addTab(mTabHost.newTabSpec("Family")
	               .setIndicator(("SUMMARY"))
	         .setContent(new Intent(this, Summary_Table.class)));
	       mTabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.selector);
	       mTabHost.getTabWidget().getChildAt(1).getBottom();
	    
	       
	 
	               mTabHost.setCurrentTab(0);
	               mTabHost.getTabWidget().getChildAt(0).getLayoutParams().width = 450;
	               mTabHost.getTabWidget().getChildAt(1).getLayoutParams().width = 450;

		       
	          for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++) 
	          {
	              TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
	              tv.setTextSize(13);
	              
	              tv.setTextColor(Color.parseColor("#ffffff"));
	          }
	         
	}
	/////////////////// *** Close OnCreateMethod *** ///////////////////////////			
	
}

/////////////////// *** Close Class *** ///////////////////////////	