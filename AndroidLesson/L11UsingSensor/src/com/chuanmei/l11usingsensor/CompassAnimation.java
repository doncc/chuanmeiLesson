package com.chuanmei.l11usingsensor;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CompassAnimation extends Animation {

	private float startAngle;
	private float endAngle;
	private int width;
	private int height;

	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		this.width = width;
		this.height = height;

		super.initialize(width, height, parentWidth, parentHeight);
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		float distance = endAngle - startAngle;
		t.getMatrix().setRotate(startAngle + interpolatedTime * distance,
				width / 2, height / 2);
		super.applyTransformation(interpolatedTime, t);
	}

	public float getStartAngle() {
		return startAngle;
	}

	public void setStartAngle(float startAngle) {
		this.startAngle = startAngle;
	}

	public float getEndAngle() {
		return endAngle;
	}

	public void setEndAngle(float endAngle) {
		this.endAngle = endAngle;
	}
}
