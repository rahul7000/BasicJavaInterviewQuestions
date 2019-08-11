package com.rahul.javainterview;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {

	Queue<Integer> queue;
	int size;

	public ProducerConsumer(int size) {
		this.size = size;
		queue = new LinkedList<>();
	}

	public void produces(int value) throws InterruptedException {
		synchronized (this) {
			if (queue.size() >= size) {
				wait();
			}
			System.out.println("Size of queue is : " + queue.size() + " value is : " + value + " with thread "
					+ Thread.currentThread().getName());
			queue.add(value);

			notify();
			Thread.sleep(1000);
		}

	}

	public void consumes() throws InterruptedException {
		synchronized (this) {
			if (queue.size() == 0) {
				wait();
			}

			System.out.println("Size of queue is : " + queue.size() + " value is : " + queue.remove() + " with thread "
					+ Thread.currentThread().getName());
			notify();
			Thread.sleep(1000);
		}

	}
}

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer(4);
		Thread produces = new Thread(new Runnable() {
			int value = 0;

			public void run() {
				while (true) {
					try {
						pc.produces(value);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					value++;
				}

			}

		}, "produces");

		Thread consumes = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						pc.consumes();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "consumes");

		produces.start();
		consumes.start();
	}
}