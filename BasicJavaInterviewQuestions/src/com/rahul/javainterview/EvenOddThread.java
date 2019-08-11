package com.rahul.javainterview;

class EvenOdd {

	private int count = 1;
	private int max = 20;

	public void printEven() {
		synchronized (this) {
			while (count < max) {
				while (count % 2 != 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Current Thread : " + Thread.currentThread().getName());
				System.out.println("Even : " + count);
				count++;
				notify();
			}
		}
	}

	public void printOdd() {
		synchronized (this) {
			while (count < max) {
				while (count % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Current Thread : " + Thread.currentThread().getName());
				System.out.println("Odd : " + count);
				count++;
				notify();
			}

		}
	}

}

public class EvenOddThread {
	public static void main(String args[]) {
		EvenOdd eo = new EvenOdd();

		Thread even = new Thread(new Runnable() {
			public void run() {

				eo.printEven();

			}
		}, "Even");

		Thread odd = new Thread(new Runnable() {
			public void run() {

				eo.printOdd();

			}
		}, "odd");

		even.start();
		odd.start();
	}
}
