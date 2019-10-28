package com.object.oriented.design.vending.machine.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bucket {

	private Product product;

	private List<Coin> change;
}
