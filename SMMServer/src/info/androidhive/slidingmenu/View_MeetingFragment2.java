package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuserver.R;
import info.androidhive.slidingmenu.Tab_class;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;





import android.widget.ListView;

import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.sax.RootElement;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


/////////////////// *** Start  Class *** ///////////////////////////

public class View_MeetingFragment2 extends Fragment {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	EditText meetingname,time;
	String iddd,timeee,meetingnameee,work;
	String year11,month11,hour11,day11,minute11,totaltime;
	ImageView calender;
	 String year1,month1,day1,hour1,minute1,id;
	String id1,pass1,meetingnamee,timee,meetingidd;
	SharedPreferences pref;
	Button Edit,search;
	ProgressDialog pDialog;
	HttpPost httppost,httppost1;
	String response_string,response_string1,status1,message1,meetingname1,time1,response_stringg,meetingid ; 
	StringBuffer buffer;
	HttpResponse response,response1;
	HttpClient httpclient,httpclient1;
	String parsedString = "",master,topic,general,timer,ah,grammarian,ev1,ev2,ev3,ev4,ev5,sp1,sp2,sp3,sp4,sp5;
	ArrayAdapter<String> mAdapter;	
	List<NameValuePair> nameValuePairs, nameValuePairs11,nameValuePairs1;
	ListAdapter adapter;
	String masters,ev1s,ev2s,ev3s,ev4s,ev5s,sp1s,sp2s,sp3s,sp4s,sp5s,tables,generals,timers,ahs,gramarians;
	public View_MeetingFragment2(){}
	private static final String TAG_USER = "view_meeting";
	private static final String TAG_SENTFROM = "meeting name";
	private static final String TAG_MEETINGID = "meeting id";
	private static final String TAG_MASTER = "master_of_ceremony";
	private static final String TAG_TOPIC = "topic";
	private static final String TAG_GENERAL = "general_evaluator";
	private static final String TAG_TIMER = "timer";
	private static final String TAG_AH = "ah_counter";
	private static final String TAG_GRAMMARIAN = "grammarian";
	private static final String TAG_EVALUATOR1 = "evaluator";
	private static final String TAG_EVALUATOR2= "evaluator1";
	private static final String TAG_EVALUATOR3 = "evaluator2";
	private static final String TAG_EVALUATOR4 = "evaluator3";
	private static final String TAG_EVALUATOR5 = "evaluator4";
	private static final String TAG_SPEAKER1 = "speaker";
	private static final String TAG_SPEAKER2 = "speaker1";
	private static final String TAG_SPEAKER3 = "speaker2";
	private static final String TAG_SPEAKER4 = "speaker3";
	private static final String TAG_SPEAKER5 = "speaker4";
	private static final String TAG_DATE = "time date";
//	private static final String TAG_AMOUNT = "word";
	private static final String TAG_AMOUNT1 = "word";
	private static final String TAG_STATUS = "message";

private static final int MODE_PRIVATE = 0;
	ListView lv;
	Intent intent;
	View rootView;
	SharedPreferences preferences;
	String ID;
	// contacts JSONArray
	JSONArray line = null;

	ArrayList<HashMap<String, String>> contactList;
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
         rootView = inflater.inflate(R.layout.view_meeting, container, false);
         preferences = getActivity().getSharedPreferences("7", MODE_PRIVATE);
         ID=(preferences.getString("PASS", ""));
         
 		
         lv=(ListView)rootView.findViewById(R.id.list_view_meeting);
        contactList = new ArrayList<HashMap<String, String>>();
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
		pDialog.setCancelable(true);
		pDialog.show();
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // TODO Auto-generated method stub

            	 meetingid = ((TextView) view.findViewById(R.id.nameid))
							.getText().toString();
            	 master = ((TextView) view.findViewById(R.id.master))
							.getText().toString();
            	 timer= ((TextView) view.findViewById(R.id.timer))
							.getText().toString();
            	topic = ((TextView) view.findViewById(R.id.table))
							.getText().toString();
            	 general = ((TextView) view.findViewById(R.id.general))
							.getText().toString();
            	 grammarian = ((TextView) view.findViewById(R.id.gramarian))
							.getText().toString();
            	 ah = ((TextView) view.findViewById(R.id.ah))
							.getText().toString();
            	 ev1 = ((TextView) view.findViewById(R.id.ev1))
							.getText().toString();
            	 ev2 = ((TextView) view.findViewById(R.id.ev2))
							.getText().toString();
            	 ev3 = ((TextView) view.findViewById(R.id.ev3))
							.getText().toString();
            	 ev4 = ((TextView) view.findViewById(R.id.ev4))
							.getText().toString();
            	 ev5 = ((TextView) view.findViewById(R.id.ev5))
							.getText().toString();
            	 sp1 = ((TextView) view.findViewById(R.id.sp1))
							.getText().toString();
            	 sp2 = ((TextView) view.findViewById(R.id.sp2))
							.getText().toString();
            	 sp3 = ((TextView) view.findViewById(R.id.sp3))
							.getText().toString();
            	 sp4 = ((TextView) view.findViewById(R.id.sp4))
							.getText().toString();
            	 sp5= ((TextView) view.findViewById(R.id.sp5))
							.getText().toString();
         	
            	 meetingnamee = ((TextView) view.findViewById(R.id.meetingname))
							.getText().toString();
            	 
          	 work = ((TextView) view.findViewById(R.id.workk))
							.getText().toString();
         	 
					 timee = ((TextView) view.findViewById(R.id.email))
							.getText().toString();
					 
					 Intent update =new Intent(getActivity(),Create_MeetingFragupdate.class);
						update.putExtra("MEETINGNAME",meetingnamee );
						update.putExtra("TIMEE",timee );
						update.putExtra("MASTER",master );
						update.putExtra("TIMER",timer );
						update.putExtra("TOPIC",topic );
						update.putExtra("GENEARAL",general );
						update.putExtra("GRAMMARIAN",grammarian );
						update.putExtra("AH",ah );
						update.putExtra("EV1",ev1 );
						update.putExtra("EV2",ev2 );
						update.putExtra("EV3",ev3 );
						update.putExtra("EV4",ev4 );
						update.putExtra("EV5",ev5 );
						update.putExtra("SP1",sp1 );
						update.putExtra("SP2",sp2 );
						update.putExtra("SP3",sp3 );
						update.putExtra("SP4",sp4 );
						update.putExtra("SP5",sp5 );
						update.putExtra("WORK",work );
						update.putExtra("ID",meetingid );
					 startActivity(update);
                return true;
            }
        }); 
		lv.setOnItemClickListener(new OnItemClickListener() {
			
		
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				

           	 meetingidd = ((TextView) view.findViewById(R.id.nameid))
							.getText().toString();
          	 masters = ((TextView) view.findViewById(R.id.master))
						.getText().toString();

          	ev1s = ((TextView) view.findViewById(R.id.ev1))
				.getText().toString();
        	ev2s = ((TextView) view.findViewById(R.id.ev2))
    				.getText().toString();
        	ev3s = ((TextView) view.findViewById(R.id.ev3))
    				.getText().toString();
        	ev4s = ((TextView) view.findViewById(R.id.ev4))
    				.getText().toString();
        	ev5s = ((TextView) view.findViewById(R.id.ev5))
    				.getText().toString();
        	sp1s = ((TextView) view.findViewById(R.id.sp1))
    				.getText().toString();
        	sp2s = ((TextView) view.findViewById(R.id.sp2))
    				.getText().toString();
        	sp3s = ((TextView) view.findViewById(R.id.sp3))
    				.getText().toString();

        	sp4s = ((TextView) view.findViewById(R.id.sp4))
    				.getText().toString();

        	sp5s = ((TextView) view.findViewById(R.id.sp5))
    				.getText().toString();
        	tables = ((TextView) view.findViewById(R.id.table))
    				.getText().toString();
        	generals = ((TextView) view.findViewById(R.id.general))
    				.getText().toString();
        	timers = ((TextView) view.findViewById(R.id.timer))
    				.getText().toString();

        	ahs = ((TextView) view.findViewById(R.id.ah))
    				.getText().toString();
        	gramarians = ((TextView) view.findViewById(R.id.gramarian))
    				.getText().toString();

             	pref = getActivity().getSharedPreferences("9",MODE_PRIVATE);
     		  SharedPreferences.Editor editor = pref.edit();
     		  editor.putString("MID",meetingidd);
     		 editor.putString("masters",masters);
     		editor.putString("ev1s",ev1s);
     		editor.putString("ev2s",ev2s);
     		editor.putString("ev3s",ev3s);
     		editor.putString("ev4s",ev4s);
     		editor.putString("ev5s",ev5s);
     		editor.putString("sp1s",sp1s);
     		editor.putString("sp2s",sp2s);
     		editor.putString("sp5s",sp5s);
     		editor.putString("sp3s",sp3s);
     		editor.putString("sp4s",sp4s);
     		editor.putString("tables",tables);
     		editor.putString("generals",generals);
     		editor.putString("timers",timers);
     		editor.putString("ahs",ahs);
     		editor.putString("gramarians",gramarians);
     		  editor.commit();
           	Intent intentt = new Intent(getActivity(),
						Tab_class.class);
	                intentt.putExtra("messagefor", meetingidd);
	                 
	                
	                startActivity(intentt);
	                
				 



			}
		});

		new ProgressTask().execute();
        return rootView;
        
    }
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
	
	
	private class ProgressTask extends AsyncTask <Void,Void,Void>{
        @Override
        protected void onPreExecute(){
           
        }

        @Override
        protected Void doInBackground(Void... arg0) {
        	GeteData();
			return null;   
               //my stuff is here
        }

        @Override
        protected void onPostExecute(Void result) {
          
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
	                httppost1= new HttpPost("http://anythinginfotech.in/Android/club/view_meeting.php");
	                nameValuePairs1 = new ArrayList<NameValuePair>();
		      
		            
		            httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs1));
		          
	                response1=httpclient1.execute(httppost1);
	                ResponseHandler<String> responseHandler = new BasicResponseHandler();
	                response_string1 = httpclient1.execute(httppost1, responseHandler);
	                System.out.println("Response111 : " + response_string1);
	               Log.e("rdetail", response_string1);
	               
	                  
	                if (response_string1 != null) {
	    				try {
	    					JSONObject jsonObj = new JSONObject(response_string1);
	    					
	    					// Getting JSON Array node
	    					line = jsonObj.getJSONArray(TAG_USER);

	    					// looping through All Contacts
	    					for (int l = 0; l < line.length(); l++) {
	    						JSONObject c = line.getJSONObject(l);
	    						
	    						String sentfro = c.getString(TAG_SENTFROM);
	    						String dat = c.getString(TAG_DATE);
	    						String nk = c.getString(TAG_AMOUNT1);
	    						String id = c.getString(TAG_MEETINGID);
	    						String master = c.getString(TAG_MASTER);
	    						String topic= c.getString(TAG_TOPIC);
	    						String general= c.getString(TAG_GENERAL);
	    						String timer= c.getString(TAG_TIMER);
	    						String ah= c.getString(TAG_AH);
	    						String grammarian= c.getString(TAG_GRAMMARIAN);
	    						String evaluator1= c.getString(TAG_EVALUATOR1);
	    						String evaluator2= c.getString(TAG_EVALUATOR2);
	    						String evaluator3= c.getString(TAG_EVALUATOR3);
	    						String evaluator4= c.getString(TAG_EVALUATOR4);
	    						String evaluator5= c.getString(TAG_EVALUATOR5);
	    						String speaker1= c.getString(TAG_SPEAKER1);
	    						String speaker2= c.getString(TAG_SPEAKER2);
	    						String speaker3= c.getString(TAG_SPEAKER3);
	    						String speaker4= c.getString(TAG_SPEAKER4);
	    						String speaker5= c.getString(TAG_SPEAKER5);
	    						String status= c.getString(TAG_STATUS);
	    					
	    						String[] parts = dat.split("Time");
	    					String	 part1 = parts[0]; // 004
	    						String part22 = parts[1]; // 034556
	    					Log.e("tm", part1);
	    						HashMap<String, String> contact = new HashMap<String, String>();

	    						// adding each child node to HashMap key => value
	    						contact.put(TAG_SENTFROM,  sentfro);
	    						contact.put(TAG_DATE, part1+"\n"+"Time"+part22);
	    			
	    						contact.put(TAG_AMOUNT1, nk);
	    						contact.put(TAG_MEETINGID, id);
	    						contact.put(TAG_MASTER, master);
	    						contact.put(TAG_TOPIC, topic);
	    						contact.put(TAG_GENERAL, general);
	    						contact.put(TAG_TIMER, timer);
	    						contact.put(TAG_AH, ah);
	    						contact.put(TAG_GRAMMARIAN, grammarian);
	    						contact.put(TAG_EVALUATOR1, evaluator1);
	    						contact.put(TAG_EVALUATOR2, evaluator2);
	    						contact.put(TAG_EVALUATOR3, evaluator3);
	    						contact.put(TAG_EVALUATOR4, evaluator4);
	    						contact.put(TAG_EVALUATOR5, evaluator5);
	    						contact.put(TAG_SPEAKER1, speaker1);
	    						contact.put(TAG_SPEAKER2, speaker2);
	    						contact.put(TAG_SPEAKER3, speaker3);
	    						contact.put(TAG_SPEAKER4, speaker4);
	    						contact.put(TAG_SPEAKER5, speaker5);
	    						contact.put(TAG_STATUS, status);
	    						contactList.add(contact);
	    					}
	    					getActivity().runOnUiThread(new Runnable() {

	    		                @Override
	    		                public void run() {
	    		                	Setarray();
	    		                }
	    		            });
	    					
	    				} catch (JSONException e) {
	    					e.printStackTrace();
	    					
	    				}
	    			} else {
	    				Log.e("ServiceHandler", "Couldn't get any data from the url");
	    				
	    			}
			 

			 }
	                catch(Exception e)
			{
	            System.out.println("Exception : " + e.getMessage());
	           
	        }
			}

		

		
		
		}.start();
   
	

}
	public void Setarray() {
		// TODO Auto-generated method stub
			/**
		 * Updating parsed JSON data into ListView
		 * */
	//	CustomAdapter adapter = new CustomAdapter(this, contactList);
		if (pDialog.isShowing())
			pDialog.dismiss();
		adapter = new SimpleAdapter(
				getActivity(), contactList,
				R.layout.list_item3, new String[] { TAG_MEETINGID,TAG_AMOUNT1, TAG_DATE, TAG_SENTFROM,TAG_MASTER,
					TAG_TOPIC,TAG_GENERAL,TAG_TIMER,TAG_AH,TAG_GRAMMARIAN,TAG_EVALUATOR1,TAG_EVALUATOR2,TAG_EVALUATOR3,
					TAG_EVALUATOR4,TAG_EVALUATOR5,TAG_SPEAKER1,TAG_SPEAKER2,TAG_SPEAKER3,TAG_SPEAKER4,TAG_SPEAKER5,TAG_STATUS}, 
					new int[] { R.id.nameid,R.id.workk,
						R.id.email,R.id.meetingname ,R.id.master,R.id.table,R.id.general,R.id.timer,R.id.ah,R.id.gramarian,
						R.id.ev1,R.id.ev2,R.id.ev3,R.id.ev4,R.id.ev5,R.id.sp1,R.id.sp2,R.id.sp3,R.id.sp4,R.id.sp5,R.id.mobile});
        lv.setAdapter(adapter);
		// lv.setAdapter(mAdapter);
	}

	private void update() {
		// TODO Auto-generated method stub
		
		new Thread()
		{
			@Override
			public void run()
			{
				 try{            
					timeee=time.getText().toString();
					meetingnameee=meetingname.getText().toString();
			         HttpClient   httpclientt=new DefaultHttpClient();
			         HttpPost   httppostt= new HttpPost("http://anythinginfotech.in/Android/club/server/edit_meeting.php");
			          
				        
			            
				        nameValuePairs11 = new ArrayList<NameValuePair>(3);
			            nameValuePairs11.add(new BasicNameValuePair("m_id",iddd));  
			            nameValuePairs11.add(new BasicNameValuePair("m_name", meetingnameee));
	        	        nameValuePairs11.add(new BasicNameValuePair("time_date", timeee));
			            httppostt.setEntity(new UrlEncodedFormEntity(nameValuePairs11));
			       
			            ResponseHandler<String> responseHandler = new BasicResponseHandler();
			            response_stringg = httpclientt.execute(httppostt, responseHandler);
			            System.out.println("Response11 : " + response_stringg);
			            JSONArray arrayy=new JSONArray(response_stringg);
			            JSONObject DATAa=null;
			            Log.e("tpp", response_stringg);
                   for(int i=0;i<arrayy.length();i++)
                    {
                  	   DATAa=arrayy.getJSONObject(0);
                  	  id1=DATAa.getString("status");
                  	  if(id1.equals("SUCCESS")){
                  	   pass1=DATAa.getString("message");
                  	  
                  	  }
                  	  else{
                  		pass1=DATAa.getString("message");
                  	  }
                   }
                  	 getActivity().runOnUiThread(new Runnable() 
                  	 {
			                public void run()
			                {
			                	 Toast.makeText(getActivity(), pass1, Toast.LENGTH_LONG).show();
			                	if(id1.equals("SUCCESS"))
			                	{
			                 		  Intent next=new Intent(getActivity(),MainActivity.class);
			                		 
			                		  startActivity(next);
			            				
					        	}
			                	
			                	 else
			                	 		{
			                		 getActivity().runOnUiThread(new Runnable() 
			                      	 {
			    			                public void run()
			    			                {
					              		 Toast.makeText(getActivity(), pass1, Toast.LENGTH_LONG).show();
					              		Intent next=new Intent(getActivity(),Viewrequest.class);
				                		 
				                		  startActivity(next);
			    			                }});
			    			                } 
			                }
			            });
                    }catch(Exception e){
			            
			          
			        }
	      	}
		}.start();
	}
	
	@Override
	public void onActivityResult(int requestCode,int resultCode, Intent data)
	{
	  //  edtText.setText(data.getStringExtra("NAMA_PERASAT"));
	    
	     year11 =data.getStringExtra("year");
	     month11 =data.getStringExtra("month");
	     hour11 =data.getStringExtra("hour");
	     day11 =data.getStringExtra("day");
	     minute11 =data.getStringExtra("minute");
	   totaltime="Date:"+day11+"/"+month11+"/"+year11+ ", Time:"+hour11+":"+minute11+"";
	   time.setText(totaltime);
	}
	
}

/////////////////// *** Close Class *** ///////////////////////////	
