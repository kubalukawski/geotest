package com.example.geotest;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	public DatabaseHandler(Context context) {
		super(context, "questions_database.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table questions("
				+ "id integer primary key autoincrement,"
				+ "numberOfRepeats integer," + "questionContent text, "
				+ "answerAtrue text," + "answerBfalse text,"
				+ "answerCfalse text," + "answerDfalse text,"
				+ "answerEfalse text);" + "");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	protected void addQuestion(Question question) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("numberOfRepeats", question.getNumberOfRepeats());
		values.put("questionContent", question.getQuestionContent());
		values.put("answerAtrue", question.getAnswerAtrue());
		values.put("answerBfalse", question.getAnswerBfalse());
		values.put("answerCfalse", question.getAnswerCfalse());
		values.put("answerDfalse", question.getAnswerDfalse());
		values.put("answerEfalse", question.getAnswerEfalse());
		db.insertOrThrow("questions", null, values);
	}

	protected void deleteQuestion(int id) {
		SQLiteDatabase db = getWritableDatabase();
		String[] arguments = { "" + id };
		db.delete("questions", "id=?", arguments);
	}

	public Question showQuestion(int id) {
		Question question = new Question();
		SQLiteDatabase db = getReadableDatabase();
		String[] columns = { "id", "numberOfRepeats", "questionContent",
				"answerAtrue", "answerBfalse", "answerCfalse", "answerDfalse",
				"answerEfalse" };
		Cursor cursor = db.query("questions", columns, null, null, null, null,
				null);
		cursor.moveToPosition(id);
		question.setId(cursor.getInt(0));
		question.setNumberOfRepeats(cursor.getInt(1));
		question.setQuestionContent(cursor.getString(2));
		question.setAnswerAtrue(cursor.getString(3));
		question.setAnswerBfalse(cursor.getString(4));
		question.setAnswerCfalse(cursor.getString(5));
		question.setAnswerDfalse(cursor.getString(6));
		question.setAnswerEfalse(cursor.getString(7));

		return question;
	}

	protected List<Question> showAllQuestions() {
		List<Question> questions = new LinkedList<Question>();
		String[] columns = { "id", "numberOfRepeats", "questionContent",
				"answerAtrue", "answerBfalse", "answerCfalse", "answerDfalse",
				"answerEfalse" };
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("questions", columns, null, null, null, null,
				null);
		while (cursor.moveToNext()) {
			Question question = new Question();
			question.setId(cursor.getInt(cursor.getColumnIndex("id")));
			question.setNumberOfRepeats(cursor.getInt(1));
			question.setQuestionContent(cursor.getString(2));
			question.setAnswerAtrue(cursor.getString(3));
			question.setAnswerBfalse(cursor.getString(4));
			question.setAnswerCfalse(cursor.getString(5));
			question.setAnswerDfalse(cursor.getString(6));
			question.setAnswerEfalse(cursor.getString(7));
			questions.add(question);
		}

		return questions;
	}

	public void addQuestionsToDatabase() {
		Question question1 = new Question("W klimacie humidowym:",
				"poziom iluwialny wyst�puje pod poziomem eluwialnym",
				"poziom eluwialny wyst�puje pod poziomem glejowym",
				"poziom iluwialny wyst�puje nad poziomem eluwialnym",
				"poziom iluwialny wyst�puje pod poziomem glejowym",
				"poziom glejowy wyst�puje pod poziomem organicznym");
		addQuestion(question1);
		Question question2 = new Question(
				"Silne wietrzenie chemiczne dominuje w procesie glebotw�rczym:",
				"w klimacie wilgotnym i ciep�ym",
				"w klimacie suchym i ciep�ym", "w klimacie suchym i ch�odnym",
				"w klimacie wilgotnym umiarkowanym",
				"w klimacie wilgotnym i ch�odnym");
		addQuestion(question2);
		Question question3 = new Question(
				"Siarka w glebie nie podlega nast�puj�cej przemianie:",
				"amonifikacji", "mineralizacji zwi�zk�w organicznych",
				"asymilacji przez organizmy �ywe", "str�caniu", "wymywaniu");
		addQuestion(question3);
		Question question4 = new Question(
				"Gleby zwi�zane ze szeroko�ci� geograficzn� to:",
				"gleby brunatne", "gleby astrefowe", "mady", "r�dziny",
				"vertisole");
		addQuestion(question4);
		Question question5 = new Question(
				"Do gleb litogenicznych zaliczane s�:", "regosole", "bielice",
				"czarne ziemie", "so�o�ce", "rigosole");
		addQuestion(question5);
		Question question6 = new Question("Gleby dominuj�ce w Polsce to:",
				"gleby brunatne", "czarnoziemy", "gleby bielicowe", "mady",
				"r�dziny");
		addQuestion(question6);
		Question question7 = new Question(
				"Organizmy �ywe przebywaj�ce w glebie tylko w pewnym okresie rozwojowym swojego �ycia, lub kt�rych tryb �ycia polega na penetracji obu �rodowisk - glebowego i powierzchniowego to:",
				"geofile", "geofony", "geody", "geobionty", "geokseny");
		addQuestion(question7);
		Question question8 = new Question(
				"G��wnymi �r�d�ami siarki w glebie s� m.in. takie minera�y jak:",
				"markasyt i anhydryt", "apatyt i hornblenda",
				"biotyt i ortoklaz", "dolomit i hydroksyapatyt",
				"mika i oliwin");
		addQuestion(question8);
	}
}
