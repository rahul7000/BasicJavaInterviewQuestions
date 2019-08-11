package com.rahul.javainterview;

import java.util.LinkedList;
import java.util.List;

class MyTask extends Thread {

	public void run() {
		System.out.println("Current Thread " + Thread.currentThread().getName());
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

public class WaitForAllThreadsToDie {

	public static void main(String... args) throws InterruptedException {
		List<MyTask> threads = new LinkedList<>();

		for (int index = 0; index <= 10; index++) {
			MyTask thread = new MyTask();
			thread.start();
			threads.add(thread);
		}

		for (MyTask thread : threads) {
			System.out.println("Thread join " + thread.getName());

			thread.join();
			Thread.sleep(200);
		}
		System.out.println("Main method after all the threads have finished their work");
	}
}
