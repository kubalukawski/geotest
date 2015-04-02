package com.example.geotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameInformationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_information_activity);
	}

	public void onButtonPlayClick(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
