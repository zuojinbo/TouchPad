package com.example.touchpad;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private LinearLayout llSketchPad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		llSketchPad = (LinearLayout) findViewById(R.id.ll_sketchpad);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		TouchView touchView = new TouchView(this, metrics.widthPixels, metrics.heightPixels);
		llSketchPad.addView(touchView);
	}
}
