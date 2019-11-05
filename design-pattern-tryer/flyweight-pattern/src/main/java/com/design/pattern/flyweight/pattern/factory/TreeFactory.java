package com.design.pattern.flyweight.pattern.factory;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.design.pattern.flyweight.pattern.model.TreeType;

public class TreeFactory {

	private static Map<String, TreeType> treeTypes = new HashMap<>();

	public static TreeType getTreeType(String name, Color color, String otherData) {
		if (!treeTypes.containsKey(name)) {
			treeTypes.put(name, new TreeType(name, color, otherData));
		}

		return treeTypes.get(name);
	}
	
	public static TreeType getTreeType(String name) {
		return treeTypes.get(name);
	}
}
