package com.mishow.ipin_android.activity.test;

import com.mishow.ipin_android.R;
import com.mishow.ipin_android.activity.HomePageActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

@SuppressLint("HandlerLeak")
public class SplashActivity extends Activity
{
	private final int TIME_UP = 1;
	
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == TIME_UP)
			{
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, HomePageActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.splash_screen_fade, R.anim.splash_screen_hold);
				SplashActivity.this.finish();
			}
		}
	};
	
	public void onCreate(Bundle paramBundle) 
	{
		super.onCreate(paramBundle);
		setContentView(R.layout.splash_screen_view);

		new Thread() 
		{
			public void run() 
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (Exception e) 
				{

				}
				Message msg = new Message();
				msg.what = TIME_UP;
				handler.sendMessage(msg);
			}
		}.start();
		
	}
}