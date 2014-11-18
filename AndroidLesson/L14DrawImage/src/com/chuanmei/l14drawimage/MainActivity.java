package com.chuanmei.l14drawimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity implements OnTouchListener {

	private RelativeLayout mainLayout;
	private ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
	
		mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
		iv= (ImageView) mainLayout.findViewById(R.id.img);
		mainLayout.setOnTouchListener(this);
	}

	private RelativeLayout.LayoutParams ivLp;
	private float offsetX;
	private float offsetY;
	private ImageView currIv;
	
	@Override
	public boolean onTouch(View view, MotionEvent event) {

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			ivLp = (LayoutParams) iv.getLayoutParams();
			if (event.getX() > ivLp.leftMargin &&
					event.getX() < ivLp.leftMargin + iv.getWidth() &&
					event.getY() > ivLp.topMargin &&
					event.getY() < ivLp.topMargin + iv.getHeight()) {
				
				offsetX = event.getX() - ((float)ivLp.leftMargin);
				offsetY = event.getY() - ((float)ivLp.topMargin);
				
				currIv = iv;
			}
			
			break;
		case MotionEvent.ACTION_MOVE:
			
			if (currIv!=null) {
				ivLp = (LayoutParams) currIv.getLayoutParams();
				
				ivLp.leftMargin = (int) (event.getX() - offsetX);
				ivLp.topMargin = (int) (event.getY() - offsetY);
				
				currIv.setLayoutParams(ivLp);
			}
			
			break;
		case MotionEvent.ACTION_UP:
			
			currIv = null;
			
			break;

		default:
			break;
		}
		
		return true;
	}
}
