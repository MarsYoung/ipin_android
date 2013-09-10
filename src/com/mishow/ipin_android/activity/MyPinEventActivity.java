package com.mishow.ipin_android.activity;

import com.mishow.ipin_android.util.IpinApplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MyPinEventActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IpinApplication.getInstance().addActivity(this);
	}

	@Override
	public void onClick(View v) {

	}
}
