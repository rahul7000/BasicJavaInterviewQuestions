package com.rahul.javainterview;

public class DivideBy3Or5 {

	public static void main(String[] args) {
		System.out.println("Divided by 3 ");
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + "  ");
			}
		}
		System.out.println("\nDivided by 5 ");
		for (int i = 1; i < 100; i++) {
			if (i % 5 == 0) {
				System.out.print(i + "  ");
			}
		}
		System.out.println("\nDivided by 3 and 5 ");
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print(i + "  ");
			}
		}
		String dividedBy3 = "";
		String dividedBy5 = "";
		String dividedByBoth = "";

		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				dividedBy3 += i + ", ";
			}
			if (i % 5 == 0) {
				dividedBy5 += i + ", ";
			}
			if (i % 3 == 0 && i % 5 == 0) {
				dividedByBoth += i + ", ";
			}
		}

		System.out.println("\nDivided by 3: " + dividedBy3);
		System.out.println("Divided by 5: " + dividedBy5);
		System.out.println("Divided by 3 & 5: " + dividedByBoth);
	}
}
