package com.mishow.ipin_android.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mishow.ipin_android.R;

public class IpinCategoryData {
	public static List<Map<String, Object>> getData() {
		// 爱拼种类
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 每一个种类的map
		Map<String, Object> map = new HashMap<String, Object>();
		map = new HashMap<String, Object>();
		map.put("title", "拼逛街");
		map.put("img", R.drawable.wedding);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼笑脸");
		map.put("img", R.drawable.happy);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼车");
		map.put("img", R.drawable.car);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼购物");
		map.put("img", R.drawable.shopping);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼美食");
		map.put("img", R.drawable.food);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼聊天");
		map.put("img", R.drawable.life);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼住宿");
		map.put("img", R.drawable.hotel);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼美丽");
		map.put("img", R.drawable.beauty);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼旅行");
		map.put("img", R.drawable.sports);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "拼神马");
		map.put("img", R.drawable.baby);
		list.add(map);

		return list;
	}
}
