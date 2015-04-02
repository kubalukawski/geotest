package com.example.geotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity implements OnClickListener {

	private ImageButton newGameButton;
	private ImageButton bestResultsButton;
	private ImageButton exitButton;
	private int numberOfGames = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_activity);
		
		newGameButton = (ImageButton) findViewById(R.id.newGameButton);
		bestResultsButton = (ImageButton) findViewById(R.id.bestResultsButton);
		exitButton = (ImageButton) findViewById(R.id.exitButton);
	}

	@Override
	public void onClick(View v) {
		v.getId();
		if (v == newGameButton) {
			if (numberOfGames == 0) {
				Intent intent = new Intent(this, GameInformationActivity.class);
				startActivity(intent);
				numberOfGames++;
			} else {
				Intent intent = new Intent(this, MainActivity.class);
				startActivity(intent);	
			}	
		} else if (v == bestResultsButton) {
			Intent intent = new Intent(this, BestResultsActivity.class);
			startActivity(intent);
		} else if (v == exitButton) {
			android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
		}
		
	}
}
