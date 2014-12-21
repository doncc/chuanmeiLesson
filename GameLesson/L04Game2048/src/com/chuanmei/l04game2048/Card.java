package com.chuanmei.l04game2048;

import android.app.Fragment;
import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

	private TextView tv;
	private int num;

	public Card(Context context) {
		super(context);

		tv = new TextView(context);

		tv.setBackgroundColor(0x33ffffff);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		lp.setMargins(10, 10, 0, 0);
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(33);

		addView(tv, lp);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		if (num == 0) {
			tv.setText("");
		}else{
			tv.setText(num + "");
		}
	}

	public boolean equals(Card o) {
		return o.getNum() == getNum();
	}
}
