package com.rahul.javainterview;

public class ThreadExecutionTime {
	public static void main(String args[]) {

		Thread t1 = new Thread() {
			public void run() {
				long startTime = System.currentTimeMillis();
				System.out.println("Thread is running");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long totalTime = System.currentTimeMillis() - startTime;
				System.out.println(totalTime);
			}

		};
		t1.start();
	}
}
