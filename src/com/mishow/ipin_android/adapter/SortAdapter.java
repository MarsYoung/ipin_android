package com.mishow.ipin_android.adapter;

import java.util.ArrayList;

import com.mishow.ipin_android.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*
 * 排序适配器
 * 
 * */
public class SortAdapter extends BaseAdapter
{
	private ArrayList<String> data;
	Context mContext;
	private LayoutInflater mInflater;
	private int disableIndex = -1;
	
	public SortAdapter(Context context)
	{
		mContext = context;
		data = getData();
		this.mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() 
	{
		return data.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return null;
	}

	@Override
	public long getItemId(int position) 
	{
		return 0;
	}

	 public boolean isEnabled(int position)
	 {
		 if(position == disableIndex)
		 {
			 return false;
		 }
		 return true;
	 }
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		convertView = mInflater.inflate(R.layout.dialog_list_item, null);
		
		String area = data.get(position);
		
		((TextView) convertView.findViewById(R.id.id_area)).setText(area);

		if(area.equals("titlebar"))
		{
			convertView = mInflater.inflate(R.layout.sort_title_item, null);
			disableIndex = position;
		}
		
		if(position == 0)
		{
			convertView.findViewById(R.id.ic_checked).setVisibility(View.VISIBLE);
		}
			
		
		return convertView;
	}
	
	private ArrayList<String> getData()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("10米以内");
		data.add("50米以内");
		data.add("100米以内");
		data.add("200米以内");
		data.add("500米以内");
		data.add("1000米以内");
		data.add("2000米以内");
		data.add("5000米以内");
		return data;
	}
}