package com.chuanmei.l02catchcat;

import android.content.Context;
import android.view.View;

public class Rect extends View {

	private int color;
	private int pointX;
	private int pointY;

	public Rect(Context context, int color, int pointX, int pointY) {
		super(context);

		setColor(color);
		setPointX(pointX);
		setPointY(pointY);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		setBackgroundColor(color);
	}

	public int getPointX() {
		return pointX;
	}

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

}
