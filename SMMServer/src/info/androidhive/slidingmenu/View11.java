package info.androidhive.slidingmenu;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////
public class View11 extends Activity {
//////////////////*** Start OnCreateMethod *** ///////////////////////////	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_view1);
	}
//////////////////*** Close OnCreateMethod *** ///////////////////////////

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}

/////////////////// *** Close Class *** ///////////////////////////	