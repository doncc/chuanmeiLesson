package com.chuanmei.l08usingactivtyresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SecondActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_main_layout);

		findViewById(R.id.btn_1).setOnClickListener(this);
		findViewById(R.id.btn_2).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		Intent intent = new Intent();
		
		switch (v.getId()) {
		case R.id.btn_1:
			intent.putExtra("result", "吃了");
			setResult(0, intent);
			break;
		case R.id.btn_2:

			intent.putExtra("result", "没吃");
			setResult(1, intent);
			
			break;

		default:
			break;
		}
		
		this.finish();
	}

}
