package com.chuanmei.l05usingjni;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		People peo = new People();
		System.out.println("Ãû×Ö£º" + peo.getName() + " ÄêÁä:" + peo.getAge());
	}

}
