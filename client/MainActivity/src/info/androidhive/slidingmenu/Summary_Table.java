package info.androidhive.slidingmenu;


import info.androidhive.slidingmenuclient.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import android.view.View.OnClickListener;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/////////////////// *** Start  Class *** ///////////////////////////	

public class Summary_Table extends Activity {
	
	public SharedPreferences preferences;
	String ID;
	Button bms,btts,be,br;
	// URL to get direct_income JSON
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.summary_table);
		preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
		ID=(preferences.getString("ID", ""));
	
		bms=(Button)findViewById(R.id.bms);
		btts=(Button)findViewById(R.id.btts);
		be=(Button)findViewById(R.id.be);
		br=(Button)findViewById(R.id.br);
		bms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),Best_Meeting_Speaker.class);
				startActivity(in);
			}
		});
btts.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getApplicationContext(),Bset_Table_Topic_Speaker.class);
				startActivity(in);
			}
		});
be.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent in = new Intent(getApplicationContext(),Best_Evaluator.class);
		startActivity(in);
	}
});
br.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent in = new Intent(getApplicationContext(),Best_Roletaker.class);
		startActivity(in);
	}
});
		
  }
  
  /**
	 * Async task class to get json by making HTTP call
	 * */
	
}