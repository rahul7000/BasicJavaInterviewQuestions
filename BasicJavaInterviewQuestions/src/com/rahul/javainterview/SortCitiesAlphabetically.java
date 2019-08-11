package com.rahul.javainterview;

import java.util.Arrays;
import java.util.Comparator;

public class SortCitiesAlphabetically {

	public static void main(String[] args) {
		String[] cities = { "Agra", "Madhya Pradesh", "Delhi", "Kolkata", "UP" };
		for (String str : cities) {
			System.out.println(str);
		}
		System.out.println("++++++++++++++++++++++++++++++++");

//		Arrays.sort(cities, new Comparator<String>() {
//
//			@Override
//			public int compare(String city1, String city2) {
//
//				return city1.length() - city2.length();
//			}
//		});

		Comparator<String> comp = ((String one, String two) -> one.length() - two.length());

		Arrays.sort(cities, comp);

		for (String str : cities) {
			System.out.println(str);
		}
	}
}
