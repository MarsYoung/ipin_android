package com.mishow.ipin_android.util;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

/**
 * @author mshootingstar
 * @description 这是一个单例，在其中定义了一个Appliction,持有了一个Activity List用来存放和关闭所有Activity
 */
public class IpinApplication extends Application {
	
	private List<Activity> activityList = new LinkedList<Activity>();
	private static IpinApplication instance;

	private IpinApplication() {
	}

	// 单例模式中获取唯一的MyApplication实例
	public static IpinApplication getInstance() {
		if (null == instance) {
			instance = new IpinApplication();
		}
		return instance;
	}

	// 添加Activity到容器中
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}

	// 遍历所有Activity并finish
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.exit(0);
	}
}