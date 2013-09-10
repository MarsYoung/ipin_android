package com.mishow.ipin_android.activity.test;


import android.app.Activity;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.KeyEvent;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.*;  
  
public class IntentTest extends Activity {  
      
    private LinearLayout mainView=null;  
    private Button button1=null;  
    private Button button2=null;  
      
    private LinearLayout layout=null;  
    private TextView tv=null;  
      
    /* 
     * 由于setContentVeiw()函数返回是void，系统中没有提供获取当前View的函数 
     * 所以此处添加一个整形变量用来指示当前View的id 
     */  
    private int currentViewId;  
      
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        //tv初始化   
        tv=new TextView(this);  
        tv.setText("这是layout里面的tv");  
        //layout初始化   
        layout=new LinearLayout(this);  
        layout.setId(100);//这里需要指定id，否则默认的id会和mainView一样，都是-1   
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));  
        layout.addView(tv);  
        //button1初始化   
        button1=new Button(this);  
        button1.setLayoutParams(new LinearLayout.LayoutParams(-2,-2));  
        button1.setText("Intent方式跳转");  
        button1.setOnClickListener(new OnClickListener(){  
            public void onClick(View v) {  
                /*此处用Intent来实现Activity与Activity之间的跳转*/  
                Intent intent=new Intent();  
                intent.setClass(IntentTest.this,MyActivity.class);  
                //Intent intent=new Intent(IntentTest.this,MyActivity.class);   
                startActivity(intent);  
            }  
        });  
        //button2初始化   
        button2=new Button(this);  
        button2.setLayoutParams(new LinearLayout.LayoutParams(-2,-2));  
        button2.setText("setContentView方式跳转");  
        button2.setOnClickListener(new OnClickListener(){  
            public void onClick(View v) {  
                //此处用setContentView方式来实现统一Activity不同View跳转   
                setCurrentView(layout);  
            }  
        });  
        //mianView初始化   
        mainView=new LinearLayout(this);  
        mainView.setId(1000);//指定id   
        mainView.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));  
        mainView.setOrientation(LinearLayout.VERTICAL);  
        mainView.addView(button1);  
        mainView.addView(button2);  
        //显示mainView   
        setCurrentView(mainView);  
    }  
      
    /* 
     * 这里重写onKeyDown()函数，实现返回键的监听 
     * 如果通过显示的View对keyListener进行监听，则返回键监听不到 
     * 所以此处是通过在Activity里面重写onKeyDown()函数来实现监听 
     * 此处如果不拦截监听的话，在显示layout后按返回键则直接执行退出程序 
     */  
    public boolean onKeyDown(int keyCode, KeyEvent event) {   
        if (keyCode == KeyEvent.KEYCODE_BACK) {   
            if(currentViewId==layout.getId()){  
                setCurrentView(mainView);  
            }else{  
                System.exit(0);  
            }  
            return false;   
        }   
        return false;   
    }  
      
    /*自定义函数setCurrentView()*/  
    public void setCurrentView(View view){  
        currentViewId=view.getId();  
        //此处用setContentView方式来实现统一Activity不同View跳转   
        setContentView(view);  
    }  
}  