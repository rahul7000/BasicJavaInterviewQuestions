package com.rahul.javainterview;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DuplicateInLinkedList {
	public static void main(String[] args) {

		List<String> list = new LinkedList<>();
		list.add("AA");
		list.add("RR");
		list.add("SS");
		list.add("AA");
		list.add("RR");

		System.out.println(list);

		Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		for (String str : list) {
			Integer prevValue = map.get(str);
			Integer newValue = (prevValue == null) ? 1 : prevValue + 1;
			map.put(str, newValue);

		}

//		Set<Entry<String, Integer>> entrySet = map.entrySet();
//		Iterator<Entry<String, Integer>> itr = entrySet.iterator();
//		while (itr.hasNext()) {
//			Entry e = itr.next();
//			System.out.println(e.getKey());
//			System.out.println(e.getValue());
//		}

		System.out.println(map);

	}
}
