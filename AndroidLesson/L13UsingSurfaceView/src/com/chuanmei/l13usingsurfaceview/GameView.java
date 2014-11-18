package com.chuanmei.l13usingsurfaceview;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

	public GameView(Context context) {
		super(context);
		getHolder().addCallback(this);
	}

	private Timer timer;
	private TimerTask task;
	private float x = 50;
	private float y = 50;
	
	private float speedY = 3;
	
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	private final Paint paint = new Paint();
	
	private void drawView(){
		
		paint.setColor(0xffff0000);
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(0xffffffff);
		
		canvas.drawCircle(x, y, 30, paint);
		
		getHolder().unlockCanvasAndPost(canvas);
		
		y += speedY;
		
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {

		timer = new Timer();
		task = new TimerTask() {
			
			@Override
			public void run() {
				drawView();
			}
		};
		timer.schedule(task, 100, 100);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		
		timer.cancel();
		task.cancel();
	}

}
