package com.mishow.ipin_android.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.mishow.ipin_android.R;
import com.mishow.ipin_android.constant.IpinConstants;
import com.mishow.ipin_android.util.IpinURLConnectionUtil;
import com.mishow.ipin_android.util.IpinApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity implements OnClickListener {
	private Button registerButton;
	private EditText accountText;
	private EditText passwordText;
	private EditText passwordText2;
	private Button returnButton;
	private EditText realnameText;
	private EditText phoneText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IpinApplication.getInstance().addActivity(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//
		setContentView(R.layout.register);
		registerButton = (Button) findViewById(R.id.register_btn_register);
		registerButton.setOnClickListener(this);
		returnButton = (Button) findViewById(R.id.return_btn_return);
		returnButton.setOnClickListener(this);
		accountText = (EditText) findViewById(R.id.login_edit_account);
		passwordText = (EditText) findViewById(R.id.login_edit_pwd);
		passwordText2 = (EditText) findViewById(R.id.register_edit_pwd);
		realnameText = (EditText) findViewById(R.id.realname);
		phoneText = (EditText) findViewById(R.id.phone);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register_btn_register:
			onClickIpinRegister();
			break;
		case R.id.return_btn_return:
			back();
			break;
		default:
			break;
		}
	}

	private void onClickIpinRegister() {
		String username = accountText.getText().toString();
		String password = passwordText.getText().toString();
		String password2 = passwordText2.getText().toString();
		if (!password.equals(password2)) {
			System.out.println(username + " 注册失败");
			Intent intent = new Intent();
			intent.setClass(RegisterActivity.this, IpinResultActivity.class);
			startActivity(intent);
		} else {
			String realname = realnameText.getText().toString();
			String phone = phoneText.getText().toString();
			String url = "http://" + IpinConstants.HOST + "/ipin_server/user/register.action";
			String param = "username=" + username + "&password=" + password + "&realname=" + realname + "&phone="
					+ phone;
			String registerresult = IpinURLConnectionUtil.sendGet(url, param);
			JSONObject loginjo = new JSONObject();
			try {
				loginjo = new JSONObject(registerresult);
				if (loginjo.getInt("Status") == 1) {
					if (loginjo.getJSONObject("Result").getInt("ResultType") == 1) {
						System.out.println(username + " 注册成功");
						// 跳转画面
						Intent intent = new Intent();
						intent.setClass(RegisterActivity.this, HomePageActivity.class);
						startActivity(intent);
					}
				} else {
					System.out.println(username + " 注册失败");
					Intent intent = new Intent();
					intent.setClass(RegisterActivity.this, IpinResultActivity.class);
					startActivity(intent);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}

	private void back() {
		Intent intent = new Intent();
		intent.setClass(RegisterActivity.this, LoginActivity.class);
		startActivity(intent);
	}
}
