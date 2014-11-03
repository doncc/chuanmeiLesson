package com.chuanmei.l03usingdialog;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				showDialog();
			}
		});
    }

    private void showDialog(){
    	AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
		al.setTitle("这是标题");
		al.setMessage("我漂亮吗");
		al.setPositiveButton("是", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				MainActivity.this.finish();
			}
		});
		al.show();
    }


}
