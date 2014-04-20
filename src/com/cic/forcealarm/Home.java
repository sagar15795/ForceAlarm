package com.cic.forcealarm;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Home extends Activity{

	private static final int MY_NOTIFICATION_ID = 1;
	private final CharSequence notification = "Hey force alarm is ready to force you on  ";
	private final CharSequence contentText = "You've Been Notified!";
	private final CharSequence notificationTitle = "Alarm Set";
	private long[] mVibratePattern = { 0, 200, 200, 300 };
	static int n = 0,h,m;
	Time dtNow = new Time();
	
	int hours ,hour;
	int Min,min;
	int Sec;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		
		Button go = (Button)findViewById(R.id.button1);
		
		go.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TimePicker time = (TimePicker)findViewById(R.id.tpTime);
				time.clearFocus();
				h=time.getCurrentHour();
				m=time.getCurrentMinute();
				
				dtNow.setToNow();
				hours=dtNow.hour;
				Min=dtNow.minute;
				Sec=dtNow.second;
				if(h < hours){

					 hour= 24 - hours + h;
					 min=m-Min;	
					
				}else
				{hour=h-hours;
				 min=m-Min;		
				}
				n=hour*3600+min*60-Sec;
				
				
				
				Intent go = new Intent("com.cic.forcealarm.Alarmset");
				startActivity(go);
				finish();
			}
		});
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.about:
		DialogFragment aboutD = new aboutDialog();
		aboutD.show(getFragmentManager(), "ABOUT_DIALOG");
		return true;
		default:
		
			
		  
		}
		return false;
	}
	
	
	
}