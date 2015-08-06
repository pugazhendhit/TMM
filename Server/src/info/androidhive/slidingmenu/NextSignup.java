package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuserver.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


/////////////////// *** Start  Class *** ///////////////////////////

public class NextSignup extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	
	public SharedPreferences preferences;
	 String club,name,con,pas;
	 Button Register;
	 String content1,status1,message1,c;
	 HttpEntity resEntity;
	 String response_string,response_string1; 
	 List<NameValuePair> nameValuePairs,nameValuePairs1;
	 HttpResponse response,response1;
	 HttpClient httpclient,httpclient1;
	 HttpPost httppost,httppost1;
	 EditText country ,state,city;
	 String  countryy ,statee,cityy;
	 ProgressBar progress3;
	
	 
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);	getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_next_signupp);
	
	        country=(EditText)findViewById(R.id.country);
	        
	        state=(EditText)findViewById(R.id.state);
	        
	        city=(EditText)findViewById(R.id.city);
	        Register=(Button)findViewById(R.id.register);
	    	progress3=(ProgressBar)findViewById(R.id.progressBar2);
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
		club=(preferences.getString("PASS", ""));
		 name=(preferences.getString("ID", ""));
		 con=(preferences.getString("N", ""));
		 pas=(preferences.getString("ROLEID", ""));
			progress3.setVisibility(View.INVISIBLE);
		 Toast.makeText(getApplicationContext(), club +" , "+ name +" , " + con +" , " +pas, 40000).show();
		 Register.setOnClickListener(new OnClickListener() {
			
			 
			@Override
			public void onClick(View arg0) {
				Save_Profile();
			}
			});
			
	}
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
		 
		 private void Save_Profile() {
		 
		 

										new Thread() {
												@Override
												public void run() { 
													if(country.length() > 0 && state.length() > 0 && city.length() > 0 )
										        
						
			        {
														countryy = country.getText().toString();   
													 	
													 	statee = state.getText().toString();
										                 
										              cityy= city.getText().toString();
						
							

								runOnUiThread(new Runnable() {
								   
								    	public void run() {
											progress3.setVisibility(View.VISIBLE);
									    	Register.setVisibility(View.INVISIBLE);
								    }
								});
						
				      HttpClient client = new DefaultHttpClient();
			    	    String postURL = ("http://anythinginfotech.in/Android/club/server/register_club.php");
			    	    HttpPost post = new HttpPost(postURL);
			    	    try {
			    	    	 String[] c = new String[] {
			     	             countryy,statee,cityy,club,name,con,pas
			     	        };
			     	      
			    	    	   
				             
				        	        
				        	        List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);
				        	        pairs.add(new BasicNameValuePair("country", countryy));
				        	        pairs.add(new BasicNameValuePair("state", statee));
				        	        pairs.add(new BasicNameValuePair("city", cityy));
				        	        pairs.add(new BasicNameValuePair("club_id", club));
				        	        pairs.add(new BasicNameValuePair("club_name", name));
				        	        pairs.add(new BasicNameValuePair("contact", con));
				        	        pairs.add(new BasicNameValuePair("pwd", pas));
				        	        UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
				        	        post.setEntity(uefe);
			    	   	 	
			    	        try{
			        	        HttpResponse response = client.execute(post);
			        	        
			        	         resEntity = response.getEntity();
			        	         content1 = EntityUtils.toString(resEntity);
							}  catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                System.out.println(content1);
			                Log.e("gju", content1);
			              // System.out.println("Response : " + con);
				            JSONArray array=new JSONArray(content1);
				            JSONObject DATA=null;
			             for(int i=0;i<array.length();i++)
			              {
			            	   DATA=array.getJSONObject(0);
			            	   status1=DATA.getString("status");
			            	   message1=DATA.getString("message");
			            	    
			            	    
			             }
			             runOnUiThread(new Runnable() {
							    public void run() {
							    	//progress2.cancel();
							    	Toast.makeText(getApplicationContext(),
								            message1, Toast.LENGTH_LONG).show();
							    	progress3.setVisibility(View.INVISIBLE);
							    	Register.setVisibility(View.VISIBLE);
							    	
							    	if(status1.equals("SUCCESS")){
							    		 Intent i= new Intent(NextSignup.this,Login.class);
										 startActivity(i); 
										 finish();
							    	}
							    }
			    	    });
							
			        	       
			        	    } catch (UnsupportedEncodingException uee) {
			        	        uee.printStackTrace();
			        	    } catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
							}
								 else
							        {
									 runOnUiThread(new Runnable() {
										    public void run() {
										    	Toast.makeText(getApplicationContext(),
										    			"Please fill all  the details", Toast.LENGTH_LONG).show();
										    }
										}); 

							        }
				
			       
					}
				}.start();
						
				      
			   
				}	}
					
	

/////////////////// *** Close Class *** ///////////////////////////	
