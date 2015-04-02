package com.example.geotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameSummationActivity extends Activity {

	private int numberOfDisplayedQuestion;
	private int numberOfTrueAnswers;
	private int percentOfTrueAnswers;
	private TextView summation_title;
	private TextView summation_content;
	private TextView summation_content2;
	private EditText edit_text;
	private String playerName;
	private boolean addScoreToBestScores = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_summation_activity);

		Intent intent = getIntent();
		numberOfTrueAnswers = intent.getIntExtra("numberOfTrueAnswers", 0);
		numberOfDisplayedQuestion = intent.getIntExtra(
				"numberOfDisplayedQuestion", 0);

		summation_title = (TextView) findViewById(R.id.summation_title);
		summation_content = (TextView) findViewById(R.id.summation_content);
		summation_content2 = (TextView) findViewById(R.id.summation_content2);
		edit_text = (EditText) findViewById(R.id.edit_text);

		percentOfTrueAnswers = (100 * numberOfTrueAnswers)
				/ (numberOfDisplayedQuestion - 1);

		BestResultsDatabaseHandler dbHandler = new BestResultsDatabaseHandler(
				getApplicationContext());
		BestScore bestScore5 = dbHandler.showScore(4);

		if (numberOfTrueAnswers > bestScore5.getNumberOfTrueAnswers()
				&& percentOfTrueAnswers > 50) {
			summation_title.setText("Œwietny wynik!!");
			summation_content.setText("Wybra³eœ " + percentOfTrueAnswers
					+ "% prawid³owych odpowiedzi odpowiadaj¹c poprawnie na "
					+ numberOfTrueAnswers + " z "
					+ (numberOfDisplayedQuestion - 1) + " pytañ.");
			summation_content2
					.setText("Twój wynik zostanie zapisany na liœcie najlepszych!!");
			addScoreToBestScores = true;

		} else if (percentOfTrueAnswers > 50) {
			summation_title.setText("Gratulacje!");
			summation_content.setText("Wybra³eœ " + percentOfTrueAnswers
					+ "% prawid³owych odpowiedzi odpowiadaj¹c poprawnie na "
					+ numberOfTrueAnswers + " z "
					+ (numberOfDisplayedQuestion - 1) + " pytañ.");
			summation_content2
					.setText("Jesteœ blisko wpisania siê na listê najlepszych wyników.");
			edit_text.setVisibility(View.GONE);
		} else if (numberOfDisplayedQuestion > 30) {
			summation_title.setText("Usuñ aplikacjê!");
			summation_content.setText("Nie umiesz siê bawiæ :(");
			summation_content2.setVisibility(View.GONE);
			edit_text.setVisibility(View.GONE);

		} else {
			summation_title.setText("Niestety!");
			summation_content.setText("Wybra³eœ " + percentOfTrueAnswers
					+ "% prawid³owych odpowiedzi odpowiadaj¹c poprawnie na "
					+ numberOfTrueAnswers + " z "
					+ (numberOfDisplayedQuestion - 1) + " pytañ.");
			summation_content2.setText("Spróbuj swoich si³ jeszcze raz!");
			edit_text.setVisibility(View.GONE);
		}
	}

	public void onClick(View view) {
		view.getId();
		if (addScoreToBestScores == true) {
			playerName = edit_text.getText().toString();
			BestResultsDatabaseHandler dbHandler = new BestResultsDatabaseHandler(
					getApplicationContext());
			BestScore bestScore = new BestScore(playerName,
					numberOfTrueAnswers, percentOfTrueAnswers);
			dbHandler.addBestResult(bestScore);
		}
		Intent intent = new Intent(this, BestResultsActivity.class);
		startActivity(intent);
	}

}
