package com.chuanmei.l06usingimage;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

	private ImageView iv;
	private boolean isFirstPage = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        ImageView iv = (ImageView) findViewById(R.id.img);
//        iv.setImageResource(R.drawable.img2);
        isFirstPage = true;
        iv = (ImageView) findViewById(R.id.img);
        iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (isFirstPage) {
					iv.setImageResource(R.drawable.img2);
					
				}else{
					iv.setImageResource(R.drawable.img1);
				}
				isFirstPage = !isFirstPage;
				 
				
			}
		});
        
    }


}
