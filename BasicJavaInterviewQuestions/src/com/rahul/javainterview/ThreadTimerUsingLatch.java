package com.rahul.javainterview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * CountDownLatch works by having a counter initialized with number of threads,
 * which is decremented each time a thread complete its execution by calling latch.countDown(). When count
 * reaches to zero, it means all threads have completed their execution, and
 * thread waiting on latch resume the execution and execution goes to the latch.await() and execute further lines.
 */
public class ThreadTimerUsingLatch {

	public static void main(String... args) {
		/*
		 * this is the main task over which executor service is applied
		 */
		Runnable task = () -> {
			System.out.println("Running task for : " + Thread.currentThread().getName());
		};

		try {
			System.out.println(timer(Executors.newFixedThreadPool(10), 5, task));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * timer is a method having executor service with size 10 and cocurrency 5 and
	 * the task over which thread pool is applied ready latch is used to make 5
	 * thread ready but waiting on start latch to finish start latch is used to do
	 * task by 5 threads done thread is used to
	 */
	private static long timer(ExecutorService executor, int concurrency, Runnable task) throws InterruptedException {

		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		/*
		 * The first interaction with CountDownLatch is with main thread which is goind
		 * to wait for other threads. This main thread must call, CountDownLatch.await()
		 * method immediately after starting other threads. The execution will stop on
		 * await() method till the time, other threads complete their execution.
		 */
		for (int index = 0; index < concurrency; index++) {

			executor.execute(() -> {
				ready.countDown();// start the workers and after that it goes to ready.await() Tell timer to
									// become ready
				try {
					start.await();// wait task till the timers start, here all the threads of pool are waiting to
									// become start counter to be zero
					task.run();

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					done.countDown();// Tell timer that we are done
				}

			});
		}

		ready.await(); // Wait for all worker threads to be ready and mark the start time in next line
		long startNanos = System.nanoTime();
		start.countDown(); // And they are off to perform the task and now goes to start.
		done.await(); // Wait for all workers to finish
		return System.nanoTime() - startNanos;

	}

}
