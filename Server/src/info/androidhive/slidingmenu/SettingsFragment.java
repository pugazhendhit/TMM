package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import info.androidhive.slidingmenuserver.R;

/////////////////// *** Start  Class *** ///////////////////////////	
public class SettingsFragment extends Fragment {
	 
/////////////////// *** Start  Variable Declaration *** ///////////////////////////
	
	public SettingsFragment(){}
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.settings, container, false);
         
        return rootView;
    }
	
}


/////////////////// *** Close Class *** ///////////////////////////	
