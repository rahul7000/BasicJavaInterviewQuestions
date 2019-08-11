package com.rahul.javainterview;

class Pattern {
	private boolean one = true;
	private boolean two = false;
	private boolean three = false;

	public void onePattern() {
		synchronized (this) {
			while (!one) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("*");
			one = false;
			two = true;
			three = false;
			notifyAll();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void twoPattern() {
		synchronized (this) {
			while (!two) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("* *");
			one = false;
			two = false;
			three = true;
			notifyAll();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void threePattern() {
		synchronized (this) {
			while (three == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("* * *");
			one = true;
			two = false;
			three = false;
			notifyAll();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class PatternThread {

	public static void main(String args[]) {
		Pattern pattern = new Pattern();
		Thread one = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					pattern.onePattern();
				}
			}

		}, "one");

		Thread two = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					pattern.twoPattern();
				}
			}
		}, "two");

		Thread three = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					pattern.threePattern();
				}
			}
		}, "three");

		one.start();
		two.start();
		three.start();

	}

}
