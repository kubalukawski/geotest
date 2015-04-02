package com.example.geotest;

public class BestScore {

	private int id;
	private String playerName;
	private int numberOfTrueAnswers; //  jgjkh
	private int percentOfTrueAnswers;

	public BestScore() {
	}

	public BestScore(String playerName, int numberOfTrueAnswers,
			int percentOfTrueAnswers) {
		this.playerName = playerName;
		this.numberOfTrueAnswers = numberOfTrueAnswers;
		this.percentOfTrueAnswers = percentOfTrueAnswers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getNumberOfTrueAnswers() {
		return numberOfTrueAnswers;
	}

	public void setNumberOfTrueAnswers(int numberOfTrueAnswers) {
		this.numberOfTrueAnswers = numberOfTrueAnswers;
	}

	public int getPercentOfTrueAnswers() {
		return percentOfTrueAnswers;
	}

	public void setPercentOfTrueAnswers(int percentOfTrueAnswers) {
		this.percentOfTrueAnswers = percentOfTrueAnswers;
	}

}