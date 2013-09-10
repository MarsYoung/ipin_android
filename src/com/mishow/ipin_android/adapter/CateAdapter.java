package com.mishow.ipin_android.adapter;

import java.util.ArrayList;

import com.mishow.ipin_android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * 种类适配
 * 
 * @author mshootingstar
 * 
 */
public class CateAdapter extends BaseAdapter {
	private ArrayList<String> data;
	Context mContext;
	private LayoutInflater mInflater;

	public CateAdapter(Context context) {
		mContext = context;
		data = getData();
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(R.layout.dialog_list_item, null);

		String area = data.get(position);

		((TextView) convertView.findViewById(R.id.id_area)).setText(area);

		if (position == 1) {
			View view = new View(mContext);
			LayoutParams param = new LayoutParams(30, 30);
			view.setLayoutParams(param);
			convertView.findViewById(R.id.ic_checked).setVisibility(View.VISIBLE);
			((LinearLayout) convertView).addView(view, 0);
		} else if (position > 1) {
			View view = new View(mContext);
			LayoutParams param = new LayoutParams(60, 30);
			view.setLayoutParams(param);
			((LinearLayout) convertView).addView(view, 0);
		}

		return convertView;
	}

	private ArrayList<String> getData() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("拼笑脸");
		data.add("拼车");
		data.add("拼购物");
		data.add("拼美食");
		data.add("拼聊天");
		data.add("拼住宿");
		data.add("拼美丽");
		data.add("拼旅行");
		data.add("拼逛街");
		data.add("拼神马");
		return data;
	}
}