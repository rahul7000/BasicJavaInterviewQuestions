package com.rahul.javainterview;

class MyThread extends Thread {

	public MyThread(String string) {
		super(string);
	}

	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("Thread is Running");
		}
		System.out.println("Thread is stopped");

	}
}

public class StopThread {

	public static void main(String args[]) {
		Thread t1 = new MyThread("MyThread");

		t1.start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t1.interrupt();

	}
}
