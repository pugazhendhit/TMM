package info.androidhive.slidingmenu;


import java.util.ArrayList;
import info.androidhive.slidingmenu.Tab_class;
import info.androidhive.slidingmenuclient.R;

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
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



/////////////////// *** Start  Class *** ///////////////////////////

public class Review extends Activity {
	HttpPost httppost;
	String response_stringg,Number,Amount,Password; 
	StringBuffer buffer;
	HttpResponse response;
	HttpClient httpclient;
	String parsedString = "";
	List<NameValuePair> nameValuePairs11;
	String status1;
	TextView gra,time,ah,eva,eva2,eva3,eva4,eva5,ttmn,gen,mocn,sn,ttsn,sn2,sn3,sn4,sn5;
	String gra1,time1,ah1,eva1,id1;
	SharedPreferences preferences;
	Button graa, show,votegram,votetimer,voteahcounter,voteevaluater,voteevaluater2,voteevaluater3,voteevaluater4,voteevaluater5,votemaster,votegeneralevaluater,votettm,votespeaker,votespeaker2,votespeaker3,votespeaker4,votespeaker5,votetts;
	Button voteegram,voteetimer,voteeahcounter,voteeevaluater,voteeevaluater2,voteeevaluater3,voteeevaluater4,voteeevaluater5,voteemaster,voteegeneralevaluater,voteettm,voteespeaker,voteespeaker2,voteespeaker3,voteespeaker4,voteespeaker5,voteetts;
	String login_id;
	String type;
	String meeting_id;
	String status,message;
	String comment;
	SharedPreferences pref;
	String masters,ev1s,ev2s,ev3s,ev4s,ev5s,sp1s,sp2s,sp3s,sp4s,sp5s,tables,generals,timers,ahs,gramarians;
	Tab_class tc= new Tab_class();
/////////////////// *** Start OnCreateMethod *** ///////////////////////////

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_review);
	
		   pref = getApplicationContext().getSharedPreferences("9", MODE_PRIVATE);
	         meeting_id=(pref.getString("MID", ""));
	      masters=(pref.getString("masters", ""));
	      ev1s=(pref.getString("ev1s", ""));
	      ev2s=(pref.getString("ev2s", ""));
	      ev3s=(pref.getString("ev3s", ""));
	      ev4s=(pref.getString("ev4s", ""));
	      ev5s=(pref.getString("ev5s", ""));
	      sp1s=(pref.getString("sp1s", ""));
	      sp2s=(pref.getString("sp2s", ""));
	      sp3s=(pref.getString("sp3s", ""));
	      sp4s=(pref.getString("sp4s", ""));
	      sp5s=(pref.getString("sp5s", ""));
	      tables=(pref.getString("tables", ""));
	      generals=(pref.getString("generals", ""));
	      timers=(pref.getString("timers", ""));
	      ahs=(pref.getString("ahs", ""));
	      gramarians=(pref.getString("gramarians", ""));
	     
	        // Log.e("mmmm", meeting_id);
	         
		gra=(TextView)findViewById(R.id.gramn);
		gra.setText(":- "+gramarians);
		time=(TextView)findViewById(R.id.timn);
		time.setText(":- "+timers);
		ah=(TextView)findViewById(R.id.ahn);
		ah.setText(":- "+ahs);
		eva=(TextView)findViewById(R.id.evn);
		eva.setText(":- "+ev1s);
		eva2=(TextView)findViewById(R.id.evn2);
		eva2.setText(":- "+ev2s);
		eva3=(TextView)findViewById(R.id.evn3);
		eva3.setText(":- "+ev3s);
		eva4=(TextView)findViewById(R.id.evn4);
		eva4.setText(":- "+ev4s);
		eva5=(TextView)findViewById(R.id.evn5);
		eva5.setText(":- "+ev5s);
		
		ttmn=(TextView)findViewById(R.id.ttmn);
		ttmn.setText(":- "+tables);
		gen=(TextView)findViewById(R.id.gen);
		gen.setText(":- "+generals);
		mocn=(TextView)findViewById(R.id.mocn);
		mocn.setText(":- "+masters);
		sn=(TextView)findViewById(R.id.sn);
		sn.setText(":- "+sp1s);
		sn2=(TextView)findViewById(R.id.sn2);
		sn2.setText(":- "+sp2s);
		
		sn3=(TextView)findViewById(R.id.sn3);
		sn3.setText(":- "+sp3s);
		
		sn4=(TextView)findViewById(R.id.sn4);
		sn4.setText(":- "+sp4s);
		
		sn5=(TextView)findViewById(R.id.sn5);
		sn5.setText(":- "+sp5s);
		
		ttsn=(TextView)findViewById(R.id.ttsn);
		ttsn.setText(":- "+tables);
		
		
		
		
		
		//show=(Button)findViewById(R.id.show);
		
		votegram=(Button)findViewById(R.id.votegram);
		votetimer=(Button)findViewById(R.id.votetimer);
		voteahcounter=(Button)findViewById(R.id.voteahcounter);
		voteevaluater2=(Button)findViewById(R.id.voteevaluater2);
		voteevaluater3=(Button)findViewById(R.id.voteevaluater3);
		voteevaluater4=(Button)findViewById(R.id.voteevaluater4);
		voteevaluater5=(Button)findViewById(R.id.voteevaluater5);
		voteevaluater=(Button)findViewById(R.id.voteevaluater);
		votemaster=(Button)findViewById(R.id.votemasterceremony);
		votegeneralevaluater=(Button)findViewById(R.id.votegenerateevaluater);
		votettm=(Button)findViewById(R.id.votettm);
		votespeaker=(Button)findViewById(R.id.votespeaker);
		votespeaker2=(Button)findViewById(R.id.votespeaker2);
		votespeaker3=(Button)findViewById(R.id.votespeaker3);
		votespeaker4=(Button)findViewById(R.id.votespeaker4);
		votespeaker5=(Button)findViewById(R.id.votespeaker5);
		votetts=(Button)findViewById(R.id.votettc);

		voteegram=(Button)findViewById(R.id.reviewgram);
		voteetimer=(Button)findViewById(R.id.reviewtimer);
		voteeahcounter=(Button)findViewById(R.id.reviewahcounter);
		voteeevaluater2=(Button)findViewById(R.id.reviewevaluater2);
		voteeevaluater3=(Button)findViewById(R.id.reviewevaluater3);
		voteeevaluater4=(Button)findViewById(R.id.reviewevaluater4);
		voteeevaluater5=(Button)findViewById(R.id.reviewevaluater5);
		voteeevaluater=(Button)findViewById(R.id.reviewevaluater);
		voteemaster=(Button)findViewById(R.id.reviewmoc);
		voteegeneralevaluater=(Button)findViewById(R.id.reviewge);
		voteettm=(Button)findViewById(R.id.reviewttm);
		voteespeaker=(Button)findViewById(R.id.reviewspeaker);
		voteespeaker2=(Button)findViewById(R.id.reviewspeaker2);
		
		voteespeaker3=(Button)findViewById(R.id.reviewspeaker3);
		
		voteespeaker4=(Button)findViewById(R.id.reviewspeaker4);
		
		voteespeaker5=(Button)findViewById(R.id.reviewspeaker5);
		
		voteetts=(Button)findViewById(R.id.reviewtts);
		
		 preferences = Review.this.getSharedPreferences("7", MODE_PRIVATE);
         login_id=(preferences.getString("PASS", ""));
       
         
         
         
 		
votegram.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
				type="grammarian";
				//Log.e("ghhhh", meeting_id);
				votefunction();
				
			}
		});
voteegram.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="grammarrian";
		final Dialog dialoggg = new Dialog(Review.this);
		dialoggg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoggg.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoggg.findViewById(R.id.create);
		EditText c = (EditText) dialoggg.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
			
		dialoggg.show();
	}
});
votetimer.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="timer";
		votefunction();
		
	}
});
voteetimer.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="timer";
		//voteefunction();
		final Dialog dialogt = new Dialog(Review.this);
		dialogt.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogt.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogt.findViewById(R.id.create);
		EditText c = (EditText) dialogt.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogt.show();
		
		

		
	}
});
voteahcounter.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="ah Counter";
		votefunction();
		
	}
});
voteeahcounter.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="ah counter";
//		voteefunction();
		final Dialog dialoga = new Dialog(Review.this);
		dialoga.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoga.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoga.findViewById(R.id.create);
		EditText c = (EditText) dialoga.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialoga.show();
		
	}
});
voteevaluater.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater1";
		votefunction();
		
	}
});
voteevaluater2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater2";
		votefunction();
		
	}
});
voteevaluater3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater3";
		votefunction();
		
	}
});
voteevaluater4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater4";
		votefunction();
		
	}
});
voteevaluater5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater5";
		votefunction();
		
	}
});
voteeevaluater.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater2";
	//	voteefunction();
		final Dialog dialoge = new Dialog(Review.this);
		dialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoge.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoge.findViewById(R.id.create);
		EditText c = (EditText) dialoge.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialoge.show();
		
	}
});
voteeevaluater2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater2";
	//	voteefunction();
		final Dialog dialoge = new Dialog(Review.this);
		dialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoge.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoge.findViewById(R.id.create);
		EditText c = (EditText) dialoge.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialoge.show();
		
	}
});
voteeevaluater3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater3";
	//	voteefunction();
		final Dialog dialoge = new Dialog(Review.this);
		dialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoge.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoge.findViewById(R.id.create);
		EditText c = (EditText) dialoge.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialoge.show();
		
	}
});
voteeevaluater4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater4";
	//	voteefunction();
		final Dialog dialoge = new Dialog(Review.this);
		dialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoge.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoge.findViewById(R.id.create);
		EditText c = (EditText) dialoge.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialoge.show();
		
	}
});
voteeevaluater5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="evaluater5";
	//	voteefunction();
		final Dialog dialoge = new Dialog(Review.this);
		dialoge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialoge.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialoge.findViewById(R.id.create);
		EditText c = (EditText) dialoge.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialoge.show();
		
	}
});
votemaster.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="master of ceromany";
		votefunction();
		
	}
});
voteemaster.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="master of ceromany";
	//	voteefunction();
		final Dialog dialogm = new Dialog(Review.this);
		dialogm.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogm.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogm.findViewById(R.id.create);
		EditText c = (EditText) dialogm.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogm.show();
		
	}
});
votegeneralevaluater.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="general evaluater";
		votefunction();
		
	}
});
voteegeneralevaluater.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="general evaluater";
	//	voteefunction();
		final Dialog dialogge = new Dialog(Review.this);
		dialogge.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogge.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogge.findViewById(R.id.create);
		EditText c = (EditText) dialogge.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogge.show();
		
	}
});
votettm.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="table topic master";
		votefunction();
		
	}
});
voteettm.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="table topic master";
	//	voteefunction();
		final Dialog dialogttm = new Dialog(Review.this);
		dialogttm.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogttm.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogttm.findViewById(R.id.create);
		EditText c = (EditText) dialogttm.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogttm.show();
		
	}
});
votespeaker.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker1";
		votefunction();
		
	}
});
votespeaker2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker2";
		votefunction();
		
	}
});
votespeaker3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker3";
		votefunction();
		
	}
});
votespeaker4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker4";
		votefunction();
		
	}
});
votespeaker5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker5";
		votefunction();
		
	}
});
voteespeaker.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker1";
		//voteefunction();
		final Dialog dialogs = new Dialog(Review.this);
		dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogs.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogs.findViewById(R.id.create);
		EditText c = (EditText) dialogs.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogs.show();
		
	}
});
voteespeaker2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker2";
		//voteefunction();
		final Dialog dialogs = new Dialog(Review.this);
		dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogs.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogs.findViewById(R.id.create);
		EditText c = (EditText) dialogs.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogs.show();
		
	}
});
voteespeaker3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speake3r";
		//voteefunction();
		final Dialog dialogs = new Dialog(Review.this);
		dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogs.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogs.findViewById(R.id.create);
		EditText c = (EditText) dialogs.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogs.show();
		
	}
});
voteespeaker4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker4";
		//voteefunction();
		final Dialog dialogs = new Dialog(Review.this);
		dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogs.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogs.findViewById(R.id.create);
		EditText c = (EditText) dialogs.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogs.show();
		
	}
});
voteespeaker5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="speaker5";
		//voteefunction();
		final Dialog dialogs = new Dialog(Review.this);
		dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogs.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogs.findViewById(R.id.create);
		EditText c = (EditText) dialogs.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogs.show();
		
	}
});
votetts.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="table topic speaker";
		votefunction();
		
	}
});
voteetts.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(Review.this,"Try Again", Toast.LENGTH_LONG).show();
		type="table topic speaker";
	//	voteefunction();
		final Dialog dialogtts = new Dialog(Review.this);
		dialogtts.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialogtts.setContentView(R.layout.dialogwrite);
		Button graaa = (Button) dialogtts.findViewById(R.id.create);
		EditText c = (EditText) dialogtts.findViewById(R.id.c);
			comment=c.getText().toString();
			graaa.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					voteefunction();
				}
			});
		dialogtts.show();
		
	}
});
		/*Intent update1=getIntent();
		meeting_id=update1.getStringExtra("ID");*/
		
			}

/////////////////// *** Close OnCreateMethod *** ///////////////////////////		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_review, menu);
		return true;
	}
	
	
	
	private void votefunction() 
	{
		// TODO Auto-generated method stub
		new Thread()
		{
			@Override
			public void run()
			{
				 try{        
					 //Log.e("hhh", meeting_id);
					Log.e("id", login_id);
					Log.e("client_id","29");
					Log.e("type",type);
			        HttpClient    httpclient1=new DefaultHttpClient();
			         HttpPost   httppost1= new HttpPost("http://anythinginfotech.in/Android/club/vote.php");
			         List<NameValuePair>   nameValuePairs = new ArrayList<NameValuePair>(2);
			            nameValuePairs.add(new BasicNameValuePair("client_id",login_id));  
			            nameValuePairs.add(new BasicNameValuePair("meeting_id",meeting_id));
			            nameValuePairs.add(new BasicNameValuePair("type",type));
			            httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse    response1=httpclient1.execute(httppost1);
			            ResponseHandler<String> responseHandler1 = new BasicResponseHandler();
			         String   response_string1 = httpclient1.execute(httppost1, responseHandler1);
			            System.out.println("Response11 : " + response_string1);
			            JSONArray array1=new JSONArray(response_string1);
			            JSONObject DATA=null;
			            Log.e("tp", response_string1);
                   for(int i=0;i<array1.length();i++)
                    {
                  	   DATA=array1.getJSONObject(0);
                  	status =DATA.getString("status");
                  	   message=DATA.getString("message");
                 
                   }
                  	 runOnUiThread(new Runnable() 
                  	 {
			                public void run()
			                {
			                	if(status.equals("SUCCESS"))
			                	{
			                		Toast.makeText(getApplicationContext(), message, 7000).show();
			                		Intent in= new Intent(getApplicationContext(),MainActivity.class);
			                		startActivity(in);
			                	}
			                	else{
			                		Toast.makeText(getApplicationContext(), message, 7000).show();
			                	}
			                	
			                }
			            });
                    }catch(Exception e){
			            
			            System.out.println("Exception : " + e.getMessage());
			        }
	      	}
		}.start();
 	}
	private void voteefunction() 
	{
		// TODO Auto-generated method stub
		new Thread()
		{
			@Override
			public void run()
			{
				 try{            
					Log.e("id", login_id);
					Log.e("client_id","29");
					Log.e("type",type);
			        HttpClient    httpclient1=new DefaultHttpClient();
			         HttpPost   httppost1= new HttpPost("http://anythinginfotech.in/Android/club/comment.php");
			         List<NameValuePair>   nameValuePairs = new ArrayList<NameValuePair>(2);
			            nameValuePairs.add(new BasicNameValuePair("m_s_id",login_id));  
			            nameValuePairs.add(new BasicNameValuePair("client_id",meeting_id));
			            nameValuePairs.add(new BasicNameValuePair("type",type));
			            nameValuePairs.add(new BasicNameValuePair("comment",comment));
			            httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse    response1=httpclient1.execute(httppost1);
			            ResponseHandler<String> responseHandler1 = new BasicResponseHandler();
			         String   response_string1 = httpclient1.execute(httppost1, responseHandler1);
			            System.out.println("Response11 : " + response_string1);
			            JSONArray array1=new JSONArray(response_string1);
			            JSONObject DATA=null;
			            Log.e("tp", response_string1);
                   for(int i=0;i<array1.length();i++)
                    {
                  	   DATA=array1.getJSONObject(0);
                  	status =DATA.getString("status");
                  	   message=DATA.getString("message");
                 
                   }
                  	 runOnUiThread(new Runnable() 
                  	 {
			                public void run()
			                {
			                	if(status.equals("SUCCESS"))
			                	{
			                		Toast.makeText(getApplicationContext(), message, 7000).show();
			                		Intent in= new Intent(getApplicationContext(),MainActivity.class);
			                		startActivity(in);
			                	}
			                	else{
			                		Toast.makeText(getApplicationContext(), message, 7000).show();
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

/////////////////// *** Close Class *** ///////////////////////////	