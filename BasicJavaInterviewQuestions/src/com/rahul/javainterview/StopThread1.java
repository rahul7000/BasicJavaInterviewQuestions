package com.rahul.javainterview;

class MyThread1 extends Thread {
	private boolean stop = false;

	public void run() {
		while (!stop) {
			System.out.println("Thread is Running");
		}
		System.out.println("LOL Thread is stopped");
	}

	public void stopThread() {
		stop = true;
	}
}

public class StopThread1 {

	public static void main(String args[]) {
		MyThread1 t1 = new MyThread1();
		t1.start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.stopThread();

	}
}
