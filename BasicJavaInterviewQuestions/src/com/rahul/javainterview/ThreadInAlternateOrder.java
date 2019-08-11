package com.rahul.javainterview;

class MyOrder implements Runnable {
	private int threadId;
	private static int threadToRun = 1;
	private static int countDown = 1;

	private static Object myLock = new Object();

	public MyOrder() {
		this.threadId = threadToRun++;
		System.out.println("Current Thread : " + this.threadId);
	}

	@Override
	public void run() {
		synchronized (myLock) {

			while (countDown % threadToRun != this.threadId) {

				try {
					myLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Running Thread : " + threadId + " countDown : " + countDown++);
			myLock.notifyAll();
		}

	}

}

public class ThreadInAlternateOrder {
	public static void main(String[] args) {
		for (int index = 0; index < 10; index++) {
			Thread t = new Thread(new MyOrder());
			t.start();
		}
	}
}
