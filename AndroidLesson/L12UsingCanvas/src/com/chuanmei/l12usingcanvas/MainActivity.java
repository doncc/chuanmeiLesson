package com.chuanmei.l12usingcanvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(new MyView(this));
	}
	
	private class MyView extends View{

		public MyView(Context context) {
			super(context);
			
		}
		
		private final Paint paint = new Paint();
		private final Paint circlePaint = new Paint();
		@Override
		protected void onDraw(Canvas canvas) {
			
			paint.setColor(0xffff0000);//Color.RED
			circlePaint.setColor(Color.BLUE);
			canvas.save();
			canvas.drawRect(100, 100, 200, 200, paint);
			canvas.drawLine(0, 0, 100, 100, paint);
			
			canvas.drawCircle(250, 150, 50, circlePaint);
			canvas.restore();
			
			super.onDraw(canvas);
		}
		
		
	}
}
