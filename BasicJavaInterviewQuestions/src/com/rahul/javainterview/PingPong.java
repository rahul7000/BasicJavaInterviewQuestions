package com.rahul.javainterview;

class MyClass {

	private volatile String pingpong = "pong";

	public void printPing() {
		synchronized (this) {
			while (pingpong.equals("ping")) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ping with " + Thread.currentThread().getName());
			pingpong = "ping";
			notify();
		}
	}

	public void printPong() {
		synchronized (this) {
			while (pingpong.equals("pong")) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("pong with " + Thread.currentThread().getName());
			pingpong = "pong";
			notify();
		}
	}

}

public class PingPong {
	public static void main(String[] args) {

		MyClass obj = new MyClass();
		Thread ping = new Thread(new Runnable() {
			public void run() {
				while (true) {
					obj.printPing();
				}
			}
		}, "ping");

		Thread pong = new Thread(new Runnable() {
			public void run() {
				while (true) {
					obj.printPong();
				}
			}
		}, "pong");

		ping.start();
		pong.start();
	}

}
