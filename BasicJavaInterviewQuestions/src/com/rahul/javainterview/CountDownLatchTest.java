package com.rahul.javainterview;

import java.util.concurrent.CountDownLatch;

class Application extends Thread {
	private int duration;
	private CountDownLatch latch;

	public Application(String name, int duration, CountDownLatch latch) {
		super(name);
		this.duration = duration;
		this.latch = latch;
	}

	public void run() {
		System.out.println("current developer : " + Thread.currentThread().getName());
		try {
			Thread.sleep(this.duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " up and running");

		latch.countDown();
		System.out.println("Current CountDown : " + latch.getCount());

	}
}

public class CountDownLatchTest {

	public static void main(String args[]) {
		CountDownLatch latch = new CountDownLatch(4);

		Thread dev1 = new Application("Dev1", 1000, latch);
		Thread dev2 = new Application("Dev2", 2000, latch);
		Thread dev3 = new Application("Dev3", 3000, latch);
		Thread dev4 = new Application("Dev4", 4000, latch);

		dev1.start();
		dev2.start();
		dev3.start();
		dev4.start();

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.currentThread().setName("Testing team");

		System.out.println("Current Task : " + Thread.currentThread().getName());

	}
}
