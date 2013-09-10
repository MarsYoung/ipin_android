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

/**
 * @author mshootingstar
 * 实现登录界面的Activity
 */
public class LoginActivity extends Activity implements OnClickListener {

	private Button loginButton;// 登录按钮
	private Button registerButton;// 注册按钮
	private EditText accountText;//用户名文本框
	private EditText passwordText;//密码文本框

	/* 
	 * 启动这个登录界面的时候执行的动作：设置布局等
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IpinApplication.getInstance().addActivity(this);//把该界面加入到项目中，方便管理
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//固定竖屏
		setContentView(R.layout.login);//设置布局
		loginButton = (Button) findViewById(R.id.login_btn_login);
		loginButton.setOnClickListener(this);
		registerButton = (Button) findViewById(R.id.register_btn_register);
		registerButton.setOnClickListener(this);
		accountText = (EditText) findViewById(R.id.login_edit_account);
		passwordText = (EditText) findViewById(R.id.login_edit_pwd);
	}

	/* 
	 * 在这里通过switch选择器来触发不同控件的onclick时间
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn_login:
			onClickIpinLogin();
			break;
		case R.id.register_btn_register:
			onClickIpinGOTORegister();
			break;
		default:
			break;
		}
	}

	/**
	 * 点击登录按钮的行为
	 */
	private void onClickIpinLogin() {
		String username = accountText.getText().toString();
		String password = passwordText.getText().toString();
		String url = IpinConstants.LoginURL;
		String param = "username=" + username + "&password=" + password;
		long startTime=System.currentTimeMillis();
		String loginresult = IpinURLConnectionUtil.sendGet(url, param);
		long endTime=System.currentTimeMillis();
		System.out.println(startTime-endTime);
		JSONObject loginjo = new JSONObject();
		try {
			loginjo = new JSONObject(loginresult);
			if (loginjo.getInt("Status") == 1) {
				if (loginjo.getJSONObject("Result").getInt("ResultType") == 1) {
					System.out.println(loginjo.getJSONObject("Result").getJSONArray("LoginUser").getJSONObject(0)
							.getString("username")
							+ " 登录成功");
					System.out.println(username + " 登录成功");
					// 跳转画面
					Intent intent = new Intent();
					intent.setClass(LoginActivity.this, HomePageActivity.class);
					startActivity(intent);
				}
			} else {
				System.out.println(username + " 登录失败");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 点击注册按钮的行为
	 */
	private void onClickIpinGOTORegister() {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
	}

}
