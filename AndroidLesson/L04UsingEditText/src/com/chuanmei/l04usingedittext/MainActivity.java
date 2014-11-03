package com.chuanmei.l04usingedittext;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	private EditText edt_input;
	private TextView tv_txt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edt_input = (EditText) findViewById(R.id.edt_inputText);
        tv_txt = (TextView) findViewById(R.id.tv_txt);
        
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String str = edt_input.getText().toString().trim();
				tv_txt.setText(str);
			}
		});
    }


}
