package com.example.geotest;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BestResultsActivity extends Activity {

	private TextView player_name_1;
	private TextView number_of_true_answers_1;
	private TextView percent_of_true_answers_1;
	private TextView player_name_2;
	private TextView number_of_true_answers_2;
	private TextView percent_of_true_answers_2;
	private TextView player_name_3;
	private TextView number_of_true_answers_3;
	private TextView percent_of_true_answers_3;
	private TextView player_name_4;
	private TextView number_of_true_answers_4;
	private TextView percent_of_true_answers_4;
	private TextView player_name_5;
	private TextView number_of_true_answers_5;
	private TextView percent_of_true_answers_5;
	private ImageButton menuImageButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.best_results_activity);

		player_name_1 = (TextView) findViewById(R.id.player_name_1);
		number_of_true_answers_1 = (TextView) findViewById(R.id.number_of_true_answers_1);
		percent_of_true_answers_1 = (TextView) findViewById(R.id.percent_of_true_answers_1);
		player_name_2 = (TextView) findViewById(R.id.player_name_2);
		number_of_true_answers_2 = (TextView) findViewById(R.id.number_of_true_answers_2);
		percent_of_true_answers_2 = (TextView) findViewById(R.id.percent_of_true_answers_2);
		player_name_3 = (TextView) findViewById(R.id.player_name_3);
		number_of_true_answers_3 = (TextView) findViewById(R.id.number_of_true_answers_3);
		percent_of_true_answers_3 = (TextView) findViewById(R.id.percent_of_true_answers_3);
		player_name_4 = (TextView) findViewById(R.id.player_name_4);
		number_of_true_answers_4 = (TextView) findViewById(R.id.number_of_true_answers_4);
		percent_of_true_answers_4 = (TextView) findViewById(R.id.percent_of_true_answers_4);
		player_name_5 = (TextView) findViewById(R.id.player_name_5);
		number_of_true_answers_5 = (TextView) findViewById(R.id.number_of_true_answers_5);
		percent_of_true_answers_5 = (TextView) findViewById(R.id.percent_of_true_answers_5);

		BestResultsDatabaseHandler dbHandler0 = new BestResultsDatabaseHandler(
				getApplicationContext());
		List<BestScore> showBestScores = dbHandler0.show5BestScores();
		if (showBestScores.size() < 2) {
			dbHandler0.addFirstZeroScoresToDatabase();
		}

		BestResultsDatabaseHandler dbHandler = new BestResultsDatabaseHandler(
				getApplicationContext());

		BestScore bestScore = dbHandler.showScore(0);
		player_name_1.setText(bestScore.getPlayerName());
		number_of_true_answers_1.setText(bestScore.getNumberOfTrueAnswers()
				+ "-krotnie zna³ odpowiedŸ!");
		percent_of_true_answers_1.setText("skutecznoœæ: "
				+ bestScore.getPercentOfTrueAnswers() + "%");

		BestScore bestScore2 = dbHandler.showScore(1);
		player_name_2.setText(bestScore2.getPlayerName());
		number_of_true_answers_2.setText(bestScore2.getNumberOfTrueAnswers()
				+ "-krotnie zna³ odpowiedŸ!");
		percent_of_true_answers_2.setText("skutecznoœæ: "
				+ bestScore2.getPercentOfTrueAnswers() + "%");

		BestScore bestScore3 = dbHandler.showScore(2);
		player_name_3.setText(bestScore3.getPlayerName());
		number_of_true_answers_3.setText(bestScore3.getNumberOfTrueAnswers()
				+ "-krotnie zna³ odpowiedŸ!");
		percent_of_true_answers_3.setText("skutecznoœæ: "
				+ bestScore3.getPercentOfTrueAnswers() + "%");

		BestScore bestScore4 = dbHandler.showScore(3);
		player_name_4.setText(bestScore4.getPlayerName());
		number_of_true_answers_4.setText(bestScore4.getNumberOfTrueAnswers()
				+ "-krotnie zna³ odpowiedŸ!");
		percent_of_true_answers_4.setText("skutecznoœæ: "
				+ bestScore4.getPercentOfTrueAnswers() + "%");

		BestScore bestScore5 = dbHandler.showScore(4);
		player_name_5.setText(bestScore5.getPlayerName());
		number_of_true_answers_5.setText(bestScore5.getNumberOfTrueAnswers()
				+ "-krotnie zna³ odpowiedŸ!");
		percent_of_true_answers_5.setText("skutecznoœæ: "
				+ bestScore5.getPercentOfTrueAnswers() + "%");

		menuImageButton = (ImageButton) findViewById(R.id.menuImageButton);
	}

	public void onClick(View view) {
		Intent intent = new Intent(this, MainMenuActivity.class);
		startActivity(intent);
	}
}