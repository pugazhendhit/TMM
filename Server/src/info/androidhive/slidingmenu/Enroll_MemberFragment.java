package info.androidhive.slidingmenu;


import info.androidhive.slidingmenuserver.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


/////////////////// *** Start  Class *** ///////////////////////////	

public class Enroll_MemberFragment extends ListActivity {

/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	
	String themee,worrk,timee,mastr,evaluatr,timr,ahconter,gramarrn;
	Button Create;
	String content1,status1,message1,c;
	HttpEntity resEntity;
	String response_string,response_string1; 
	List<NameValuePair> nameValuePairs,nameValuePairs1;
	HttpResponse response,response1;
	HttpClient httpclient,httpclient1;
	HttpPost httppost,httppost1;
	ProgressBar progress3;
	private ProgressDialog pDialog;
	Button viewreq;
	// URL to get contacts JSON
	private static String url = "http://anythinginfotech.in/Android/club/server/show_user_reg_status.php";

	// JSON Node names
	private static final String TAG_CONTACTS = "show_user_reg";
	private static final String TAG_ID = "user_name";
	private static final String TAG_NAME = "job_position";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_ADDRESS = "user_id";
	private static final String TAG_PHONE = "contact";
	
SharedPreferences preferences;
String ID;
 String namee,namee1,jobb1,jobb,clientidd1,clientidd,emaill1,emaill,contactt1,contactt;
	// contacts JSONArray
	JSONArray contacts = null;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.enroll_member);
		
		contactList = new ArrayList<HashMap<String, String>>();
		preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
		ID=(preferences.getString("PASS", ""));
	viewreq=(Button)findViewById(R.id.req);
	viewreq.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),Viewrequest.class);
			startActivity(i);
		}
	});
		
	
		Toast.makeText(getApplicationContext(), ID, 70000).show();
		ListView lv = getListView();

		// Listview on item click listener
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				 namee = ((TextView) view.findViewById(R.id.namee))
						.getText().toString();
				 jobb = ((TextView) view.findViewById(R.id.role))
						.getText().toString();
			 clientidd = ((TextView) view.findViewById(R.id.clientiddd))
						.getText().toString();
			 emaill = ((TextView) view.findViewById(R.id.email))
						.getText().toString();
			 contactt = ((TextView) view.findViewById(R.id.con))
						.getText().toString();
				final Dialog dialog = new Dialog(Enroll_MemberFragment.this);
			
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog2);
				

				// set the custom dialog components - text, image and button
				EditText membername = (EditText) dialog.findViewById(R.id.membername);
				membername.setText(contactt);
				namee1=membername.getText().toString();
				EditText job = (EditText) dialog.findViewById(R.id.jobposition);
				job.setText(emaill);
				jobb1=membername.getText().toString();
				EditText clientid = (EditText) dialog.findViewById(R.id.clientid);
				clientid.setText(namee);
				clientidd1=membername.getText().toString();
				EditText email = (EditText) dialog.findViewById(R.id.email);
				email.setText(jobb);
				emaill1=membername.getText().toString();
				EditText contact = (EditText) dialog.findViewById(R.id.contact);
				
		contact.setText(clientidd);
		contactt1=membername.getText().toString();

				dialog.show();
				
			
				// if button is clicked, close the custom dialog
				
				Button cancel =(Button) dialog.findViewById(R.id.cancel);
				
				cancel.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						finish();
					}
				});

			}
		});

		// Calling async task to get json
		new GetContacts().execute();
	}
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	

	/**
	 * Async task class to get json by making HTTP call
	 * */
	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(Enroll_MemberFragment.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			
Getdata();
			return null;
		}

		

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
		
		}
	}
	

	private void Getdata() {
		// TODO Auto-generated method stub
		new Thread()
	{
		@Override
			public void run()
		{
	   
		try
			 {        
		
					httpclient1=new DefaultHttpClient();
	                httppost1= new HttpPost("http://anythinginfotech.in/Android/club/server/show_user_reg.php");
	                nameValuePairs1 = new ArrayList<NameValuePair>();
		           nameValuePairs1.add(new BasicNameValuePair("club_id",ID));  
		            
		            httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs1));
		          
	                response1=httpclient1.execute(httppost1);
	                ResponseHandler<String> responseHandler = new BasicResponseHandler();
	                response_string1 = httpclient1.execute(httppost1, responseHandler);
	                System.out.println("Response111 : " + response_string1);
	                Log.e("r1111", response_string1);
	                if (pDialog.isShowing())
						pDialog.dismiss();
	                  
	                if (response_string1 != null) {
	    				try {
	    					JSONObject jsonObj = new JSONObject(response_string1);
	    					
	    					// Getting JSON Array node
	    					contacts = jsonObj.getJSONArray(TAG_CONTACTS);

	    					// looping through All Contacts
	    					for (int l = 0; l < contacts.length(); l++) {
	    						JSONObject c = contacts.getJSONObject(l);
	    						
	    						String id = c.getString(TAG_ID);
	    						String name = c.getString(TAG_NAME);
	    						String email = c.getString(TAG_EMAIL);
	    						String address = c.getString(TAG_ADDRESS);
	    			
	    						String phone = c.getString(TAG_PHONE);
	    						
	    				
	    						HashMap<String, String> contact = new HashMap<String, String>();

	    						// adding each child node to HashMap key => value
	    						contact.put(TAG_ID,  id);
	    						contact.put(TAG_NAME, name);
	    						contact.put(TAG_EMAIL, email);
	    						contact.put(TAG_ADDRESS, address);
	    						contact.put(TAG_PHONE, phone);
	    						contactList.add(contact);
	    					}
runOnUiThread(new Runnable()
{
public void run() 
{
	Setarray();
}
});
	    				} catch (JSONException e) {
	    					e.printStackTrace();
	    					if (pDialog.isShowing())
	    						pDialog.dismiss();
	    		        	runOnUiThread(new Runnable()
	    	         	 	{
	    		                public void run() 
	    		                {
	    		                	Toast.makeText(getApplicationContext(), "No Details Available", 70000).show();
	    		                }
	    		            });
	    				}
	    			} else {
	    				Log.e("ServiceHandler", "Couldn't get any data from the url");
	    				
	    			}
			 

			 }
	                catch(Exception e)
			{
	            System.out.println("Exception : " + e.getMessage());
	            if (pDialog.isShowing())
					pDialog.dismiss();
	        	runOnUiThread(new Runnable()
         	 	{
	                public void run() 
	                {
	                	Toast.makeText(getApplicationContext(), "Please Check Network Connection", 70000).show();
	                }
	            });
	        }
			}

		private void Setarray() {
			// TODO Auto-generated method stub
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			ListAdapter adapter = new SimpleAdapter(
					Enroll_MemberFragment.this, contactList,
					R.layout.list_item, new String[] {TAG_NAME,TAG_ID,   TAG_EMAIL,TAG_ADDRESS,TAG_PHONE}, new int[] { R.id.namee,R.id.con,
							R.id.role,R.id.email,R.id.clientiddd });

			setListAdapter(adapter);
		}

		
		
		}.start();
   
	

}
	

	
}

/////////////////// *** Close Class *** ///////////////////////////	