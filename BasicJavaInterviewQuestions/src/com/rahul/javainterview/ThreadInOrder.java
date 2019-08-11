package com.rahul.javainterview;

class MyOrder1 extends Thread {

	private volatile int threadId;
	private static int idIncreament = 1;
	private static int threadToRun = 1;

	private static Object myLock = new Object();

	public MyOrder1() {
		this.threadId = idIncreament++;
		System.out.println("ThreadId is : " + this.threadId);
	}

	@Override
	public void run() {
		synchronized (myLock) {
			while (threadId != threadToRun) {
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
			System.out.println("Running " + threadId);
			myLock.notifyAll();
			threadToRun++;
		}
	}
}

public class ThreadInOrder {
	public static void main(String args[]) {
		MyOrder1 t1 = new MyOrder1();
		MyOrder1 t2 = new MyOrder1();
		MyOrder1 t3 = new MyOrder1();
		MyOrder1 t4 = new MyOrder1();

		t4.start();
		t3.start();
		t2.start();
		t1.start();

	}

}
