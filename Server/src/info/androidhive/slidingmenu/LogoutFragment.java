package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////	

public class LogoutFragment extends Fragment {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	public LogoutFragment(){}
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.logout, container, false);
         
        return rootView;
    }
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
}
/////////////////// *** Close Class *** ///////////////////////////	