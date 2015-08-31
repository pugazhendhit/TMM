package info.androidhive.slidingmenu;

import java.util.ArrayList;
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
import org.json.JSONObject;
import android.view.View.OnClickListener;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import info.androidhive.slidingmenuclient.R;

public class Register_SlotsFragment extends Fragment {
	private static final int MODE_PRIVATE = 0;
	SharedPreferences preferences;
	HttpResponse response;
	public String id,pass,id1,pass1,id2,tpass,n,un,name1;
	HttpClient httpclient;
	List<NameValuePair> nameValuePairs;
	public Register_SlotsFragment(){}
	String club,client,role;
	Spinner sItems;
	ProgressDialog progress;
	Button submit;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.register_slots, container, false);
        progress = new ProgressDialog(getActivity());
        
         sItems = (Spinner) rootView.findViewById(R.id.spinner1);
         submit = (Button) rootView.findViewById(R.id.login);
        
        preferences = getActivity().getSharedPreferences("7", MODE_PRIVATE);
        club=(preferences.getString("club", ""));
        client=(preferences.getString("client", ""));
         role = sItems.getSelectedItem().toString();
        
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 progress.setMessage("Please wait while Login... ");
			     progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			     progress.setIndeterminate(true);
			     progress.show();
				Loginfunction();
			}
		});
        return rootView;
    }
	
	private void Loginfunction() 
	{
		// TODO Auto-generated method stub
		new Thread()
		{
			@Override
			public void run()
			{
				 try{            
					
			            httpclient=new DefaultHttpClient();
			        HttpPost    httppost= new HttpPost("http://anythinginfotech.in/Android/club/register_slot.php");
			            nameValuePairs = new ArrayList<NameValuePair>(2);
			            nameValuePairs.add(new BasicNameValuePair("club_id",club));  
			            nameValuePairs.add(new BasicNameValuePair("user_id",client));
			            nameValuePairs.add(new BasicNameValuePair("role_name",role));
			            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			            response=httpclient.execute(httppost);
			            ResponseHandler<String> responseHandler = new BasicResponseHandler();
			          String  response_string = httpclient.execute(httppost, responseHandler);
			            System.out.println("Response11 : " + response_string);
			            JSONArray array=new JSONArray(response_string);
			            JSONObject DATA=null;
			            Log.e("tp", response_string);
                   for(int i=0;i<array.length();i++)
                    {
                  	   DATA=array.getJSONObject(0);
                  	  id1=DATA.getString("status");
                  	   pass1=DATA.getString("message");
                 
                   }
                  	getActivity(). runOnUiThread(new Runnable() 
                  	 {
			                public void run()
			                {
			                	
			                	if(id1.equals("SUCCESS"))
			                	{
			            			 // progress.cancel();
			            			 
			            			  
			                          
			            			 
					           		  progress.cancel();
			                		  Intent next=new Intent(getActivity(),MainActivity.class);
			                		  startActivity(next);
			            				 Toast.makeText(getActivity(), pass1, Toast.LENGTH_LONG).show();
					        	}
			                	
			                	 else
			                	 		{
					              			  progress.cancel();
					                	 Toast.makeText(getActivity(), pass1, Toast.LENGTH_LONG).show();
				                	  	} 
			                }
			            });
                    }catch(Exception e){
			            
			            System.out.println("Exception : " + e.getMessage());
			        }
	      	}
		}.start();
 	}
	
}
