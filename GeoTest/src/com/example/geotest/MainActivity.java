package com.example.geotest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private TextView questionContentTextView;
	private static Button answerAButton;
	private static Button answerBButton;
	private static Button answerCButton;
	private static Button answerDButton;
	private static Button answerEButton;
	private List<Integer> buttonsId = new ArrayList<Integer>();
	public static TextView countDown5MinsTimerTextView;
	private int numberOfQuestion;
	private int numberOfDisplayedQuestion = 1;
	private int numberOfTrueAnswers = 0;
	private int millisUntilFinished = 30000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = getIntent();
		if (intent != null && intent.hasExtra("numberOfDisplayedQuestion")) {
			numberOfTrueAnswers = intent.getIntExtra("numberOfTrueAnswers", 0);
			numberOfDisplayedQuestion = intent.getIntExtra(
					"numberOfDisplayedQuestion", 1);
		}

		questionContentTextView = (TextView) findViewById(R.id.questionTextView);

		buttonsId.add(R.id.answerAButton);
		buttonsId.add(R.id.answerBButton);
		buttonsId.add(R.id.answerCButton);
		buttonsId.add(R.id.answerDButton);
		buttonsId.add(R.id.answerEButton);
		Collections.shuffle(buttonsId);

		answerAButton = (Button) findViewById(buttonsId.get(0));
		answerBButton = (Button) findViewById(buttonsId.get(1));
		answerCButton = (Button) findViewById(buttonsId.get(2));
		answerDButton = (Button) findViewById(buttonsId.get(3));
		answerEButton = (Button) findViewById(buttonsId.get(4));

		DatabaseHandler dbHandler = new DatabaseHandler(this);
		List<Question> showAllQuestions = dbHandler.showAllQuestions();
		if (showAllQuestions.size() < 2) {
			dbHandler.addQuestionsToDatabase();
		}

		Random random = new Random();
		numberOfQuestion = random.nextInt(7);

		DatabaseHandler dbHandler2 = new DatabaseHandler(this);
		Question showQuestion = dbHandler2.showQuestion(numberOfQuestion);
		questionContentTextView.setText(numberOfDisplayedQuestion + ". "
				+ showQuestion.getQuestionContent().toString());
		answerAButton.setText(showQuestion.getAnswerAtrue().toString());
		answerBButton.setText(showQuestion.getAnswerBfalse().toString());
		answerCButton.setText(showQuestion.getAnswerCfalse().toString());
		answerDButton.setText(showQuestion.getAnswerDfalse().toString());
		answerEButton.setText(showQuestion.getAnswerEfalse().toString());

		for (Question c : dbHandler.showAllQuestions()) {
			Log.d("dane z bazy:", c.getId() + " " + c.getQuestionContent()
					+ " " + c.getAnswerAtrue());
		}

		countDown5MinsTimerTextView = (TextView) findViewById(R.id.countDown5MinsTimerTextView);
		if (numberOfDisplayedQuestion == 1) {
			CountDown5MinsTimer countDown5MinsTimer = new CountDown5MinsTimer(
					millisUntilFinished, 100);
			countDown5MinsTimer.start();
		}
		if (CountDown5MinsTimer.getMillisUntilFinished() == 0) {
			Intent intent2 = new Intent(this, GameSummationActivity.class);
			intent2.putExtra("numberOfTrueAnswers", numberOfTrueAnswers);
			intent2.putExtra("numberOfDisplayedQuestion",
					numberOfDisplayedQuestion);
			startActivity(intent2);
			CountDown5MinsTimer.setMillisUntilFinished(1);
		}
	}

	public void onNextQuestionButtonClick() {
		numberOfDisplayedQuestion++;

		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("numberOfTrueAnswers", numberOfTrueAnswers);
		intent.putExtra("numberOfDisplayedQuestion", numberOfDisplayedQuestion);
		startActivity(intent);
	}

	public void onClickTrueAnswerButton(View view) {
		view.setBackgroundColor(getResources().getColor(
				R.color.greenTrueAnswerColor));
		numberOfTrueAnswers++;
		Toast.makeText(
				getApplicationContext(),
				"GRATULACJE! \n" + numberOfTrueAnswers + " poprawna odpowiedŸ!",
				Toast.LENGTH_SHORT).show();
		onNextQuestionButtonClick();
	}

	public void onClickFalseAnswerButton(View view) {
		view.getId();
		view.setBackgroundColor(getResources().getColor(
				R.color.redFalseAnswerColor));
		onNextQuestionButtonClick();
	}

	@Override
	public void onClick(View view) {
		view.getId();
		if (view == answerAButton) {
			onClickTrueAnswerButton(view);
		} else if (view != answerAButton) {
			onClickFalseAnswerButton(view);
		}
	}
}