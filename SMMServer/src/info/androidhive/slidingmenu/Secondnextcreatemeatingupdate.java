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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

/////////////////// *** Start  Class *** ///////////////////////////	
public class Secondnextcreatemeatingupdate extends Activity {
	

/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	

String speakerr1,speakerr2,speakerr3,speakerr4,speakerr5;

String speaker1,speaker2,iddd,speaker3,speaker4,speaker5,tabletopic,evaluatorr1,evaluatorr2,evaluatorr3,evaluatorr4,evaluatorr5,sp1,sp2,sp3,sp4,sp5;
Spinner spinnerspeaker;
public SharedPreferences preferences;
String themee,worrk,timee,mastr,evaluatr,timr,ahconter,gramarrn;
Button update;
String content1,status1,message1,c;
EditText speakere1,speakere2,speakere3,speakere4,speakere5;
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
		setContentView(R.layout.finalcreateupdate);
		  update=(Button)findViewById(R.id.update);
		  speakere1=(EditText)findViewById(R.id.speaker1);
		
		  speakere2=(EditText)findViewById(R.id.speaker2);
	
		  speakere3=(EditText)findViewById(R.id.speaker3);
		
		  speakere4=(EditText)findViewById(R.id.speaker4);
		
		  speakere5=(EditText)findViewById(R.id.speaker5);
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
			 tabletopic=(preferences.getString("N6", ""));
			 evaluatorr1=(preferences.getString("EV1",""));
			 evaluatorr2=(preferences.getString("EV2",""));
			 evaluatorr3=(preferences.getString("EV3",""));
			 evaluatorr4=(preferences.getString("EV4",""));
			 evaluatorr5=(preferences.getString("EV5",""));
			 iddd=(preferences.getString("IDD",""));
			 sp1=(preferences.getString("SP1", ""));
			 sp2=(preferences.getString("SP2", ""));
			 sp3=(preferences.getString("SP3", ""));
			 sp4=(preferences.getString("SP4", ""));
			 sp5=(preferences.getString("SP5", ""));
     		 progress3.setVisibility(View.INVISIBLE);
     		  speakere2.setText(sp2);
     		  speakere3.setText(sp3);
     		  speakere4.setText(sp4);
     		 speakere5.setText(sp5);
     	    
     		  speakere1.setText(sp1);
     		
			 
     		 

			
			update.setOnClickListener(new OnClickListener() {
				
				 
				@Override
				public void onClick(View arg0) {
					
					speakerr1=speakere1.getText().toString();
		 			speakerr2=speakere2.getText().toString();
		 			speakerr3=speakere3.getText().toString();
		 			speakerr4=speakere4.getText().toString();
		 			speakerr5=speakere5.getText().toString();
		 			
		 			if(speakerr1.length() > 0 && speakerr2.length() > 0 && speakerr3.length()>0){
					Save_Profile();}
				 
		 			else{
		 				
		 				Toast.makeText(getApplicationContext(), "Please fill minimum 3 Speakers", 400000);
		 				
		 			
				}
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
										    	update.setVisibility(View.INVISIBLE);
									    }
									});
							
					      HttpClient client = new DefaultHttpClient();
				    	    String postURL = ("http://anythinginfotech.in/Android/club/server/edit_meeting.php");
				    	    HttpPost post = new HttpPost(postURL);
				    	    try {
				    	    	 String[] c = new String[] {
				    	    			 tabletopic,themee,worrk,timee,mastr,evaluatr,timr,ahconter,gramarrn,speakerr1,speakerr2,speakerr3,speakerr4,speakerr5, evaluatorr1, evaluatorr2, evaluatorr3, evaluatorr4, evaluatorr5 
				     	        };
				     	      
				    	    	   
					             
					        	        
					        	        List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);
					        	        pairs.add(new BasicNameValuePair("m_id",iddd));  
					        	        pairs.add(new BasicNameValuePair("ah_counter", themee));
					        	        pairs.add(new BasicNameValuePair("grammarian", worrk));
					        	        pairs.add(new BasicNameValuePair("m_name", timee));
					        	        pairs.add(new BasicNameValuePair("word_of_day", mastr));
					        	        pairs.add(new BasicNameValuePair("topic", tabletopic));
					        	        pairs.add(new BasicNameValuePair("time_date", evaluatr));
					        	        pairs.add(new BasicNameValuePair("master_ceremony", timr));
					        	        pairs.add(new BasicNameValuePair("general_evaluator", ahconter));
					        	        pairs.add(new BasicNameValuePair("timer", gramarrn));
					        	        pairs.add(new BasicNameValuePair("speaker", speakerr1));
					        	        pairs.add(new BasicNameValuePair("speaker1", speakerr2));
					        	        pairs.add(new BasicNameValuePair("speaker2", speakerr3));
					        	        pairs.add(new BasicNameValuePair("speaker3", speakerr4));
					        	        pairs.add(new BasicNameValuePair("speaker4", speakerr5));
					        	        pairs.add(new BasicNameValuePair("evaluator", evaluatorr1));
					        	        pairs.add(new BasicNameValuePair("evaluator1", evaluatorr2));
					        	        pairs.add(new BasicNameValuePair("evaluator2", evaluatorr3));
					        	        pairs.add(new BasicNameValuePair("evaluator3", evaluatorr4));
					        	        pairs.add(new BasicNameValuePair("evaluator4", evaluatorr5));
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
								    	update.setVisibility(View.VISIBLE);
								    	
								    	if(status1.equals("SUCCESS")){
								    		 Intent i= new Intent(Secondnextcreatemeatingupdate.this,MainActivity.class);
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
				   

		



	


}
/////////////////// *** Close Class *** ///////////////////////////	