package com.chuanmei.l01helloandroid;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

	int adfsdfds= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate");
        
    }
    
    @Override
    protected void onStart() {
    	System.out.println("onStart");
    	super.onStart();
    }
    
    @Override
    protected void onResume() {
    	System.out.println("onResume");
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	System.out.println("onPause");
    	super.onPause();
    }
    
    @Override
    protected void onRestart() {
    	System.out.println("onRestart");
    	super.onRestart();
    }
    
    @Override
    protected void onStop() {
    	System.out.println("onStop");
    	super.onStop();
    }
    
    @Override
    protected void onDestroy() {
    	System.out.println("onDestroy");
    	super.onDestroy();
    }
    
    


}
