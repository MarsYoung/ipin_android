package com.mishow.ipin_android.activity;
import com.mishow.ipin_android.R;
import com.mishow.ipin_android.util.IpinApplication;
import com.mishow.ipin_android.widget.QuickAction;
import com.mishow.ipin_android.widget.QuickActionBar;
import com.mishow.ipin_android.widget.QuickActionWidget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.*;
import android.widget.LinearLayout;


@SuppressLint("HandlerLeak")
public class DetailActivity extends Activity implements OnClickListener
{
	
	Handler handler = new Handler() 
	{
		public void handleMessage(Message paramMessage) 
		{
			if(paramMessage.what == 1)
			{//加载动画
				info.findViewById(R.id.loadingbar).setVisibility(View.GONE);
				//加载信息，目前去静态的写在这个文件中 
				info.findViewById(R.id.serverdata).setVisibility(View.VISIBLE);
			}
		}
	};
	
	private  LinearLayout info;
	private Animation enterAnim;
	private Animation exitAnim;
	private QuickActionWidget mBar;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		IpinApplication.getInstance().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.poidetail);

        LayoutInflater inflater = LayoutInflater.from(this);
        info = (LinearLayout)inflater.inflate(R.layout.poiinfo, null);
        
        LinearLayout scroll = (LinearLayout)findViewById(R.id.lite_list);
        
        @SuppressWarnings("deprecation")
		LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

        
        scroll.addView(info, layoutParams);
        
        new Thread()
        {
        	public void run()
        	{
        		try 
        		{
					Thread.sleep(1500);
				} 
        		catch (InterruptedException e) 
        		{
					e.printStackTrace();
				}
        		
        		Message msg = new Message();
        		msg.what = 1;
        		handler.sendMessage(msg);
        	}
        }.start();
        
        prepareQuickActionBar();
        enterAnim = AnimationUtils.loadAnimation(this, R.anim.anim_enter);
        exitAnim = AnimationUtils.loadAnimation(this, R.anim.anim_exit);
       
        View btnMore = findViewById(R.id.more);
        btnMore.setOnClickListener(this);
       
        //路线查询
//        View btnRequest = findViewById(R.id.);
//        btnRequest.setOnClickListener(this);
       
	}
	
	
	public void onClick(View v)
	{
		switch(v.getId())
		{
			case R.id.more:
			{
				View view = findViewById(R.id.popup_more);
				
				if(view.getVisibility() == View.VISIBLE)
				{
					view.startAnimation(exitAnim);
					view.setVisibility(View.GONE);
				}
				else
				{
					view.startAnimation(enterAnim);
					view.setVisibility(View.VISIBLE);
				}
				break;
			}
			
//			case R.id.requestroute:
//			{
//				mBar.show(v);
//				break;
//			}
		
		}
	
	}
	
	
	private void prepareQuickActionBar() {
		this.mBar = new QuickActionBar(this);
		this.mBar.addQuickAction(new MyQuickAction(this, R.drawable.icon_car,
				"开车"));
		this.mBar.addQuickAction(new MyQuickAction(this, R.drawable.icon_bus,
				"公交"));
		this.mBar.addQuickAction(new MyQuickAction(this, R.drawable.icon_walk,
				"步行"));
		// this.mBar.setOnQuickActionClickListener(this.mActionListener);
	}

	private static class MyQuickAction extends QuickAction {
		@SuppressWarnings("unused")
		private static final ColorFilter BLACK_CF = new LightingColorFilter(
				-16777216, -16777216);

		// public MyQuickAction(Context paramContext, int paramInt1, int
		// paramInt2)
		// {
		// super(buildDrawable(paramContext, paramInt1),
		// String.valueOf(paramInt2));
		// }

		public MyQuickAction(Context paramContext, int paramInt,
				CharSequence paramCharSequence) {
			super(paramContext, paramInt, paramCharSequence);
		}

		// private static Drawable buildDrawable(Context paramContext, int
		// paramInt)
		// {
		// Drawable localDrawable =
		// paramContext.getResources().getDrawable(paramInt);
		// localDrawable.setColorFilter(BLACK_CF);
		// return localDrawable;
		// }
	}
}