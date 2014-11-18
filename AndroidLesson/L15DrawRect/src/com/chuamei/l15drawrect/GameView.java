package com.chuamei.l15drawrect;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {

	private Rect rect;
	private Rect[] rects = new Rect[20];
	
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public GameView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		for (int i = 0; i < rects.length; i++) {
			rect = new Rect();
			rects[i] = rect;
			rect.setView(this);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
		System.out.println("onDraw");
//		invalidate();
		for (int i = 0; i < rects.length; i++) {
			rects[i].draw(canvas);
		}
		handler.sendEmptyMessage(0);
		super.onDraw(canvas);
	}
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			invalidate();
		};
	};
}
