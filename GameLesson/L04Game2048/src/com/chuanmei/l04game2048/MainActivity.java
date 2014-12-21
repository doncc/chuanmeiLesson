package com.chuanmei.l04game2048;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static TextView tv_num;
	private static int source = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		tv_num = (TextView) findViewById(R.id.tv_num);

	}

	public static void addSource(int s) {
		source += s;
		tv_num.setText(source + "");
	}
}
