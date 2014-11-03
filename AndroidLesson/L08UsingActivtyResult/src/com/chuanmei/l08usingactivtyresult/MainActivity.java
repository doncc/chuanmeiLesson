package com.chuanmei.l08usingactivtyresult;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivityForResult(intent, 0);
//				startActivity(intent);
			}
		});
    }

    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
    	
    	Toast.makeText(this, arg2.getStringExtra("result"), Toast.LENGTH_SHORT).show();
    	
    	super.onActivityResult(arg0, arg1, arg2);
    }
}
