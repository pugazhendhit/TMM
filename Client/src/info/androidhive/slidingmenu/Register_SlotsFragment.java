package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////

public class Register_SlotsFragment extends Fragment {
	
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	public Register_SlotsFragment(){}
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.register_slots, container, false);
         
        return rootView;
    }

/////////////////// *** Close OnCreateMethod *** ///////////////////////////
}

/////////////////// *** Close Class *** ///////////////////////////	