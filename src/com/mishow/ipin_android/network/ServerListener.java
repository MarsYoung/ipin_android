package com.mishow.ipin_android.network;

import java.util.List;

public interface ServerListener 
{
	void serverDataArrived(@SuppressWarnings("rawtypes") List list, boolean isEnd);
}
