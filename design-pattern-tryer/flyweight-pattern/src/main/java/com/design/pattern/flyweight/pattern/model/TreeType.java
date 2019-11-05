package com.design.pattern.flyweight.pattern.model;

import java.awt.Color;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class TreeType {

	private final String name;

	private final Color color;

	private final String otherData;
}
