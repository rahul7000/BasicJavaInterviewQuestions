package com.rahul.javainterview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Singletone {
	private int connection = 0;
	private Semaphore sem = new Semaphore(10, true);
	private static Singletone single;

	private Singletone() {
	}

	public static Singletone getInstance() {
		if (single == null) {
			single = new Singletone();
		}
		return single;
	}

	public void doConnect() {
		try {
			sem.acquire();
			connect();
		} catch (InterruptedException e) {
			e.printStackTrace();

		} finally {
			sem.release();
		}
	}

	private void connect() {
		synchronized (this) {
			connection++;
			System.out.println("Current Connection : " + connection);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connection--;
			// System.out.println("Removing Connection"+connection);
		}
	}

}

public class SemaphoreTest {
	public static void main(String args[]) {
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Singletone.getInstance().doConnect();

				}

			});
		}

	}
}
