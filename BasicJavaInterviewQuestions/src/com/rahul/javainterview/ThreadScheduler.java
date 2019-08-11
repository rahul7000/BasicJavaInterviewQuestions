package com.rahul.javainterview;

import java.util.Timer;
import java.util.TimerTask;

//This is used to get the real time data like RTMT(Real Time Monitoring Logs) logs 
//public void schedule(TimerTask task, Date firstTime, long period)
//Parameters:
//task - task to be scheduled.
//firstTime - First time at which task is to be executed.
//period - time in milliseconds between successive task executions.
//Throws:
//IllegalArgumentException - if firstTime.getTime() < 0,
// or period <= 0
//IllegalStateException - if task was already scheduled 
//or cancelled, timer was cancelled, 
//or timer thread terminated.
//NullPointerException - if task or firstTime is null
class MyScheduler extends TimerTask {

	@Override
	public void run() {

		System.out.println("Hala " + Thread.currentThread().getName());
	}
}

public class ThreadScheduler {

	public static void main(String[] args) {
		TimerTask task = new MyScheduler();

		Timer scheduler = new Timer();

		scheduler.schedule(task, 2000, 3000);
	}
}
