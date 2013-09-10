package com.mishow.ipin_android.activity;

import com.mishow.ipin_android.R;
import com.mishow.ipin_android.util.IpinApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class HomePageActivity extends Activity {
	private GridView grid;
	private DisplayMetrics localDisplayMetrics;
	private View view;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		view = this.getLayoutInflater().inflate(R.layout.homepage, null);
		setContentView(view);
		IpinApplication.getInstance().addActivity(this);
		localDisplayMetrics = getResources().getDisplayMetrics();

		grid = (GridView) view.findViewById(R.id.my_grid);
		ListAdapter adapter = new GridAdapter(this);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(mOnClickListener);
	}

	private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			switch (parent.indexOfChild(v)) {
			case 0: {//我的拼凑按钮
				Intent intent = new Intent();
				intent.setClass(HomePageActivity.this, DingWeiActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
				break;
			}
			case 4: {//我的拼凑按钮
				Intent intent = new Intent();
				intent.setClass(HomePageActivity.this, CategoryActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
			}
			default: break;
			}

		}
	};

	public class GridAdapter extends BaseAdapter {
		private LayoutInflater inflater;

		public GridAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		public final int getCount() {
			return 9;
		}

		public final Object getItem(int paramInt) {
			return null;
		}

		public final long getItemId(int paramInt) {
			return paramInt;
		}

		public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
			paramView = inflater.inflate(R.layout.activity_label_item, null);
			TextView text = (TextView) paramView.findViewById(R.id.activity_name);

			switch (paramInt) {
			case 0: {
				text.setText("我的位置");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_local);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 1: {
				text.setText("查找好友");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_search);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 2: {
				text.setText("呼叫好友");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_checkin);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 3: {
				text.setText("我的钱包");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_promo);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 4: {
				text.setText("我的拼凑");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_tuan);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 5: {
				text.setText("我的计划");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_rank);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 6: {
				text.setText("时间列表");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_history);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}

			case 7: {
				text.setText("我的好友");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_myzone);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}
			case 8: {
				text.setText("添加好友");
				Drawable draw = getResources().getDrawable(R.drawable.home_button_more);
				draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
				text.setCompoundDrawables(null, draw, null, null);
				break;
			}
			}

			paramView.setMinimumHeight((int) (96.0F * localDisplayMetrics.density));
			paramView.setMinimumWidth(((-12 + localDisplayMetrics.widthPixels) / 3));

			return paramView;
		}
	}

//	public boolean onKeyUp(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK) {
//			this.finish();
//		}
//		return super.onKeyUp(keyCode, event);
//	}
	
	// 监听返回键事件
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			QuitApp();
			return true;

		}
		return false;
	}

	// 退出程序提醒
	public void QuitApp() {
		new AlertDialog.Builder(this)
				.setTitle("提示")
				.setMessage("确定退出?")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						IpinApplication.getInstance().exit();
						// exitApp();
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					}
				}).show();

	}

}