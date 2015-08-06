package info.androidhive.slidingmenu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////

public class Add_Enroll extends Activity {
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.add_enroll);
	}
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.activity_createmeeting, menu);
		return true;
	}
	
	

}


/////////////////// *** Close Class *** ///////////////////////////	