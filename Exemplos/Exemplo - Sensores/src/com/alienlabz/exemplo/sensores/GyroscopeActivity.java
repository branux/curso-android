package com.alienlabz.exemplo.sensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class GyroscopeActivity extends Activity {
	private SensorManager sensorManager;
	private SensorEventListener listener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			Toast.makeText(GyroscopeActivity.this,
					"Sensor: " + event.values[0] + ", " + event.values[1] + ", " + event.values[2], Toast.LENGTH_SHORT)
					.show();
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proximity_sensor);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		sensorManager.registerListener(listener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(listener);
	}

}
