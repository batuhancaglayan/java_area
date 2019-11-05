package com.design.pattern.flyweight.pattern.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.design.pattern.flyweight.pattern.model.Tree;
import com.design.pattern.flyweight.pattern.model.TreeType;

public class Forest {

	private List<Tree> trees = new ArrayList<>();

	public void plantTree(int x, int y, String name, Color color, String otherData) {
		// new TreeType(name, color, otherData)
		// TreeFactory.getTreeType(name, color, otherData)
		trees.add(new Tree(x, y, new TreeType(name, color, otherData)));
	}
}
