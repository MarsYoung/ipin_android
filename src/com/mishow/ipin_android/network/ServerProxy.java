package com.mishow.ipin_android.network;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerProxy {
	private int i = 0;
	private List<Map<String, Object>> list;

	public void sendRequest(final ServerListener listener) {
		final int num = i;
		if (i < 5) {
			Thread thread = new Thread() {
				@SuppressWarnings("static-access")
				public void run() {
					try {
						this.sleep(1000);
					} catch (Exception e) {

					}

					list = createData(num);
					if (i == 4) {
						listener.serverDataArrived(list, true);
					} else {
						listener.serverDataArrived(list, false);
					}

				}
			};
			thread.start();
			i++;
		}

	}

	private List<Map<String, Object>> createData(int i) {
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
//		try {
//			HttpClient client = new DefaultHttpClient();
////			HttpPost post = new HttpPost("");
////			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
////			parameters.add(new BasicNameValuePair("parameter1", "parameterValue1"));
////			parameters.add(new BasicNameValuePair("parameter2", "parameterValue2"));
////			post.setEntity(new UrlEncodedFormEntity(parameters));
//			HttpGet get = new HttpGet("");  
//			String result=IpinHttpClientUtil.getReturnStr(client, get, "UTF-8");
//			JSONObject resultjo=new JSONObject(result);
//			JSONObject resultdata=resultjo.getJSONObject("Result");
//			if(resultdata.getInt("ResultType")==1){
//				
//			}
//			
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}

		if (i == 0) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", true);
			map.put("promo", true);
			map.put("card", true);
			map.put("checkin", true);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);
		}

		if (i == 1) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);
		}

		if (i == 2) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);
		}

		if (i == 3) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);
		}

		if (i == 4) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);

			map = new HashMap<String, Object>();
			map.put("name", "相约大悦城！");
			map.put("price", "10.0");
			map.put("addr", "大悦城 重庆小天鹅");
			map.put("distance", "5.8km");
			map.put("tuan", false);
			map.put("promo", false);
			map.put("card", false);
			map.put("checkin", false);
			map.put("star", 50);
			map.put("area", "大悦城");
			list.add(map);
		}
		return list;
	}
}