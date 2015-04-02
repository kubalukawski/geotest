package com.example.geotest;

import android.os.CountDownTimer;

public class CountDown5MinsTimer extends CountDownTimer {
	
	private static long millisUntilFinished = 1;
	
	public CountDown5MinsTimer(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		MainActivity.countDown5MinsTimerTextView.setText("Do koñca " + millisUntilFinished/1000 + "s");
	}

	@Override
	public void onFinish() {
		millisUntilFinished = 0;
		MainActivity.countDown5MinsTimerTextView.setText("Ostatnia szansa :)");
	}
	
	public static long getMillisUntilFinished() {
		return millisUntilFinished;
	}

	public static void setMillisUntilFinished(long millisUntilFinished) {
		CountDown5MinsTimer.millisUntilFinished = millisUntilFinished;
	}
}
