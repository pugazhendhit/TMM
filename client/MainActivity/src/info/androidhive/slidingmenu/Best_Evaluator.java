package info.androidhive.slidingmenu;




import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import info.androidhive.slidingmenuclient.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
public class Best_Evaluator extends ListActivity {
	
	
	
	public ProgressDialog pDialog;
	HttpPost httppost,httppost1;
	String response_string,response_string1,status1,message1; 
	StringBuffer buffer;
	HttpResponse response,response1;
	HttpClient httpclient,httpclient1;
	String parsedString = "";
	ArrayAdapter<String> mAdapter;	
	List<NameValuePair> nameValuePairs, nameValuePairs1;
	public SharedPreferences preferences;
	String ID;
	// URL to get direct_income JSON
	private static final String TAG_USER = "show_voting";
	private static final String TAG_SENTFROM = "status";
	//private static final String TAG_DATE = "date";
	private static final String TAG_AMOUNT = "voting";
		JSONArray user = null;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;
	
	 public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
			getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.best_evaluater);

			preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
			ID=(preferences.getString("ID", ""));
		
			contactList = new ArrayList<HashMap<String, String>>();

			ListView lv = getListView();
			pDialog = new ProgressDialog(Best_Evaluator.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(true);
			pDialog.show();
			// Listview on item click listener
			
			GeteData();
			// Calling async task to get json
			new Getdirect_income().execute();
		}

		/**
		 * Async task class to get json by making HTTP call
		 * */
		private class Getdirect_income extends AsyncTask<Void, Void, Void> {

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				

			}

			@Override
			protected Void doInBackground(Void... arg0) {
				// Creating service handler class instance
				//GeteData();
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				
			}

		}
		private void GeteData() {
				// TODO Auto-generated method stub
				new Thread()
			{
				@Override
					public void run()
				{
			   
				try
					 {        
							httpclient1=new DefaultHttpClient();
			                httppost1= new HttpPost("http://anythinginfotech.in/Android/club/best_vote.php");
			                nameValuePairs1 = new ArrayList<NameValuePair>();
				           nameValuePairs1.add(new BasicNameValuePair("id",ID));
				           nameValuePairs1.add(new BasicNameValuePair("type","Direct Income"));
				            
				            httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs1));
				          
			                response1=httpclient1.execute(httppost1);
			                ResponseHandler<String> responseHandler = new BasicResponseHandler();
			                response_string1 = httpclient1.execute(httppost1, responseHandler);
			                System.out.println("Response111 : " + response_string1);
			                Log.e("rvote", response_string1);
			               // Toast.makeText(getApplicationContext(),"ut" +response_string1, 70000).show();
			                if (response_string1 != null) {
			    				try {
			    					JSONObject jsonObj = new JSONObject(response_string1);
			    					
			    					// Getting JSON Array node
			    					user = jsonObj.getJSONArray(TAG_USER);

			    					// looping through All Contacts
			    					for (int i = 0; i < user.length(); i++) {
			    						JSONObject c = user.getJSONObject(i);
			    						
			    						String sentfro = c.getString(TAG_SENTFROM);
			    						//String dat = c.getString(TAG_DATE);
			    						String amoun = c.getString(TAG_AMOUNT);
			    						
			    						// tmp hashmap for single contact
			    						HashMap<String, String> contact = new HashMap<String, String>();

			    						// adding each child node to HashMap key => value
			    						contact.put(TAG_SENTFROM, sentfro);
			    						//contact.put(TAG_DATE, "Date :-"+"\n"+dat+"\n");
			    						contact.put(TAG_AMOUNT, amoun);
			    						
			    						// adding contact to contact list
			    						contactList.add(contact);
			    						//}
			    					}
			    					 runOnUiThread(new Runnable()
			    		         	 	{
			    			                public void run() 
			    			                {
			    			                	Setarray();
			    			                }
			    			            });
			    					
			    				} catch (JSONException e) {
			    						Log.e("1", "error");
			    					e.printStackTrace();
			    					if (pDialog.isShowing())
			    						pDialog.dismiss();
			    		        	runOnUiThread(new Runnable()
			    	         	 	{
			    		                public void run() 
			    		                {
			    		                	Toast.makeText(getApplicationContext(), "Details Not Available", 70000).show();
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
			            Log.e("1", e.getMessage());
			           // Log.e("1", "2");
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
							Best_Evaluator.this, contactList,
							R.layout.list_summery, new String[] { TAG_SENTFROM, 
									TAG_AMOUNT }, new int[] { R.id.name,
									R.id.detail });

					setListAdapter(adapter);
				}

				}.start();
		}
	}









	
