package com.chuanmei.l10usinganimation;

import com.chuanmei.l10usinganimation.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener {

	private ImageView iv;
	private AlphaAnimation aaHide = new AlphaAnimation(1, 0);
	private AlphaAnimation aaShow = new AlphaAnimation(0, 1);
	private boolean isFirst = false;
	
	private RotateAnimation ra = new RotateAnimation(0, -360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
	private ScaleAnimation sa = new ScaleAnimation(1, 0f, 1, 0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
	private TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.5f);
	
	private AnimationSet as;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		iv = (ImageView) findViewById(R.id.img);
		iv.setOnClickListener(this);
		
		aaHide.setDuration(1000);
		aaHide.setFillAfter(true);
		aaShow.setDuration(1000);
		aaShow.setFillAfter(true);
		
		ra.setDuration(1000);
		ra.setFillAfter(true);
		
		sa.setDuration(1000);
		sa.setFillAfter(true);
		
		ta.setDuration(1000);
		ta.setFillAfter(true);
		
		as = new AnimationSet(true);
		as.addAnimation(aaHide);
		as.addAnimation(ra);
		as.setDuration(1000);
		as.setFillAfter(true);
		
		isFirst = true;
	}

	@Override
	public void onClick(View v) {

//		if (isFirst) {
//			iv.startAnimation(aaHide);
//		}else{
//			iv.startAnimation(aaShow);
//		}
//		
//		isFirst = !isFirst;
		
//		iv.startAnimation(ra);
		
//		iv.startAnimation(sa);
		
		iv.startAnimation(as);
		
	}
}
