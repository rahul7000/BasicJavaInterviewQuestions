package com.rahul.javainterview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureFactorial {

	private static ExecutorService threadpool = Executors.newFixedThreadPool(10);

	public static void main(String... strings) throws InterruptedException, ExecutionException {
		FactorialClass task = new FactorialClass(4);

		System.out.println("Submitting Task ... ");
		Future futureObj = threadpool.submit(task);
		System.out.println("Task is submitted");

		// tells us if the executor has finished processing the task.
		// If the task is completed, it will return true otherwise, it returns false
		if (!futureObj.isDone()) {
			System.out.println("Task is not completed yet....");
			Thread.sleep(1000); // sleep for 1 millisecond before checking again
		}

		System.out.println("Task is completed, let's check result");
		long factorial = (long) futureObj.get(); // The method that returns the actual result from the calculation
		System.out.println("Factorial of 4 is : " + factorial);
		threadpool.shutdown();

	}

}

class FactorialClass implements Callable<Long> {

	private long number;

	public FactorialClass(long number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		long result = factorial(this.number);

		return result;
	}

	private long factorial(long number) throws InterruptedException {
		long output = 1;
		if (number < 0) {
			throw new IllegalArgumentException("Number must be greater then 0...");
		}

		while (number > 0) {
			Thread.sleep(1000); // adding delay for example
			output = output * number;
			number--;

		}
		return output;
	}

}
