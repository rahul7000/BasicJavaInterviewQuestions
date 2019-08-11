package com.rahul.javainterview;

import java.time.Duration;
import java.time.Instant;

public class MethodExecutionTimeUsingDuration {

	// A Duration object (java.time.Duration) represents a period of time between
	// two Instant objects.
	// The Duration class was added to the Java date time API from Java 8.

	// The Instant class in the Java date time API (java.time.Instant) represents a
	// specific moment on the time line.
	public static void main(String[] args) {
		MethodExecutionTimeUsingDuration o = new MethodExecutionTimeUsingDuration();
		Instant start = Instant.now();
		o.timeMeasure();
		Instant end = Instant.now();

		// Duration totalTime = Duration.between(start, end);
		long totalTime = Duration.between(start, end).getNano();
		System.out.println("Total time : " + totalTime + " Nano Seconds");
	}

	private void timeMeasure() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
