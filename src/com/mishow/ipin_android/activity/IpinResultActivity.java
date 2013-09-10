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
//import android.widget.ImageView;
//import android.widget.TextView;
import android.widget.TextView;

public class IpinResultActivity extends Activity implements OnClickListener {

	private static final int LOGIN_SUCCESS_CODE = 200;
	private static final int LOGIN_FAILURE_CODE = 404;
	private Button returnButton;// fanhui button
	private TextView resulttext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IpinApplication.getInstance().addActivity(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//
		// 固定竖屏
		setContentView(R.layout.ipinresult);
		returnButton = (Button) findViewById(R.id.return_btn);
		returnButton.setOnClickListener(this);
		resulttext = (TextView) findViewById(R.id.resulttext);
		resulttext.setText("成功");
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			if (requestCode == LOGIN_SUCCESS_CODE) {
				System.out.println("result sss");
			} else if (requestCode == LOGIN_FAILURE_CODE) {
				System.out.println("result");
			}
		}
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.return_btn:
			onReturnBtnClick();
			break;
		default:
			break;
		}
	}

	private void onReturnBtnClick() {
		Intent intent = new Intent();
		intent.setClass(IpinResultActivity.this, LoginActivity.class);
		startActivity(intent);

	}
}
