package com.custom.datastructure.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import com.custom.datastructure.cache.implementation.model.Deneme;
import com.custom.datastructure.stack.impl.MaxStack;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//		Map<Integer, Deneme> denemeMap = new HashMap<>();
//
//		for (int i = 0; i < 50; i++) {
//			denemeMap.put(i, new Deneme(1, "batuhan" + i));
//		}
//
//		denemeMap.remove(1);
//		denemeMap.put(48, new Deneme(1, "batuhan" + "temp"));
//		System.out.println(denemeMap.get(48).hashCode());
//		System.out.println(denemeMap.get(46).hashCode());
//
//		System.out.println("aq");

//		int i = 1;
//		Object key = i;
//		int h;
//		int abc = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//		System.out.println(abc);
//
//		Deneme deneme1 = new Deneme(1, "deneme1");
//		Deneme deneme2 = new Deneme(1, "deneme1");
//		System.out.println(deneme1.equals(deneme2));
		
		MaxStack<Integer> maxStack = new MaxStack<>();
		maxStack.push(1);
		maxStack.push(3);
		maxStack.push(2);
		maxStack.push(20);

		maxStack.pop();
	
		Optional<Integer> result = maxStack.max();
		System.out.println(result.get());
	}
}
