package com.chuanmei.l09usinglayout;

import java.util.Timer;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity {

	private Timer timer;
	private TimerTask task;
	private ImageView img;
	private int speedX = 5;
	private int speedY = 5;
	private RelativeLayout mainLayout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		img = (ImageView) findViewById(R.id.img);
		mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
	}

	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			RelativeLayout.LayoutParams rlParams = (android.widget.RelativeLayout.LayoutParams) img.getLayoutParams();
		 	rlParams.leftMargin += speedX; 
		 	rlParams.topMargin += speedY;
		 	img.setLayoutParams(rlParams);
		 	
		 	if (rlParams.leftMargin > mainLayout.getWidth() - img.getWidth()) {
				speedX = -Math.abs(speedX);
			}else if (rlParams.leftMargin < 0) {
				speedX = Math.abs(speedX);
			}else if (rlParams.topMargin > mainLayout.getHeight() - img.getHeight()) {
				speedY = -Math.abs(speedY);
			}else if (rlParams.topMargin < 0) {
				speedY = Math.abs(speedY);
			}
		};
	};
	
	@Override
	protected void onResume() {
		
		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				handler.sendEmptyMessage(0);
			}
		};
		timer.schedule(task, 5, 5);
		
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		
		timer.cancel();
		task.cancel();
		
		super.onPause();
	}
}
