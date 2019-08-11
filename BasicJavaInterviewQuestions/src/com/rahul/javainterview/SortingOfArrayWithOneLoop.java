package com.rahul.javainterview;

public class SortingOfArrayWithOneLoop {

	public static void main(String... args) {
		int count = 0;
		int list[] = { 45, 78, 22, 96, 10, 87, 68, 2 };
		for (int i = 1; i < list.length; i++) {
			if (list[i] < list[i - 1]) {
				list[i] = list[i] + list[i - 1];
				list[i - 1] = list[i] - list[i - 1];
				list[i] = list[i] - list[i - 1];
				i = 0;
				count++;
			}
			count++;
		}
		System.out.println(count);
		System.out.print("Sorted array is : ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
}
