package com.object.oriented.design.shopping.system.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

	private UUID id;

	private String name;

	private double price;

	private ProductCategory category;
}
