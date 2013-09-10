package com.mishow.ipin_android.activity.test;

import com.mishow.ipin_android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	private ImageView ipinFun;//最主要的功能件
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ipinFun= (ImageView) findViewById(R.id.pin);
		ipinFun.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
		switch (v.getId()) {
		case R.id.pin:
			v.startAnimation(shake);
			ipin();
			break;
		default:
			break;
		}
	}

	private void ipin() {
		Intent intent=new Intent();  
        intent.setClass(MainActivity.this,AroundMeActivity.class);  
        startActivity(intent); 
	}
	
}
