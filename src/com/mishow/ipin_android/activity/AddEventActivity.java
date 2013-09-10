package com.mishow.ipin_android.activity;

import com.mishow.ipin_android.R;
import com.mishow.ipin_android.util.IpinApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddEventActivity extends Activity implements OnClickListener {
	private Button registerButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IpinApplication.getInstance().addActivity(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//
		setContentView(R.layout.addevent);
		registerButton = (Button) findViewById(R.id.register_btn_register);
		registerButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.return_btn_return:
			back();
			break;
		default:
			break;
		}
	}

	private void back() {
		Intent intent = new Intent();
		intent.setClass(AddEventActivity.this, LoginActivity.class);
		startActivity(intent);
	}
}
