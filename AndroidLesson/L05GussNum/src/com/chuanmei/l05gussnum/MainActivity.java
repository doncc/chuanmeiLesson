package com.chuanmei.l05gussnum;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private EditText edt_input;
	private TextView tv_result;
	private int num = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edt_input = (EditText) findViewById(R.id.edt_input);
		tv_result = (TextView) findViewById(R.id.tv_resulse);
		
		num = (int) (Math.random() * 10);
		
		
		findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String str = edt_input.getText().toString().trim();
				int input_num = Integer.parseInt(str);
				if (input_num > num) {
					Toast.makeText(MainActivity.this, "大了", Toast.LENGTH_SHORT).show();
				}else if (input_num < num) {
					Toast.makeText(MainActivity.this, "小了", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this, "唉妈呀你真聪明！猜对了", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

}
