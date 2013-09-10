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

/*
 * 区域适配
 * */
public class AreaAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<ArrayList<String>> mData;
	private boolean isTopLevel = true;

	private int typeIndex = 0;

	private Context context;

	public AreaAdapter(Context context) {
		this.context = context;
		this.mInflater = LayoutInflater.from(context);
		mData = getData();
	}

	public ArrayList<ArrayList<String>> getDataList() {
		return mData;
	}

	public String getSelect() {
		return mData.get(typeIndex).get(1);
	}

	public boolean isTopLevel() {
		return isTopLevel;
	}

	public void setTypeIndex(int index) {
		typeIndex = index;
		if (index > 0) {
			isTopLevel = false;
		} else {
			isTopLevel = true;
		}
	}

	@Override
	public int getCount() {
		if (isTopLevel) {
			return mData.size();
		} else {
			return mData.get(typeIndex).size() - 1;
		}

	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		convertView = mInflater.inflate(R.layout.dialog_list_item, null);

		if (isTopLevel) {
			View view = new View(context);
			LayoutParams param = new LayoutParams(30, 30);
			view.setLayoutParams(param);

			String area = mData.get(position).get(1);
			((TextView) convertView.findViewById(R.id.id_area)).setText(area);

			if (position == 0) {
				convertView.findViewById(R.id.ic_checked).setVisibility(View.VISIBLE);
			} else {
				((LinearLayout) convertView).addView(view, 0);
			}

		} else {

			String area = mData.get(typeIndex).get(position);
			((TextView) convertView.findViewById(R.id.id_area)).setText(area);

			if (position == 1) {
				View view = new View(context);
				LayoutParams param = new LayoutParams(30, 30);
				view.setLayoutParams(param);
				convertView.findViewById(R.id.ic_checked).setVisibility(View.VISIBLE);
				((LinearLayout) convertView).addView(view, 0);
			} else if (position > 1) {
				View view = new View(context);
				LayoutParams param = new LayoutParams(60, 30);
				view.setLayoutParams(param);
				((LinearLayout) convertView).addView(view, 0);
			}

		}

		return convertView;
	}

	private ArrayList<ArrayList<String>> getData() {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

		ArrayList<String> quanbu = new ArrayList<String>();
		quanbu.add("全部地区");
		quanbu.add("和平区");
		quanbu.add("南开区");
		data.add(quanbu);

		ArrayList<String> hepingqu = new ArrayList<String>();
		hepingqu.add("和平区");
		hepingqu.add("滨江道");
		hepingqu.add("鞍山道");
		hepingqu.add("百货大楼");
		data.add(hepingqu);

		ArrayList<String> nankai = new ArrayList<String>();
		nankai.add("南开区");
		nankai.add("大悦城");
		nankai.add("水游城");
		nankai.add("天津商场");
		data.add(nankai);

		return data;
	}
}
