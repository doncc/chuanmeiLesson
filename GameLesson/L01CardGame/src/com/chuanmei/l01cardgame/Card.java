package com.chuanmei.l01cardgame;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Card extends RelativeLayout {

	private TextView tv;
	private int num;

	public Card(Context context, int num) {
		super(context);

		tv = new TextView(context);
		tv.setText(num + "");
		setNum(num);
		tv.setTextColor(Color.WHITE);
		tv.setTextSize(30);
		addView(tv);
		setGravity(Gravity.CENTER);
		showA();
	}

	public void showA() {
		setBackgroundColor(Color.RED);
		tv.setVisibility(View.VISIBLE);
	}

	public void showB() {
		setBackgroundColor(Color.BLUE);
		tv.setVisibility(View.GONE);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
