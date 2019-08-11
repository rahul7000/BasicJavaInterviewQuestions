package com.rahul.javainterview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Passenger extends Thread {

	private int duration;
	private CyclicBarrier barrier;

	public Passenger(String name, int duration, CyclicBarrier barrier) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;

	}

	@Override
	public void run() {

		try {
			Thread.sleep(this.duration);
			System.out.println(Thread.currentThread().getName() + " has arrived");
			int await = barrier.await();
			if (await == 0) {
				System.out.println("Four Passengers are here, let's start the ride");
			}
		} catch (InterruptedException | BrokenBarrierException e1) {
			e1.printStackTrace();
		}
	}

}

public class CyclicBarrierTest {
	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(4);

		Passenger p1 = new Passenger("Rahul", 1000, barrier);
		Passenger p2 = new Passenger("Rohit", 2000, barrier);
		Passenger p3 = new Passenger("Mohit", 3000, barrier);
		Passenger p4 = new Passenger("Lalit", 4000, barrier);

		Passenger p5 = new Passenger("Amit", 5000, barrier);
		Passenger p6 = new Passenger("Sumit", 6000, barrier);
		Passenger p7 = new Passenger("Rakshit", 7000, barrier);
		Passenger p8 = new Passenger("Shobhit", 8000, barrier);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();

		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.currentThread().setName("Done Cabbing");
		System.out.println("current task : " + Thread.currentThread().getName());

	}
}
