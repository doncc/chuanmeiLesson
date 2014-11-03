package com.chuanmei.l07usingwebview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

	private WebView wb_view;
	private EditText edt_input;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        wb_view = (WebView) findViewById(R.id.wb_view);
        edt_input = (EditText) findViewById(R.id.edt_input);
        
        findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String url = edt_input.getText().toString().trim();
				wb_view.loadUrl(url);
			}
		});
        
    }

}
