package com.mishow.ipin_android.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

/**
 * @author mshootingstar
 * 该类是通过HttpClient发送请求的封装
 */
public class IpinHttpClientUtil {
	
	/**
	 * @param client
	 * @param httpRequestBase
	 * @param encoding
	 * @return  生成执行该请求返回的字符串
	 * @throws IOException
	 */
	public static String getReturnStr(HttpClient client, HttpRequestBase httpRequestBase, String encoding)
			throws IOException {
		HttpResponse response = client.execute(httpRequestBase);
		// 获取header中的编码
		String charset = "";
		if (response.getLastHeader("Content-Type") != null
				&& response.getLastHeader("Content-Type").toString().contains("charset")) {
			String contentType = response.getLastHeader("Content-Type").getValue();
			charset = contentType.substring(contentType.indexOf("charset="), contentType.length());
		}
		// 如果获取失败则用默认编码
		if (null==charset) {
			if (null==encoding) {
				charset = "UTF-8";
			} else {
				charset = encoding;
			}
		}
		return EntityUtils.toString(response.getEntity(), charset);
	}
	
}
