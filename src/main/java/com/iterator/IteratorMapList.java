package com.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class IteratorMapList {

	public static void main(String[] args) {
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		hm.put(1, 1);
		hm.put(2, 2);
		hm.put(3, 3);

		System.out.println("hashmap  "+hm);
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);

		System.out.println("array list  "+arrayList);
		SortedSet<Integer> sortedSet=new TreeSet<Integer>();
		sortedSet.add(1);
		sortedSet.add(2);
		sortedSet.add(3);

		System.out.println("sorted set :: "+sortedSet);
		System.out.println("*********map for each *****************");
		for(Map.Entry<Integer, Integer> entry:hm.entrySet()){
			System.out.println("key  :: "+entry.getKey()  +"   value  :: "+entry.getValue());
		}
		
		System.out.println("*********map iterator*****************");
		Iterator<Map.Entry<Integer, Integer>>  it=hm.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, Integer> temp=it.next();
			System.out.println("key  ::"+ temp.getKey() +"   value   ::  "+temp.getValue());
		}
		
		
		System.out.println("*********list iterator*****************");
		Iterator<Integer>  itList=arrayList.iterator();
		
		while(itList.hasNext()){
			int temp=itList.next();
			System.out.println("temp     "+temp);
		}
	}

}
