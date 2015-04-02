package com.example.geotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartupScreen extends Activity {

	private long ms = 0;
	private long timeToStart = 2500;
	private boolean active = true;
	private boolean pause = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startup_screen);

		Thread thread = new Thread() {
			public void run() {
				try {
					while (active && ms < timeToStart) {
						if (!pause)
							ms = ms + 100;
						sleep(100);
					}
				} catch (Exception e) {
				} finally {
					Intent intent = new Intent(StartupScreen.this,
							MainMenuActivity.class);
					startActivity(intent);
				}
			}

		};
		thread.start();
	}
}
