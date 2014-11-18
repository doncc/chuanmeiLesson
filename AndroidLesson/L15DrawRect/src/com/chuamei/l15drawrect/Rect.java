package com.chuamei.l15drawrect;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Rect {

	private float x;
	private float y;
	private float width;
	private float height;
	private float speedX;
	private float speedY;

	private int color;
	private final Paint paint = new Paint();
	private GameView view;

	public Rect() {
		x = (float) (Math.random() * 100);
		y = (float) (Math.random() * 100);
		width = (float) (Math.random() * 50 + 5);
		height = (float) (Math.random() * 50 + 5);
		speedX = (float) (Math.random() * 10 + 3);
		speedY = (float) (Math.random() * 10 + 3);
		setColor(Color.rgb((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255)));
		
	}
	
	public void draw(Canvas canvas){
		
		canvas.save();
		canvas.drawRect(x, y, x+width, y+height, paint);
		canvas.restore();
		
		x += speedX;
		y += speedY;
		
		if (x > getView().getWidth() - width) {
			speedX = -Math.abs(speedX);
		}else if (x < 0) {
			speedX = Math.abs(speedX);
		}else if (y > getView().getHeight() - height) {
			speedY = -Math.abs(speedY);
		}else if (y < 0) {
			speedY = Math.abs(speedY);
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		paint.setColor(color);
	}

	public GameView getView() {
		return view;
	}

	public void setView(GameView view) {
		this.view = view;
	}

}
