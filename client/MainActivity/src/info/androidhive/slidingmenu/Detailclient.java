package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuclient.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Detailclient extends Activity {
	
	TextView mastr,them,tim,table,gen,gramm,ahh,evv1,evv2,evv3,evv4,date,work,evv5,spp1,spp2,spp3,spp4,spp5;
	String theeme,woork,timee,timeee,meetingname,id,workk;
	String master,timer,topic,general,grammarian,ah,ev1,ev2,ev3,ev4,ev5,sp1,sp2,sp3,sp4,sp5;
	Button cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_detailclient);
		mastr=(TextView)findViewById(R.id.master);
		them=(TextView)findViewById(R.id.themetext);
		tim=(TextView)findViewById(R.id.time);
		table=(TextView)findViewById(R.id.topic);
		gen=(TextView)findViewById(R.id.general);
		gramm=(TextView)findViewById(R.id.gramm);
		ahh=(TextView)findViewById(R.id.ah);
		evv1=(TextView)findViewById(R.id.evulator1);
		evv2=(TextView)findViewById(R.id.evulator2);
		evv3=(TextView)findViewById(R.id.evulator3);
		evv4=(TextView)findViewById(R.id.evulator4);
		evv5=(TextView)findViewById(R.id.evulator5);
		spp1=(TextView)findViewById(R.id.speaker1);
		spp2=(TextView)findViewById(R.id.speaker2);
		spp3=(TextView)findViewById(R.id.speaker3);
		spp4=(TextView)findViewById(R.id.speaker4);
		spp5=(TextView)findViewById(R.id.speaker5);
		date=(TextView)findViewById(R.id.date);
		work=(TextView)findViewById(R.id.work);
		cancel=(Button)findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent cancel=new Intent(getApplicationContext(),MainActivity.class);
				finish();
				startActivity(cancel);
			}
		});
		Intent update=getIntent();
		meetingname=update.getStringExtra("MEETINGNAME");
		timeee=update.getStringExtra("TIMEE");
		id=update.getStringExtra("ID");
		master=update.getStringExtra("MASTER");
		timer=update.getStringExtra("TIMER");
		topic=update.getStringExtra("TOPIC");
		general=update.getStringExtra("GENEARAL");
		grammarian=update.getStringExtra("GRAMMARIAN");
		ah=update.getStringExtra("AH");
		ev1=update.getStringExtra("EV1");
		ev2=update.getStringExtra("EV2");
		ev3=update.getStringExtra("EV3");
		ev4=update.getStringExtra("EV4");
		ev5=update.getStringExtra("EV5");
		sp1=update.getStringExtra("SP1");
		sp2=update.getStringExtra("SP2");
		sp3=update.getStringExtra("SP3");
		sp4=update.getStringExtra("SP4");
		sp5=update.getStringExtra("SP5");
		workk=update.getStringExtra("WORK");
		
		work.setText(workk);
		mastr.setText(master);
		gramm.setText(grammarian);
		gen.setText(general);
		table.setText(topic);
	ahh.setText(ah);
date.setText(timeee);
		evv1.setText(ev1);
		evv2.setText(ev2);
		evv3.setText(ev3);
		evv4.setText(ev4);
		evv5.setText(ev5);
		spp1.setText(sp1);
		spp2.setText(sp2);
		spp3.setText(sp3);
		spp4.setText(sp4);
		spp5.setText(sp5);
		tim.setText(timer);
		them.setText(meetingname);
		
		
	}

	

}
