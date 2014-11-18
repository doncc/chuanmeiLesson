package com.chuanmei.l11usingsensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager sensorManager;
	private Sensor sensor;
	
	private CompassAnimation ca;
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

		// List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
		// for (Sensor sensor : list) {
		// System.out.println(sensor.getName() + ":" + sensor.getType());
		// }

		iv = (ImageView) findViewById(R.id.img);
		ca = new CompassAnimation();
		ca.setDuration(300);
		iv.startAnimation(ca);
		
	}

	@Override
	protected void onResume() {
		sensorManager.registerListener(this, sensor,
				SensorManager.SENSOR_DELAY_GAME);
		super.onResume();
	}

	@Override
	protected void onPause() {
		sensorManager.unregisterListener(this);
		super.onPause();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

		System.out.println("onAccuracyChanged");
	}

	private float endAngle = 0;
	
	@Override
	public void onSensorChanged(SensorEvent event) {

		float currAngle = -event.values[0];
		
		ca.cancel();
		iv.setAnimation(null);
		
		ca.setStartAngle(endAngle);
		ca.setEndAngle(currAngle);
		
		iv.startAnimation(ca);
		
		endAngle = currAngle;
		
	}
}
