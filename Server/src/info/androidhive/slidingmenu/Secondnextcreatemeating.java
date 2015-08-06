package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuserver.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

/////////////////// *** Start  Class *** ///////////////////////////	
public class Secondnextcreatemeating extends Activity implements OnItemSelectedListener{
	

/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	 private String[] state = {"Select Evaluator From List", "Evaluator 1", "Evaluator 2", 
	"Evaluator 3", " Evaluator 4", "Evaluator 5", "Evaluator 6",
	"Evaluator 7", "Evaluator 8"};
String evaluator;
Spinner spinnerevaluator;
private String[] state1 = { "Select Speaker From List","Speaker 1", "Speaker 2",
	"Speaker 3", " Speaker 4"};
String speaker;
Spinner spinnerspeaker;
public SharedPreferences preferences;
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

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_secondnextcreatemeating);
		  Create=(Button)findViewById(R.id.create);
	    	progress3=(ProgressBar)findViewById(R.id.progressBar2);
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
			themee=(preferences.getString("PASS", ""));
			 worrk=(preferences.getString("ID", ""));
			 timee=(preferences.getString("N", ""));
			 mastr=(preferences.getString("N1", ""));
			 evaluatr=(preferences.getString("N2", ""));
			 timr=(preferences.getString("N3", ""));
			 ahconter=(preferences.getString("N4", ""));
			 gramarrn=(preferences.getString("N5", ""));

			 progress3.setVisibility(View.INVISIBLE);
 
	spinnerevaluator= (Spinner) findViewById(R.id.spinnerevaluator);
	spinnerspeaker= (Spinner) findViewById(R.id.spinnerspeaker);
			ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, state);
			adapter_state
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerevaluator.setAdapter(adapter_state);
			spinnerevaluator.setOnItemSelectedListener(this);

			ArrayAdapter<String> adapter_state1 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, state1);
			adapter_state
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerspeaker.setAdapter(adapter_state1);
			spinnerspeaker.setOnItemSelectedListener(this);
			
			Create.setOnClickListener(new OnClickListener() {
				
				 
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
														
								

									runOnUiThread(new Runnable() {
									   
									    	public void run() {
												progress3.setVisibility(View.VISIBLE);
										    	Create.setVisibility(View.INVISIBLE);
									    }
									});
							
					      HttpClient client = new DefaultHttpClient();
				    	    String postURL = ("http://anythinginfotech.in/Android/club/server/meeting.php");
				    	    HttpPost post = new HttpPost(postURL);
				    	    try {
				    	    	 String[] c = new String[] {
				    	    			 themee,worrk,timee,mastr,evaluatr,timr,ahconter,gramarrn,speaker,evaluator 
				     	        };
				     	      
				    	    	   
					             
					        	        
					        	        List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);
					        	        pairs.add(new BasicNameValuePair("theme", themee));
					        	        pairs.add(new BasicNameValuePair("word_of_day", worrk));
					        	        pairs.add(new BasicNameValuePair("time_date", timee));
					        	        pairs.add(new BasicNameValuePair("master_ceremony", mastr));
					        	        pairs.add(new BasicNameValuePair("general_evaluator", evaluatr));
					        	        pairs.add(new BasicNameValuePair("timer", timr));
					        	        pairs.add(new BasicNameValuePair("ah_counter", ahconter));
					        	        pairs.add(new BasicNameValuePair("grammarian", gramarrn));
					        	        pairs.add(new BasicNameValuePair("speaker", speaker));
					        	        pairs.add(new BasicNameValuePair("evaluator", evaluator));
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
								    	Create.setVisibility(View.VISIBLE);
								    	
								    	if(status1.equals("SUCCESS")){
								    		 Intent i= new Intent(Secondnextcreatemeating.this,MainActivity.class);
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
									

								        
					
				       
						
					}.start();
							
}    
				   

		



	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		spinnerevaluator.setSelection(position);
	
		evaluator = (String)spinnerevaluator.getSelectedItem();

		
	}
	public void onItemSelected1(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
	
		spinnerspeaker.setSelection(position);
		
		speaker= (String)spinnerevaluator.getSelectedItem();

		 
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}	
		

	

}
/////////////////// *** Close Class *** ///////////////////////////	