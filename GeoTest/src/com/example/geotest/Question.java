package com.example.geotest;

public class Question {

	int id;
	int numberOfRepeats;
	String questionContent;
	String answerAtrue;
	String answerBfalse;
	String answerCfalse;
	String answerDfalse;
	String answerEfalse;

	public Question() {
	}

	public Question(String questionContent, String answerAtrue,
			String answerBfalse, String answerCfalse, String answerDfalse,
			String answerEfalse) {
		numberOfRepeats = 0;
		this.questionContent = questionContent;
		this.answerAtrue = answerAtrue;
		this.answerBfalse = answerBfalse;
		this.answerCfalse = answerCfalse;
		this.answerDfalse = answerDfalse;
		this.answerEfalse = answerEfalse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfRepeats() {
		return numberOfRepeats;
	}

	public void setNumberOfRepeats(int numberOfRepeats) {
		this.numberOfRepeats = numberOfRepeats;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getAnswerAtrue() {
		return answerAtrue;
	}

	public void setAnswerAtrue(String answerAtrue) {
		this.answerAtrue = answerAtrue;
	}

	public String getAnswerBfalse() {
		return answerBfalse;
	}

	public void setAnswerBfalse(String answerBfalse) {
		this.answerBfalse = answerBfalse;
	}

	public String getAnswerCfalse() {
		return answerCfalse;
	}

	public void setAnswerCfalse(String answerCfalse) {
		this.answerCfalse = answerCfalse;
	}

	public String getAnswerDfalse() {
		return answerDfalse;
	}

	public void setAnswerDfalse(String answerDfalse) {
		this.answerDfalse = answerDfalse;
	}

	public String getAnswerEfalse() {
		return answerEfalse;
	}

	public void setAnswerEfalse(String answerEfalse) {
		this.answerEfalse = answerEfalse;
	}

}
