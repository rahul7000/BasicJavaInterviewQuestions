package com.rahul.javainterview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * This is based on producer-consumer problem
 */
public class ThreadPoolAlternate {

	public static void main(String[] args) {

		Mutex mutex = new Mutex();
		ExecutorService threadpool = Executors.newFixedThreadPool(2);

		EvenPrinter evenPrinter = new EvenPrinter(mutex);
		OddPrinter oddPrinter = new OddPrinter(mutex);

		threadpool.execute(evenPrinter);
		threadpool.execute(oddPrinter);

		if (null != threadpool) {
			threadpool.shutdown();
		}

	}
}

class Mutex {
	public static boolean evenodd = true;
}

class EvenPrinter implements Runnable {
	private Mutex mutex = new Mutex();

	EvenPrinter(Mutex mutex) {
		this.mutex = mutex;
	}

	@Override
	public void run() {
		for (int i = 1; i < 100; i += 2) {
			synchronized (mutex) {
				while (mutex.evenodd) {
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!mutex.evenodd) {
					System.out.println("EvenPrinter " + i);
					mutex.evenodd = true;
					mutex.notify();
				}
			}
		}
	}
}

class OddPrinter implements Runnable {
	private Mutex mutex = new Mutex();

	OddPrinter(Mutex mutex) {
		this.mutex = mutex;
	}

	@Override
	public void run() {
		for (int i = 1; i < 100; i += 2) {
			synchronized (mutex) {
				while (!mutex.evenodd) {
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("OddPrint :" + i);
				mutex.evenodd = false;
				mutex.notify();
			}
		}
	}
}
