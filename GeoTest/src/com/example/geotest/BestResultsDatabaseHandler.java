package com.example.geotest;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BestResultsDatabaseHandler extends SQLiteOpenHelper {

	public BestResultsDatabaseHandler(Context context) {
		super(context, "best_results_database.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table best_results("
				+ "id integer primary key autoincrement," + "player_name text,"
				+ "number_of_true_answers integer,"
				+ "percent_of_true_answers integer);" + "");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void addBestResult(BestScore bestScore) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("player_name", bestScore.getPlayerName());
		values.put("number_of_true_answers", bestScore.getNumberOfTrueAnswers());
		values.put("percent_of_true_answers",
				bestScore.getPercentOfTrueAnswers());
		db.insertOrThrow("best_results", null, values);
	}

	public BestScore showScore(int id) {
		BestScore bestScore = new BestScore();
		SQLiteDatabase db = getReadableDatabase();
		String[] columns = { "id", "player_name", "number_of_true_answers",
				"percent_of_true_answers" };
		Cursor cursor = db.query("best_results", columns, null, null, null,
				null, "number_of_true_answers desc");
		cursor.moveToPosition(id);
		bestScore.setId(cursor.getInt(0));
		bestScore.setPlayerName(cursor.getString(1));
		bestScore.setNumberOfTrueAnswers(cursor.getInt(2));
		bestScore.setPercentOfTrueAnswers(cursor.getInt(3));
		return bestScore;
	}

	public List<BestScore> show5BestScores() {
		List<BestScore> best5scores = new ArrayList<BestScore>();
		String[] columns = { "id", "player_name", "number_of_true_answers",
				"percent_of_true_answers" };
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("best_results", columns, null, null, null,
				null, null);
		while (cursor.moveToNext() && best5scores.size() < 5) {
			BestScore bestScore = new BestScore();
			bestScore.setId(cursor.getInt(0));
			bestScore.setPlayerName(cursor.getString(1));
			bestScore.setNumberOfTrueAnswers(cursor.getInt(2));
			bestScore.setPercentOfTrueAnswers(cursor.getInt(3));
			best5scores.add(bestScore);
		}
		return best5scores;
	}

	public void addFirstZeroScoresToDatabase() {
		BestScore bestScore10 = new BestScore("no. 1", 0, 0);
		addBestResult(bestScore10);
		BestScore bestScore11 = new BestScore("no. 2", 0, 0);
		addBestResult(bestScore11);
		BestScore bestScore21 = new BestScore("no. 3", 0, 0);
		addBestResult(bestScore21);
		BestScore bestScore22 = new BestScore("no. 4", 0, 0);
		addBestResult(bestScore22);
		BestScore bestScore23 = new BestScore("no. 5", 0, 0);
		addBestResult(bestScore23);
	}
}
