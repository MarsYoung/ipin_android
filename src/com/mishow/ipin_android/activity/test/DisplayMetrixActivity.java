package com.mishow.ipin_android.activity.test;

import com.mishow.ipin_android.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMetrixActivity extends Activity {

	private TextView tv;
	private Button btn;

	// 获取手机屏幕分辨率的类
	private DisplayMetrics dm;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_metrix);

		tv = (TextView) findViewById(R.id.tv);
		btn = (Button) findViewById(R.id.btnOK);
		btn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				dm = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(dm);
				// 获得手机的宽度和高度像素单位为px
				String strPM = "手机屏幕分辨率为:" + dm.widthPixels + "* " + dm.heightPixels;
				tv.setText(strPM);
			}
		});
	}

}
